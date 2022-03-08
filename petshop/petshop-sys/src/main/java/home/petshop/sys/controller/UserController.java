package home.petshop.sys.controller;

import home.petshop.commons.vo.R;
import home.petshop.sys.service.IUserService;
import home.petshop.sys.vo.RegisterVo;
import home.petshop.sys.vo.UpdateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/v1/users")
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;


    /*
    接收註冊表單
     */
    @PostMapping("/register")
    public R registerUser(@Validated RegisterVo registerVo, BindingResult result){
        log.debug("註冊表單:{}",registerVo);
        if(result.hasErrors()){
            String error = result.getFieldError().getDefaultMessage();
            log.debug("error:{}",error);
            return R.unprocesableEntity(error);
        }
        if(!(registerVo.getPassword().equals(registerVo.getConfirm()))){
            return R.unprocesableEntity("密碼確認不一致");
        }
        userService.registerUser(registerVo);
        return R.created("註冊成功");
    }

    /*
    接收更改資料表單
     */
    @PostMapping("/update")
    public R updateUser(UpdateVo updateVo, @AuthenticationPrincipal UserDetails userDetails){
        log.debug("更改資料表單:{}",updateVo);
        log.debug("當前登入用戶userDetails:{}",userDetails);
        String reg;
        if(updateVo.getUsername()!=""){
            reg = "^.{2,10}$";
            boolean b = updateVo.getUsername().matches(reg);
            if(b==false){
                return R.unprocesableEntity("用戶名請輸入2~10個任意字符");
            }
        }
        if(updateVo.getPassword()!=""){
            reg = "^\\w{4,20}$";
            boolean b = updateVo.getPassword().matches(reg);
            if(b==false){
                return R.unprocesableEntity("密碼請輸入4~20英文或數字");
            }
        }
        if(!(updateVo.getPassword().equals(updateVo.getConfirm()))){
            return R.unprocesableEntity("密碼確認不一致");
        }
        if(updateVo.getEmail()!=""){
            reg = "^[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
            boolean b = updateVo.getEmail().matches(reg);
            if(b==false){
                return R.unprocesableEntity("信箱格式錯誤");
            }
        }
        if(updateVo.getPhone()!=""){
            reg = "^09\\d{8}";
            boolean b = updateVo.getPhone().matches(reg);
            if(b==false){
                return R.unprocesableEntity("手機號碼格式錯誤");
            }
        }
        String username = userDetails.getUsername();
        userService.updateUser(updateVo,username);
        return R.ok("更改成功");
    }

    /*
    獲取當前用戶姓名,用於顯示用戶資訊
     */
    @GetMapping("/getname")
    public R<String> getCurrentName(@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        log.debug("username:{}",username);
        return R.ok(username);
    }

    /*
    獲取當前用戶id
     */
    @GetMapping("/isLogin")
    public R getCurrentUserId(@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        Integer userId = userService.getUserIdByUsername(username);
        return R.ok(userId);
    }


}
