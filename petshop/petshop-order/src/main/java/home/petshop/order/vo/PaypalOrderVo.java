package home.petshop.order.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PaypalOrderVo implements Serializable {
    private String title;
    private Integer price;
    private Integer count;

}
