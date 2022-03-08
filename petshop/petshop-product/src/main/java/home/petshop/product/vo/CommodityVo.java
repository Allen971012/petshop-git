package home.petshop.product.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(chain = true)
public class CommodityVo implements Serializable {
    private Integer id;
    private String title;
    private Integer price;
    private Integer oprice;
    private String img;
    private Integer status;
    private Integer clickCount;
}
