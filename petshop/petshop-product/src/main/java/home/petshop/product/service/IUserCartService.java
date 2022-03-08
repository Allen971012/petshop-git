package home.petshop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import home.petshop.commons.model.User;
import home.petshop.commons.model.UserCart;
import home.petshop.product.vo.AddShopCartVo;
import home.petshop.product.vo.ShopListVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author home
 * @since 2022-01-11
 */
public interface IUserCartService extends IService<UserCart> {
    //新增購物車
    void addUserCart(AddShopCartVo addShopCartVo,String username);

    //查詢該用戶購物清單內商品
    List<ShopListVo> getShopListByUserId(String username);

    //將購物清單內商品status改為0(刪除)
    void deleteProductFromShoppingCart(Integer id , String username);

    //修改購物車某商品數量
    void updateProductCount(Integer id , Integer  count);

    //將購物清單內商品全部status=0
    void deleteAllProduct(String username);

    //使用ribbon到gateway獲得當前用戶,並返回用戶Id
    Integer getUserId(String username);

    //使用ribbon 根據userId獲得購物車內所有商品
    List<ShopListVo> getAllShopList(Integer userId);
}
