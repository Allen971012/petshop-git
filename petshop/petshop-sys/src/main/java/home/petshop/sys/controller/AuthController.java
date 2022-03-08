package home.petshop.sys.controller;


import home.petshop.commons.model.Permission;
import home.petshop.commons.model.User;
import home.petshop.sys.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/auth")
@Slf4j
public class AuthController {

    @Autowired
    private IUserService userService;

    /*
    測試ribbon
     */
    @GetMapping("/demo")
    public String demo(){
        return "Hello World!";
    }

    /*
    提供user給gateway和product模塊
     */
    @GetMapping("/user")
    public User getUser(String username){
        User user = userService.findUserByUserName(username);
        return user;
    }

    /*
    提供permissions給gateway
     */
    @GetMapping("/permissions")
    public List<Permission> getPermissions(Integer id){
        List<Permission> permissions = userService.findPermissionByUserId(id);
        return permissions;
    }


}
