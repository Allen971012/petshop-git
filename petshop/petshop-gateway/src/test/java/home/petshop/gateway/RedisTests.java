package home.petshop.gateway;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class RedisTests {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("msg","hello");
        String str = redisTemplate.opsForValue().get("msg");
        redisTemplate.delete("msg");
        log.debug("Redis msg:{}",str);
    }
}
