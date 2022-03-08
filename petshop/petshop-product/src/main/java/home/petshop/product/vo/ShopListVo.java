package home.petshop.product.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ShopListVo implements Serializable {

    private Integer id;
    private String title;
    private String img;
    private Integer oprice;
    private Integer price;
    private Integer count;
}
