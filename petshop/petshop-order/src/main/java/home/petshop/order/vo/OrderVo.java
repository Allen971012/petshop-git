package home.petshop.order.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class OrderVo implements Serializable {
    private String phone;
    private String city;
    private String district;
    private String detail;
    private Integer zipcode;
}
