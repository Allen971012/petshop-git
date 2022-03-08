package home.petshop.gateway.security;

import home.petshop.commons.model.Permission;
import home.petshop.commons.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private RestTemplate restTemplate;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("username:{}",username);
        //獲得用戶信息
        String url = "http://sys-service/v1/auth/user?username={1}";
        User user = restTemplate.getForObject(url,User.class,username);
        log.debug("user:{}",user);
        if(user==null){
            log.debug("用戶尚未註冊");
            return null;
        }
        //獲得權限
        url = "http://sys-service/v1/auth/permissions?id={1}";
        Permission[] permissions = restTemplate.getForObject(url,Permission[].class,user.getId());
        String[] authorities = new String[permissions.length];
        int i=0;
        for(Permission p : permissions){
            authorities[i++] = p.getName();
        }
        //存到UserDetails
        UserDetails u = org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .accountLocked(user.getLocked()==1)
                .disabled(user.getEnabled()==0)
                .authorities(authorities)
                .build();
        return u;
    }
}
