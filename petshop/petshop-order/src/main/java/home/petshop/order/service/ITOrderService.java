package home.petshop.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import home.petshop.commons.model.TOrder;
import home.petshop.order.vo.OrderDetailVo;
import home.petshop.order.vo.OrderProductVo;
import home.petshop.order.vo.OrderVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
public interface ITOrderService extends IService<TOrder> {
    /*
    新增訂單
     */
    String addOrder(OrderVo orderVo , String username);

    /*
    查詢訂單資訊
     */
    OrderDetailVo selectOrderDetail(String orderNum);

    /*
    查詢訂單商品內容
     */
    List<OrderProductVo> selectOrderProduct(String orderNum);

    /*
    查詢該用戶所有訂單編號
     */
    List<String> selectAllOrderNum(String username , String phone ,String name);

    /*
    使用ribbon到gateway獲得userId
     */
    Integer getUserId(String username);

    /*
    根據orderNum刪除訂單
     */
    //void deleteOrderByOrderNum(String orderNum);

    /*
    paypal建立訂單
     */
    //void payByPaypal(PaypalVo paypalVo, ApproveVo approveVo);

    /*
    paypal捕獲訂單
     */
    //void paypalCaptureOrder(String orderId);

    /*
    修改付款狀態=1
     */
    //void updatePayStatus(String orderNum);
}
