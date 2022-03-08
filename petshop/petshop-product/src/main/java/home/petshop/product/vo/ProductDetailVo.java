package home.petshop.product.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ProductDetailVo implements Serializable {
    private Integer id;
    private String title;
    private Integer price;
    private String content;
    private String img;
}
