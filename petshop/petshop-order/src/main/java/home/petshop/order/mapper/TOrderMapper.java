package home.petshop.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import home.petshop.commons.model.TOrder;
import home.petshop.order.vo.OrderDetailVo;
import home.petshop.order.vo.OrderProductVo;
import home.petshop.order.vo.PaypalOrderVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author home
* @since 2021-12-27
*/
@Repository
public interface TOrderMapper extends BaseMapper<TOrder> {

    /*
    新增訂單
     */
    @Insert("INSERT INTO t_order(order_num,product_id,user_id,price,count,phone,pay_status,createtime) " +
            "VALUES(#{orderNum},#{productId},#{userId},#{price}," +
            "#{count},#{phone},#{payStatus},#{createtime})")
    int addOrder(TOrder tOrder);

    /*
    查詢訂單詳情(訂單資訊)
     */
    @Select("SELECT o.order_num,o.createtime,o.phone,o.pay_status,a.zipcode,a.city,a.district," +
            "a.detail " +
            "FROM t_order o " +
            "LEFT JOIN address_order ao ON o.order_num=ao.order_id " +
            "LEFT JOIN address a ON a.id=ao.address_id " +
            "WHERE o.order_num=#{orderNum} " +
            "LIMIT 0,1")
    OrderDetailVo selectOrderDetail(String orderNum);

    /*
    查詢訂單詳情(商品內容)
     */
    @Select("SELECT p.title,o.price,o.count FROM t_order o " +
            "LEFT JOIN product p ON p.id=o.product_id " +
            "WHERE o.order_num=#{orderNum}")
    List<OrderProductVo> selectOrderProduct(String orderNum);

    /*
    根據userId和password查詢所有訂單編號
     */
    @Select("SELECT DISTINCT o.order_num FROM t_order o " +
            "LEFT JOIN user u ON o.user_id=u.id " +
            "WHERE o.user_id=#{userId} AND u.phone=#{phone}")
    List<String> selectOrderNum(@Param("userId") Integer userId, @Param("phone") String phone);

    /*
    刪除訂單(根據orderNum刪除t_order表)
     */
    @Delete("DELETE FROM t_order WHERE order_num=#{orderNum} AND user_id=#{userId}")
    int deleteOrderByOrderNum(@Param("orderNum") String orderNum,@Param("userId") Integer userId);

    /*
    刪除訂單(根據orderNum刪除address_order表)
     */
    @Delete("DELETE FROM address_order WHERE order_id=#{orderNum}")
    int deleteAddressOrderByOrderNum(String orderNum);

    /*
    查詢addressId(根據orderNum)
     */
    @Select("SELECT address_id FROM address_order WHERE order_id=#{orderNum}")
    Integer selectAddressIdByOrderNum(String orderNum);

    /*
    刪除訂單(根據addressId刪除address表)
     */
    @Delete("DELETE FROM address WHERE id=#{addressId}")
    int deleteAddressById(Integer addressId);

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
