package home.petshop.paypal.service.impl;

import com.paypal.http.HttpResponse;
import com.paypal.orders.LinkDescription;
import com.paypal.orders.Order;
import com.paypal.payments.Capture;
import home.petshop.commons.service.ServiceException;
import home.petshop.paypal.mapper.PaypalMapper;
import home.petshop.paypal.paypal.AuthorizeIntentExamples.AuthorizeOrder;
import home.petshop.paypal.paypal.AuthorizeIntentExamples.CaptureOrder;
import home.petshop.paypal.paypal.AuthorizeIntentExamples.CreateOrder;
import home.petshop.paypal.service.IPaypalService;
import home.petshop.paypal.vo.ApproveVo;
import home.petshop.paypal.vo.PaypalOrderVo;
import home.petshop.paypal.vo.PaypalVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PaypalServiceImpl implements IPaypalService {

    @Resource
    private PaypalMapper paypalMapper;

    /*
    Paypal建立訂單
     */
    public void payByPaypal(PaypalVo paypalVo, ApproveVo approveVo , String username) {
        if(username==null){
            throw ServiceException.unAuthorized("用戶尚未登入");
        }
        log.debug("進入payByPaypal Service");
        String approve = null;
        log.debug("orderNum:{}",paypalVo.getOrderNum());
        //查詢訂單title,price,count
        List<PaypalOrderVo> paypalOrderVos = paypalMapper.selectForPayPal(paypalVo.getOrderNum());
        paypalOrderVos.forEach(paypalOrderVo -> log.debug("paypalOrderVo:{}",paypalOrderVo));
        try {
            // 創建訂單
            HttpResponse<Order> orderResponse = new CreateOrder().createOrder(true,paypalVo,paypalOrderVos,username);
            String orderId = "";
            System.out.println("Creating Order...");
            if (orderResponse.statusCode() == 201){
                orderId = orderResponse.result().id();
                System.out.println("Order ID: " + orderId);
                System.out.println("Links:");
                for (LinkDescription link : orderResponse.result().links()) {
                    System.out.println("\t" + link.rel() + ": " + link.href());
                    if("approve".equals(link.rel())){
                        log.debug("approve");
                        approve = link.href();
                        approveVo.setApprove(approve);
                        log.debug("approve:{}",approveVo.getApprove());
                    }
                }
            }
            approveVo.setOrderHttpResponse(orderResponse);
            System.out.println("Created Successfully\n");
            System.out.println("Copy approve link and paste it in browser. Login with buyer account and follow the instructions.\nOnce approved hit enter...");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
    Paypal捕獲訂單
     */
    public void paypalCaptureOrder(String orderId) {
        log.debug("進入paypalCaptureOrder Service");
        if(orderId==null){
            throw ServiceException.unprocesableEntity("orderId為空");
        }
        try {
            HttpResponse<Order> orderResponse = new ApproveVo().getOrderHttpResponse();
            log.debug("Controller orderResponse:{}", orderResponse);
            //授權訂單
            System.out.println("Authorizing Order...");
            orderResponse = new AuthorizeOrder().authorizeOrder(orderId, true);
            String authId = "";
            if (orderResponse.statusCode() == 201) {
                System.out.println("Authorized Successfully\n");
                authId = orderResponse.result().purchaseUnits().get(0).payments().authorizations().get(0).id();
            }
            //捕獲訂單
            System.out.println("Capturing Order...");
            HttpResponse<Capture> captureOrderResponse = new CaptureOrder().captureOrder(authId, true);
            if (orderResponse.statusCode() == 201){
                System.out.println("Captured Successfully");
                System.out.println("Status Code: " + captureOrderResponse.statusCode());
                System.out.println("Status: " + captureOrderResponse.result().status());
                System.out.println("Capture ID: " + captureOrderResponse.result().id());
                System.out.println("Links: ");
                for (com.paypal.payments.LinkDescription link : captureOrderResponse.result().links()) {
                    System.out.println("\t" + link.rel() + ": " + link.href() + "\tCall Type: " + link.method());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
    修改付款狀態=1
     */
    public void updatePayStatus(String orderNum) {
        if(orderNum==null){
            throw ServiceException.unprocesableEntity("orderNum為空");
        }
        int rows = paypalMapper.updatePayStatus(orderNum);
        if(rows<=0){
            throw new ServiceException("服務器繁忙,請稍後再試");
        }
        log.debug("Service 修改付款狀態成功");
    }
}
