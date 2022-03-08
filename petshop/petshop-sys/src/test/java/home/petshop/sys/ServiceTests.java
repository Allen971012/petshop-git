package home.petshop.sys;

import home.petshop.sys.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class ServiceTests {

    @Resource
    private IUserService userService;

    @Test
    public void testService(){
        log.debug("{}",userService);
    }
}
