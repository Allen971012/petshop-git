package home.petshop.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import home.petshop.commons.model.AddressOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author home
* @since 2021-12-27
*/
@Repository
public interface AddressOrderMapper extends BaseMapper<AddressOrder> {

    /*
    新增address_order關聯表
     */
    @Insert("INSERT INTO address_order(order_id,address_id) " +
            "VALUES(#{orderId},#{addressId})")
    int addAddressOrder(@Param("orderId") String orderId ,@Param("addressId")Integer addressId);
}
