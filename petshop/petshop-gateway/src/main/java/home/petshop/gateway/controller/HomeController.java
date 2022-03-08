package home.petshop.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@Slf4j
public class HomeController {
    /*
    顯示註冊頁面
     */
    @GetMapping("/register.html")
    public String register(){
        log.debug("進入registerController");
        return "/system/register";
    }

    /*
    顯示登入頁面
     */
    @GetMapping("/login.html")
    public String showLogin(HttpServletRequest request){
        String url = request.getHeader("Referer");
        log.debug("preurl:{}",url);
        if("http://localhost:9000/index.html".equals(url)){
            url = "http://localhost:9000/index_user.html";
        }else if("http://localhost:9000/register.html".equals(url)){
            url = "http://localhost:9000/index_user.html";
        }else if("http://localhost:9000/login.html".equals(url)){
            url = "http://localhost:9000/index_user.html";
        }else if(url==null){
            url = "http://localhost:9000/index_user.html";
        }
        request.getSession().setAttribute("preLogin",url);
        log.debug("afterurl:{}",url);
        return "/system/login";
    }

    /*
    顯示已登入首頁
     */
    @GetMapping("/index_user.html")
    public String showIndexUser(){
        return "/index/index_user";
    }

    /*
    顯示未登入首頁
     */
    @GetMapping("/index.html")
    public String showIndex(@AuthenticationPrincipal User user){
        log.debug("user:{}",user);
        if(user!=null){
            log.debug("有登入,轉到index_user");
            return "/index/index_user";
        }else {
            log.debug("沒登入,轉到index");
            return "/index/index";
        }
    }

    /*
    顯示修改頁面
     */
    @GetMapping("/update.html")
    public String showUpdate(){
        return "/system/update";
    }

    /*
    顯示產品頁面(按標籤分)
     */
    @GetMapping("/product.html")
    public String showProduct(){
        return "/product/product";
    }

    /*
    顯示產品頁面(種類分)
     */
    @GetMapping("/products.html")
    public String showProducts(){
        return "/product/products";
    }

    /*
    顯示產品詳細頁面
     */
    @GetMapping("/product_detail.html")
    public String showProductDetail(){
        return "/product/product_detail";
    }

    /*
    顯示全部特價商品
     */
    @GetMapping("/promotion_product.html")
    public String showPromotionProduct(){
        return "/product/promotion_product";
    }

    /*
    顯示產品詳細頁(特價)
     */
    @GetMapping("/promotion_detail.html")
    public String showPromotionDetail(){
        return "/product/promotion_detail";
    }

    /*
    顯示購物車頁面
     */
    @GetMapping("/shoppingcart.html")
    public String showShoppingCart(){
        return "/shop/shoppingcart";
    }

    /*
    顯示訂單確認頁面
     */
    @GetMapping("/orderconfirm.html")
    public String showOrderConfirm(){
        return "/shop/orderconfirm";
    }

    /*
    顯示訂單詳情頁面
     */
    @GetMapping("/orderdetail.html")
    public String showOrderDetail(){
        return "/order/order_detail";
    }

    /*
    顯示所有訂單頁面
     */
    @GetMapping("ordertrackbyusername.html")
    public String showOrderTrackByUsername(){
        return "/order/order_trackbyusername";
    }

    /*
    顯示查詢訂單頁面
     */
    @GetMapping("/ordertracking.html")
    public String showOrderTracking(){
        return "/order/order_tracking";
    }


    /*
    顯示搜索頁面
     */
    @GetMapping("/search.html")
    public String showSearch(){
        log.debug("顯示search.html");
        return "/product/search";
    }


















}
