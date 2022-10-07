package cn.wujiangbo.feign;

import cn.wujiangbo.domain.order.SysOrder;
import cn.wujiangbo.result.JSONResult;
import cn.wujiangbo.vo.ShopVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("order-server")
public interface OrderClient {
    @PostMapping(value="/sysOrder/save")
    JSONResult save(@RequestBody ShopVo shopVo);
}
