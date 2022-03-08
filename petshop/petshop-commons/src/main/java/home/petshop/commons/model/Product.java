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
@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品標題
     */
    @TableField("title")
    private String title;

    /**
     * 商品價格
     */
    @TableField("price")
    private Integer price;

    /**
     * 商品介紹html代碼
     */
    @TableField("content")
    private String content;

    /**
     * 商品圖片
     */
    @TableField("img")
    private String img;

    /**
     * 上架時間
     */
    @TableField("createtime")
    private LocalDateTime createtime;

    /**
     * 商品標籤組
     */
    @TableField("tag_names")
    private String tagNames;

    /**
     * 點擊次數
     */
    @TableField("click_count")
    private Integer clickCount;


}
