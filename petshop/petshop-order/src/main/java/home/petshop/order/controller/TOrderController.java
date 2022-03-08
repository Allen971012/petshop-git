package home.petshop.order.controller;


import home.petshop.order.service.ITOrderService;
import home.petshop.order.vo.OrderDetailVo;
import home.petshop.order.vo.OrderProductVo;
import home.petshop.order.vo.OrderVo;
import home.petshop.commons.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
@RestController
@RequestMapping("/v1/order")
@Slf4j
public class TOrderController {

    @Autowired
    private ITOrderService itOrderService;
    /*
    建立訂單
     */
    @PostMapping("/add")
    public R<String> addOrder(OrderVo orderVo , @AuthenticationPrincipal UserDetails userDetails){
        log.debug("order:{}",orderVo);
        String username = userDetails.getUsername();
        log.debug("addOrder Controller username:{}",username);
        String orderNum = itOrderService.addOrder(orderVo,username);
        log.debug("controller orderNum:{}",orderNum);
        return R.ok(orderNum);
    }

    /*
    查詢訂單(檢查是否有此訂單)
     */
    @PostMapping("/select")
    public R<OrderDetailVo> selectOrder(String orderNum){
        log.debug("orderNum:{}",orderNum);
        OrderDetailVo order = itOrderService.selectOrderDetail(orderNum);
        if(order==null){
            return R.unprocesableEntity("(查無訂單,請檢查訂單編號是否正確)");
        }else{
            return R.ok(order);
        }
    }

    /*
    查詢訂單
     */
    @GetMapping("/select/{orderNum}")
    public R<OrderDetailVo> showOrderInfo(@PathVariable String orderNum){
        log.debug("orderNum:{}",orderNum);
        OrderDetailVo order = itOrderService.selectOrderDetail(orderNum);
        return R.ok(order);
    }

    /*
    查詢訂單商品內容
     */
    @GetMapping("/selectOrderProduct/{orderNum}")
    public R<List<OrderProductVo>> selectOrderProduct(@PathVariable String orderNum){
        log.debug("進入selectOrderProduct controller");
        List<OrderProductVo> products = itOrderService.selectOrderProduct(orderNum);
        return R.ok(products);
    }

    /*
    查詢所有訂單編號
     */
    @PostMapping("/selectAllOrder")
    public R<String> selectAllOrder(String username , String phone , @AuthenticationPrincipal UserDetails userDetails){
        log.debug("username:{}",username);
        log.debug("phone:{}",phone);
        String name = userDetails.getUsername();
        List<String>orderNums = itOrderService.selectAllOrderNum(username,phone,name);
        if(orderNums.isEmpty()){
            return R.unprocesableEntity("查無訂單");
        }else{
            return R.ok(orderNums);
        }
    }
}
