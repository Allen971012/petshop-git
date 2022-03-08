package home.petshop.commons.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 瞥庈靡想
     */
    @TableField("city")
    private String city;

    /**
     * ?^郖靡想
     */
    @TableField("district")
    private String district;

    /**
     * 赩綒?^??
     */
    @TableField("zipcode")
    private Integer zipcode;

    /**
     * ????華硊
     */
    @TableField("detail")
    private String detail;


}
