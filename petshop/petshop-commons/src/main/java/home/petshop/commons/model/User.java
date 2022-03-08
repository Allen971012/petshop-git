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
 * @since 2021-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 蚚?藽?
     */
    @TableField("username")
    private String username;

    /**
     * 躇徨
     */
    @TableField("password")
    private String password;

    /**
     * 陓眊
     */
    @TableField("email")
    private String email;

    /**
     * ??????徨
     */
    @TableField("phone")
    private String phone;

    /**
     * 偟???r嶲
     */
    @TableField("createtime")
    private LocalDateTime createtime;

    /**
     * ?厄?岆瘁褫蚚,0瘁,1岆
     */
    @TableField("enabled")
    private Integer enabled;

    /**
     * ?厄?岆瘁掩熵蛂,0瘁,1岆
     */
    @TableField("locked")
    private Integer locked;


}
