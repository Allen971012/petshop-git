package home.petshop.paypal.vo;

import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ApproveVo implements Serializable {
    private String approve;
    private HttpResponse<Order> orderHttpResponse;
}
