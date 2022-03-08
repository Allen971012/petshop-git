package home.petshop.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import home.petshop.commons.model.UserCart;
import home.petshop.product.vo.ShopListVo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author home
* @since 2022-01-11
*/
@Repository
public interface UserCartMapper extends BaseMapper<UserCart> {

    //查詢該用戶購物清單
    @Select("SELECT p.id,p.title,p.img,p.price AS oprice,u.count,pm.price FROM product p " +
            "LEFT JOIN user_cart u ON p.id=u.product_id " +
            "LEFT JOIN promotion pm ON pm.product_id = p.id " +
            "WHERE u.status=1 AND u.user_id=#{id};")
    public List<ShopListVo> getProductForShopList(Integer id);

    //將該用戶購物清單某項目status改為0(已刪除)
    @Update("Update user_cart set status=0 WHERE product_id=#{id} AND user_id=#{userId} AND status=1")
    public int deleteProductFromShopList(Integer id , Integer userId);

    //改變商品數量
    @Update("UPDATE user_cart set count=#{count} WHERE product_id=#{productId} AND status=1")
    public int updateProductCount(Integer count , Integer productId);

    //將該用戶購物清單全部商品status改為0(刪除)
    @Update("UPDATE user_cart set status=0 WHERE user_id=#{userId} AND status=1")
    public int deleteAllProduct(Integer userId);
}
