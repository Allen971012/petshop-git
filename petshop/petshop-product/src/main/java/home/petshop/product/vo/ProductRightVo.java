package home.petshop.product.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ProductRightVo implements Serializable {

    private Integer id;
    private String title;
    private Integer status;
    private Integer productId;
}
