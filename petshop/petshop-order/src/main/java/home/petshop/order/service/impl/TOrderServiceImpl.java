package home.petshop.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import home.petshop.commons.model.User;
import home.petshop.order.mapper.AddressMapper;
import home.petshop.order.mapper.AddressOrderMapper;
import home.petshop.order.mapper.TOrderMapper;
import home.petshop.commons.model.Address;
import home.petshop.commons.model.TOrder;
import home.petshop.order.service.ITOrderService;
import home.petshop.commons.service.ServiceException;
import home.petshop.order.vo.OrderDetailVo;
import home.petshop.order.vo.OrderProductVo;
import home.petshop.order.vo.OrderVo;
import home.petshop.order.vo.ShopListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
@Service
@Slf4j
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private AddressOrderMapper addressOrderMapper;

    @Autowired
    private RestTemplate restTemplate;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /*
    新增訂單
     */
    @Transactional
    public String addOrder(OrderVo orderVo , String username) {
        if(orderVo==null){
            throw ServiceException.unprocesableEntity("orderVo為空");
        }
        if(username==null){
            throw ServiceException.unAuthorized("用戶尚未登入");
        }
        //獲得當前userId
        Integer userId = getUserId(username);
        if(userId==null){
            throw ServiceException.unAuthorized("尚未登入");
        }
        //亂數產出訂單編號(orderNum)
        String orderNum = UUID.randomUUID().toString();
        if(orderNum==null){
            throw ServiceException.unprocesableEntity("訂單編號錯誤");
        }
        log.debug("orderNum:{}",orderNum);
        //查出該用戶購物車內所有商品
        String url = "http://product-service/v1/userCart/shoplist?userId={1}";
        ShopListVo[] products = restTemplate.getForObject(url,ShopListVo[].class,userId);
        if(products.length==0){
            throw ServiceException.unprocesableEntity("該用戶購物車沒有商品");
        }
        //遍歷products,將每個商品加入t_order表
        Integer price;
        Integer count;
        int rows;
        for(ShopListVo product : products){
          if(product.getPrice()==null){
              price = product.getOprice();
          }else{
              price = product.getPrice();
          }
          count = product.getCount();
          //創建order對象
          TOrder order = new TOrder()
                  .setOrderNum(orderNum)
                  .setProductId(product.getId())
                  .setUserId(userId)
                  .setPrice(price)
                  .setCount(count)
                  .setPhone(orderVo.getPhone())
                  .setPayStatus(0)
                  .setCreatetime(LocalDateTime.now());
          rows = tOrderMapper.addOrder(order);
          if(rows!=1){
              throw new ServiceException("服務器繁忙,請稍後再試");
          }
        }
        log.debug("order表新增完成");
        //新增address表
        Address address = new Address()
                .setCity(orderVo.getCity())
                .setDistrict(orderVo.getDistrict())
                .setZipcode(orderVo.getZipcode())
                .setDetail(orderVo.getDetail());
        rows = addressMapper.addAddress(address);
        if(rows!=1){
            throw new ServiceException("服務器繁忙,請稍後再試");
        }
        log.debug("address表新增完成");
        //新增address_order表
        rows = addressOrderMapper.addAddressOrder(orderNum, address.getId());
        if(rows!=1){
            throw new ServiceException("服務器繁忙,請稍後再試");
        }
        log.debug("address_order表新增完成");
        //將用戶購物車清空(status=0)
        rows = tOrderMapper.deleteAllProduct(userId);
        if(rows<=0){
            throw new ServiceException("服務器繁忙,請稍後再試");
        }
        log.debug("購物車已清空");
        log.debug("訂單已建立");
        return orderNum;
    }

    /*
    查詢訂單資訊
     */
    public OrderDetailVo selectOrderDetail(String orderNum) {
        if(orderNum==null){
            throw ServiceException.unprocesableEntity("訂單編號為空");
        }
        OrderDetailVo orderDetailVo = tOrderMapper.selectOrderDetail(orderNum);
        return orderDetailVo;
    }

    /*
    查詢訂單商品內容
     */
    public List<OrderProductVo> selectOrderProduct(String orderNum) {
        if(orderNum==null){
            throw ServiceException.unprocesableEntity("訂單編號為空");
        }
        List<OrderProductVo> products = tOrderMapper.selectOrderProduct(orderNum);
        return products;
    }

    /*
    查詢該用戶所有訂單編號
     */
    public List<String> selectAllOrderNum(String username, String phone ,String name) {
        if(username==null){
            throw ServiceException.unprocesableEntity("用戶名為空");
        }
        if(phone==null){
            throw ServiceException.unprocesableEntity("手機號碼為空");
        }
        if(name==null){
            throw ServiceException.unAuthorized("用戶尚未登入");
        }
        //判斷用戶名是否正確
        if(!(name.equals(username))){
            throw ServiceException.unprocesableEntity("用戶名不正確");
        }
        Integer userId = getUserId(name);
        //查詢訂單編號
        List<String> orderNums = tOrderMapper.selectOrderNum(userId,phone);
        return orderNums;
    }

    /*
    使用ribbon到gateway獲得userId
     */
    public Integer getUserId(String username) {
        String url = "http://sys-service/v1/auth/user?username={1}";
        User user = restTemplate.getForObject(url,User.class,username);
        log.debug("Ribbon user:{}",user);
        Integer userId = user.getId();
        if(userId==null){
            throw ServiceException.unAuthorized("用戶尚未登入");
        }
        return userId;
    }
    /*
    根據orderNum刪除訂單
     */
    /*@Transactional
    public void deleteOrderByOrderNum(String orderNum) {
        if(orderNum==null){
            throw ServiceException.unprocesableEntity("訂單編號不存在");
        }
        //獲得當前用戶id
        Integer userId = Integer.parseInt(userService.getCurrentUserId());
        if(userId==null){
            throw ServiceException.unAuthorized("尚未登入");
        }
        //刪除t_order表
        int rows = tOrderMapper.deleteOrderByOrderNum(orderNum,userId);
        if(rows<=0){
            log.debug("刪除order表失敗");
            throw ServiceException.unprocesableEntity("刪除order失敗");
        }
        //查出addressId
        Integer addressId = tOrderMapper.selectAddressIdByOrderNum(orderNum);
        if(addressId==null){
            throw ServiceException.unprocesableEntity("address為空");
        }
        //刪除address表
        rows = tOrderMapper.deleteAddressById(addressId);
        if(rows!=1){
            log.debug("刪除address表失敗");
            throw ServiceException.unprocesableEntity("刪除order失敗");
        }
        //刪除address_order表
        rows = tOrderMapper.deleteAddressOrderByOrderNum(orderNum);
        if(rows!=1){
            log.debug("刪除address_order表失敗");
            throw ServiceException.unprocesableEntity("刪除order失敗");
        }
        log.debug("刪除訂單完成");
    }*/

    //payPal支付
    /*public void payByPaypal(PaypalVo paypalVo,ApproveVo approveVo) {
        log.debug("進入payByPaypal Service");
        String approve = null;
        log.debug("orderNum:{}",paypalVo.getOrderNum());
        //查詢訂單title,price,count
        List<PaypalOrderVo> paypalOrderVos = tOrderMapper.selectForPayPal(paypalVo.getOrderNum());
        paypalOrderVos.forEach(paypalOrderVo -> log.debug("paypalOrderVo:{}",paypalOrderVo));
        //查詢當前用戶名
        String username = userService.currentUsername();
        if(username == null){
            throw ServiceException.unAuthorized("尚未登入");
        }
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
    }*/

    /*
    paypal捕獲訂單
     */
    /*public void paypalCaptureOrder(String orderId) {
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
    }*/

    /*
    修改付款狀態=1
     */
    /*public void updatePayStatus(String orderNum) {
        if(orderNum==null){
            throw ServiceException.unprocesableEntity("orderNum為空");
        }
        int rows = tOrderMapper.updatePayStatus(orderNum);
        if(rows<=0){
            throw new ServiceException("服務器繁忙,請稍後再試");
        }
        log.debug("Service 修改付款狀態成功");
    }*/
}
