package home.petshop.order;

import home.petshop.order.mapper.AddressMapper;
import home.petshop.order.mapper.AddressOrderMapper;
import home.petshop.order.mapper.TOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private AddressOrderMapper addressOrderMapper;

    @Resource
    private TOrderMapper orderMapper;

    @Test
    public void testMapper(){
        log.debug("{}",addressMapper);
        log.debug("{}",addressOrderMapper);
        log.debug("{}",orderMapper);
    }
}
