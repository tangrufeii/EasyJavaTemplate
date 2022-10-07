package cn.wujiangbo.service;

import cn.wujiangbo.result.JSONResult;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author tangrufei
 * @date 2022-10-06 17:54
 */
@Service
public class VerifycodeServiceImpl implements VerifycodeService{
  /*  @Override
    public JSONResult verifyCode(SysUser sysUser) {
        return null;
    }*/
    @Autowired
    private RedisTemplate redisTemplate;

  /*  public JSONResult imageCode1(String uuid) {
        if(!StringUtils.hasLength(uuid)){
            throw new MyException("UUID不能为空");
        }
        //存入redis
        String code = MyTools.getRandomNum(4);

        String base64= VerifyCodeUtils.verifyCode(130,35,code);

        redisTemplate.opsForValue().set(uuid,code);
        //需要一张图片水印验证码,然后将base64编码数据返回给前端
        return JSONResult.success(base64);
    }*/
    @Override
    public JSONResult verifyCode(String uuid) {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 35, 4);
        //设置验证码的类型（可不设置，使用默认值）
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        String code = specCaptcha.text().toLowerCase();

        //存redis
        redisTemplate.opsForValue().set(uuid, code, 2, TimeUnit.MINUTES);

        return JSONResult.success(specCaptcha.toBase64());//生成的base64数据是包含头部信息的
    }
}
