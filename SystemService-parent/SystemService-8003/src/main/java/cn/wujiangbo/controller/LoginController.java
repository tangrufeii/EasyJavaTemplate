package cn.wujiangbo.controller;

import cn.hutool.crypto.SecureUtil;
import cn.wujiangbo.constants.ErrorCode;
import cn.wujiangbo.constants.SystemConstants;
import cn.wujiangbo.domain.system.SysUser;
import cn.wujiangbo.exception.MyException;
import cn.wujiangbo.mapper.system.SysUserMapper;
import cn.wujiangbo.result.JSONResult;
import cn.wujiangbo.service.VerifycodeService;
import cn.wujiangbo.util.MyTools;
import cn.wujiangbo.vo.UserTokenVo;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description 系统登录API
 * @author wujiangbo(weixin:wjb1134135987)
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private VerifycodeService verifycodeService;

    /**
     * @desc 系统登录接口
     * @author wujiangbo
     * @date 2022/6/5 16:25
     */
    @PostMapping("/login")
    public JSONResult login(@RequestBody SysUser user){
        //检验验证是否为空
        if(!MyTools.hasLength(user.getImageCode())){
            throw new MyException(ErrorCode.ERROR_CODE_1008);
        }
        if(!MyTools.hasLength(user.getImageCodeKey())){
            throw new MyException(ErrorCode.ERROR_CODE_1010);
        }
        //入参校验
        if(!MyTools.hasLength(user.getUserName())){
            throw new MyException(ErrorCode.ERROR_CODE_1003);
        }
        if(!MyTools.hasLength(user.getPassword())){
            throw new MyException(ErrorCode.ERROR_CODE_1004);
        }
        //校验验证码是否正确
        String code = (String)redisTemplate.opsForValue().get(user.getImageCodeKey());
        if(code == null){
            throw new MyException(ErrorCode.ERROR_CODE_1009);
        }
        if(!code.equals(user.getImageCode())){
            throw new MyException(ErrorCode.ERROR_CODE_1009);
        }
        //查看账号是否存在
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", user.getUserName());
        List<SysUser> sysUserList = sysUserMapper.selectList(queryWrapper);
        if(CollectionUtils.isEmpty(sysUserList)){
            throw new MyException(ErrorCode.ERROR_CODE_1005);
        }
        if(sysUserList.size() > 1){
            throw new MyException(ErrorCode.ERROR_CODE_1006);
        }

        //开始验证密码是否正确
        SysUser sysUser = sysUserList.get(0);
        if(!sysUser.getPassword().equalsIgnoreCase(SecureUtil.md5(user.getPassword()))){
            throw new MyException(ErrorCode.ERROR_CODE_1007);
        }

        //用户信息存Redis
        String token = MyTools.getLoginToken();
        //用户信息存储到Redis
        redisTemplate.opsForValue().set(token, JSONObject.toJSONString(sysUser), SystemConstants.LOGIN_TIME_OUT, TimeUnit.MINUTES);

        //返回token及相关用户信息给前端
        UserTokenVo vo = new UserTokenVo();
        vo.setToken(token);
        vo.setAvatar(sysUser.getAvatar());
        vo.setUserName(sysUser.getUserName());
        return JSONResult.success(vo);
    }
    @RequestMapping("/verifycode/imageCode/{uuid}")
    public JSONResult verifycode(@PathVariable("uuid") String uuid) {
        return verifycodeService.verifyCode(uuid);
    }
}