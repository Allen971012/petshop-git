package home.petshop.paypal.controller;

import com.netflix.discovery.converters.Auto;
import home.petshop.paypal.service.IPaypalService;
import home.petshop.paypal.vo.ApproveVo;
import home.petshop.paypal.vo.PaypalVo;
import home.petshop.commons.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/paypal")
@Slf4j
public class PayPalController {

    @Autowired
    private IPaypalService paypalService;

    @PostMapping("/pay")
    public R payByPayPal(PaypalVo paypalVo , @AuthenticationPrincipal UserDetails userDetails){
        log.debug("Controller zipcode:{}",paypalVo.getZipcode());
        log.debug("Controller city:{}",paypalVo.getCity());
        log.debug("Controller district:{}",paypalVo.getDistrict());
        log.debug("Controller detail:{}",paypalVo.getDetail());
        log.debug("Controller orderNum:{}",paypalVo.getOrderNum());
        log.debug("Controller total:{}",paypalVo.getTotal());
        String username = userDetails.getUsername();
        ApproveVo approveVo = new ApproveVo();
        paypalService.payByPaypal(paypalVo,approveVo,username);
        log.debug("Controller approve={}",approveVo.getApprove());
        return R.ok(approveVo.getApprove());
    }

    @GetMapping("/capture")
    public R captureOrder(String orderId){
        log.debug("進入captureOrder Controller");
        log.debug("orderId:{}",orderId);
        paypalService.paypalCaptureOrder(orderId);
        return R.ok("捕獲訂單成功");
    }

    @GetMapping("/updatePayStatus")
    public R updatePayStatus(String orderNum){
        log.debug("updatePayStatus Controller orderNum:{}",orderNum);
        paypalService.updatePayStatus(orderNum);
        return R.ok("修改付款狀態成功");
    }
}
