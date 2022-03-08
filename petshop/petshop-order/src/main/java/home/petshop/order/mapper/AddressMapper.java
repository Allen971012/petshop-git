package home.petshop.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import home.petshop.commons.model.Address;
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
public interface AddressMapper extends BaseMapper<Address> {

    /*
    新增address
     */
    int addAddress(Address address);
}
