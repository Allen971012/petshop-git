package home.petshop.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public MyAuthenticationSuccessHandler successHandler(){
        return new MyAuthenticationSuccessHandler("/index_user.html");
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(
                        "/sys/v1/users/isLogin",
                        "/index.html",
                        "/search.html",
                        "/search/v1/commodity/**",
                        "/product/v1/tag",
                        "/product/v1/product/**",
                        "/product/v1/promotion/**",
                        "/product.html",
                        "/products.html",
                        "/product_detail.html",
                        "/promotion_detail.html",
                        "/promotion_product.html",
                        "/bootstrap3/**",
                        "/css/*",
                        "/img/*",
                        "/js/*",
                        "/vue/**",
                        "/jq/*",
                        "/login.html",
                        "/favicon.ico",
                        "/register.html",
                        "/sys/v1/users/register").permitAll()
                .anyRequest().authenticated().and().formLogin()
                .successHandler(successHandler())
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .failureUrl("/login.html?error")
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html?logout");
    }
}
