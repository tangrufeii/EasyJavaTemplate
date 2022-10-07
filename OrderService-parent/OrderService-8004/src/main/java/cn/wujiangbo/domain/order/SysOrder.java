package cn.wujiangbo.domain.order;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import cn.wujiangbo.domain.base.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wujiangbo(weixin:wjb1134135987)
 * @since 2022-10-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="sys_order 表对应的实体对象", description="")
public class SysOrder extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_Id", type = IdType.AUTO)
    private String orderId="de19999999999999";

    @TableField(value = "total_prices")
    private BigDecimal totalPrices;

    @TableField(value = "shop_name")
    private String shopName;

    @TableField(value = "describee")
    private String describee;
}