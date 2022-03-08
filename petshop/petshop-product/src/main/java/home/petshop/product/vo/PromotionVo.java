package home.petshop.product.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class PromotionVo implements Serializable {
    private Integer id;
    private Integer productId;
    private LocalDateTime expiredate;
    private Integer status;
    private Integer price;
    private String title;
    private Integer oprice;
    private String img;
}
