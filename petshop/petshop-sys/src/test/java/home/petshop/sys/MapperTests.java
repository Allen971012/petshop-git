package home.petshop.sys;

import home.petshop.sys.mapper.UserMapper;
import home.petshop.sys.mapper.UserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    public void testMapper(){
        log.debug("{}",userMapper);
        log.debug("{}",userRoleMapper);
    }
}
