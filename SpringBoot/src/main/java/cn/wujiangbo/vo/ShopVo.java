package cn.wujiangbo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author tangrufei
 * @date 2022-10-07 15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopVo {
    private String orderId;
    private String totalPrices;
    private String shopName;
    private BigDecimal price;
    private Integer account;
    private String describee;
}
