package home.petshop.paypal.mapper;

import home.petshop.paypal.vo.PaypalOrderVo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaypalMapper {
    /*
    根據orderNum查出title,price,count(paypal創建訂單使用)
     */
    @Select("SELECT p.title,o.price,o.count FROM t_order o " +
            "LEFT JOIN product p ON o.product_id=p.id " +
            "WHERE o.order_num=#{orderNum}")
    List<PaypalOrderVo> selectForPayPal(String orderNum);

    /*
    根據orderNum修改paystatus=1
     */
    @Update("UPDATE t_order SET pay_status=1 WHERE order_num=#{orderNum}")
    int updatePayStatus(String orderNum);

    //將該用戶購物清單全部商品status改為0(刪除)
    @Update("UPDATE user_cart set status=0 WHERE user_id=#{userId} AND status=1")
    public int deleteAllProduct(Integer userId);
}
