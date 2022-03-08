package home.petshop.paypal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
@MapperScan("home.petshop.paypal.mapper")
public class PetshopPaypalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetshopPaypalApplication.class, args);
    }

}
