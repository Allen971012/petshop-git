package home.petshop.paypal.service;

import home.petshop.paypal.vo.ApproveVo;
import home.petshop.paypal.vo.PaypalVo;

public interface IPaypalService {

    /*
    Paypal建立訂單
     */
    void payByPaypal(PaypalVo paypalVo, ApproveVo approveVo , String username);

    /*
    paypal捕獲訂單
     */
    void paypalCaptureOrder(String orderId);

    /*
    修改付款狀態=1
     */
    void updatePayStatus(String orderNum);
}
