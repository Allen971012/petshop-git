package home.petshop.commons.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author home
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_order")
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * ???徆???
     */
    @TableField("order_num")
    private String orderNum;

    @TableField("product_id")
    private Integer productId;

    @TableField("user_id")
    private Integer userId;

    @TableField("price")
    private Integer price;

    @TableField("count")
    private Integer count;

    /**
     * ???帠匢??r嶲
     */
    @TableField("createtime")
    private LocalDateTime createtime;

    /**
     * 窣篌????
     */
    @TableField("phone")
    private String phone;

    /**
     * 0渾葆遴,1眒葆遴
     */
    @TableField("pay_status")
    private Integer payStatus;


}
