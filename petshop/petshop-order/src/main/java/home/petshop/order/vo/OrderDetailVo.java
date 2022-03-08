package home.petshop.order.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class OrderDetailVo implements Serializable {

    private String orderNum;
    private LocalDateTime createtime;
    private String phone;
    private Integer payStatus;
    private Integer zipcode;
    private String city;
    private String district;
    private String detail;

}
