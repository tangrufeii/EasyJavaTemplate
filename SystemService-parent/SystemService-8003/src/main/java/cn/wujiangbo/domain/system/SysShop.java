package cn.wujiangbo.domain.system;

import cn.wujiangbo.domain.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

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
@ApiModel(value="sys_shop 表对应的实体对象", description="")
public class SysShop extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品名称")
    @TableField(value = "shop_name")
    private String shopName;

    @ApiModelProperty(value = "价格")
    @TableField(value = "price")
    private BigDecimal price;

    @ApiModelProperty(value = "库存")
    @TableField(value = "stock")
    private Long stock;

    @ApiModelProperty(value = "商品描述")
    @TableField(value = "describee")
    private String describee;
}