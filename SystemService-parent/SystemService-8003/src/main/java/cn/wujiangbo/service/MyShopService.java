package cn.wujiangbo.service;

import cn.wujiangbo.result.JSONResult;
import cn.wujiangbo.vo.ShopVo;

public interface MyShopService {
    JSONResult buy(ShopVo shopVo);
}
