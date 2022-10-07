package cn.wujiangbo.feign;

import cn.wujiangbo.domain.order.SysOrder;
import cn.wujiangbo.result.JSONResult;
import cn.wujiangbo.vo.ShopVo;
import feign.hystrix.FallbackFactory;

/**
 * @author tangrufei
 * @date 2022-10-07 22:39
 */
public class Fallback implements FallbackFactory<OrderClient> {
    @Override
    public OrderClient create(Throwable throwable) {
        return new OrderClient() {

            @Override
            public JSONResult save(ShopVo shopVo) {
                return null;
            }
        };
    }
}
