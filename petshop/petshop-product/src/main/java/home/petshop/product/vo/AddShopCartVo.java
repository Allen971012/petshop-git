package home.petshop.product.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class AddShopCartVo implements Serializable {

    private Integer productId;
    private Integer count;
}
