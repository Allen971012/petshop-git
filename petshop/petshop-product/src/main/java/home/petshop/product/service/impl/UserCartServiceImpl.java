package home.petshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import home.petshop.product.mapper.UserCartMapper;
import home.petshop.commons.model.User;
import home.petshop.commons.model.UserCart;
import home.petshop.product.service.IUserCartService;
import home.petshop.commons.service.ServiceException;
import home.petshop.product.vo.AddShopCartVo;
import home.petshop.product.vo.ShopListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author home
 * @since 2022-01-11
 */
@Service
@Slf4j
public class UserCartServiceImpl extends ServiceImpl<UserCartMapper, UserCart> implements IUserCartService {

    @Autowired
    private UserCartMapper userCartMapper;

    @Autowired
    private RestTemplate restTemplate;

    //新增購物車
    @Transactional
    public void addUserCart(AddShopCartVo addShopCartVo,String username) {
        if(username==null){
            throw ServiceException.unAuthorized("用戶尚未登入");
        }
        Integer productId = addShopCartVo.getProductId();
        if(productId == null){
            throw ServiceException.invalidRequest("商品id為空");
        }
        Integer count = addShopCartVo.getCount();
        if(count==null || count<=0 ||count>100){
            throw ServiceException.invalidRequest("商品數量不正確");
        }
        //獲得該用戶購物清單內商品
        List<ShopListVo> shopLists = getShopListByUserId(username);
        for(ShopListVo s : shopLists){
            if(s.getId().equals(productId)){
                throw ServiceException.invalidRequest("該商品已經在購物車,請至購物車調整數量");
            }
        }
        //獲得當前用戶id
        Integer userId = getUserId(username);
        UserCart userCart = new UserCart()
                .setProductId(productId)
                .setUserId(userId)
                .setStatus(1)
                .setCreatetime(LocalDateTime.now())
                .setCount(count);
        int rows = userCartMapper.insert(userCart);
        if(rows!=1){
            throw new ServiceException("數據庫繁忙,請稍後再試");
        }
        log.debug("購物清單新增成功");
    }

    //查詢該用戶購物清單內商品
    public List<ShopListVo> getShopListByUserId(String username) {
        if(username==null){
            throw ServiceException.unAuthorized("用戶尚未登入");
        }
        //獲得當前用戶id
        Integer userId = getUserId(username);
        List<ShopListVo> shopLists = userCartMapper.getProductForShopList(userId);
        return shopLists;
    }

    //刪除購物清單內商品
    @Transactional
    public void deleteProductFromShoppingCart(Integer id , String username) {
        if(id==null){
            throw ServiceException.invalidRequest("商品id為空");
        }
        //獲得當前用戶id
        Integer userId = getUserId(username);
        int rows = userCartMapper.deleteProductFromShopList(id,userId);
        if(rows!=1){
            throw new ServiceException("數據庫繁忙,請稍後再試");
        }
        log.debug("已刪除購物清單中id為"+id+"商品");
    }

    //修改購物車某商品數量
    @Transactional
    public void updateProductCount(Integer id, Integer count) {
        if(id==null || count == null){
            throw ServiceException.invalidRequest("參數為空");
        }
        int rows = userCartMapper.updateProductCount(count,id);
        if(rows!=1){
            throw new ServiceException("數據庫繁忙,請稍後再試");
        }
        log.debug("修改商品數量完成");
    }

    //將購物清單內商品全部status=0
    @Transactional
    public void deleteAllProduct(String username) {
        //獲得當前用戶id
        Integer userId = getUserId(username);
        int rows = userCartMapper.deleteAllProduct(userId);
        if(rows<=0){
            throw new ServiceException("數據庫繁忙,請稍後再試");
        }
        log.debug("已刪除購物清單中所有商品");
    }

    //使用ribbon到gateway獲得當前用戶,並返回用戶Id
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

    //使用ribbon 根據userId獲得購物車內所有商品
    public List<ShopListVo> getAllShopList(Integer userId) {
        if(userId==null){
            throw ServiceException.unAuthorized("用戶尚未登入");
        }
        List<ShopListVo> shopLists = userCartMapper.getProductForShopList(userId);
        return shopLists;
    }

    /*
    使用ribbon 傳遞userId將該用戶購物車全部刪除
     */
    @GetMapping("/remove")
    public Integer removeAllShopList(Integer userId){
        if(userId==null){
            throw ServiceException.unAuthorized("用戶尚未登入");
        }
        Integer rows = userCartMapper.deleteAllProduct(userId);
        return rows;
    }
}
