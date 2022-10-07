package cn.wujiangbo.service;

import cn.wujiangbo.result.JSONResult;


public interface VerifycodeService {
    JSONResult verifyCode(String uuid);

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

}
