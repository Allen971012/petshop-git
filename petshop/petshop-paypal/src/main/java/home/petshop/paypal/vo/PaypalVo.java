package home.petshop.paypal.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PaypalVo implements Serializable {
    private String orderNum;
    private String zipcode;
    private String city;
    private String district;
    private String detail;
    private String total;
}
