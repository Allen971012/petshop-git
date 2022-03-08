package home.petshop.product.controller;


import home.petshop.commons.model.User;
import home.petshop.product.service.IUserCartService;
import home.petshop.product.vo.AddShopCartVo;
import home.petshop.commons.vo.R;
import home.petshop.product.vo.ShopListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author home
 * @since 2022-01-11
 */
@RestController
@RequestMapping("v1/userCart")
@Slf4j
public class UserCartController {

    @Autowired
    private IUserCartService userCartService;

    /*
    新增商品至購物車
     */
    @GetMapping("/add")
    public R addShoppingCart(AddShopCartVo addShopCartVo,@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        userCartService.addUserCart(addShopCartVo,username);
        return R.ok("新增完成");
    }

    /*
    查詢該用戶購物車內商品
     */
    @GetMapping("/select")
    public R<List<ShopListVo>> selectShoppingCart(@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        List<ShopListVo> shopLists = userCartService.getShopListByUserId(username);
        return R.ok(shopLists);
    }

    /*
    刪除用戶購物車內某商品
     */
    @GetMapping("/delete/{id}")
    public R deleteProductFromShoppingCart(@PathVariable Integer id , @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        userCartService.deleteProductFromShoppingCart(id,username);
        return R.ok("刪除完成");
    }

    /*
    刪除用戶購物車所有商品
     */
    @GetMapping("/deleteall")
    public R deleteAllProduct(@AuthenticationPrincipal UserDetails userDetails){
        log.debug("進入deleteall controller");
        String username = userDetails.getUsername();
        userCartService.deleteAllProduct(username);
        return R.ok("刪除所有商品完成");
    }

    /*
    改變購物車內某商品數量
     */
    @GetMapping("/updatecount")
    public R updateProuductCount(Integer id , Integer count){
        userCartService.updateProductCount(id,count);
        return R.ok("修改數量成功");
    }

    /*
    返回用戶購物車內所有商品,ribbon提供者
     */
    @GetMapping("/shoplist")
    public List<ShopListVo> getShopList(Integer userId){
        List<ShopListVo> shopListVos = userCartService.getAllShopList(userId);
        return shopListVos;
    }

    /*
    利用redis session共享 獲得當前用戶信息
     */
    /*@GetMapping("user")
    public User getUserName(@AuthenticationPrincipal UserDetails userDetails){
        log.debug("執行getUserName Controller");
        String username = userDetails.getUsername();
        User user = userCartService.getUser(username);
        log.debug("Controller User:{}",user);
        return user;
    }*/

}
