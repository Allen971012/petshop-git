package home.petshop.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import home.petshop.commons.model.Permission;
import home.petshop.sys.mapper.UserMapper;
import home.petshop.sys.mapper.UserRoleMapper;
import home.petshop.commons.model.User;
import home.petshop.commons.model.UserRole;
import home.petshop.sys.service.IUserService;
import home.petshop.commons.service.ServiceException;
import home.petshop.sys.vo.RegisterVo;
import home.petshop.sys.vo.UpdateUserVo;
import home.petshop.sys.vo.UpdateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /*
    註冊用戶
     */
    @Transactional
    public void registerUser(RegisterVo registerVo) {
        //判斷入口參數
        if(registerVo==null){
            throw ServiceException.unprocesableEntity("表單數據為null");
        }
        //檢查username是否重複
        User u = userMapper.findUserByUsername(registerVo.getUsername());
        if(u!=null){
            throw ServiceException.unprocesableEntity("用戶名已經註冊過");
        }
        //檢查phone是否重複
        u = userMapper.findUserByPhone(registerVo.getPhone());
        if(u!=null){
            throw ServiceException.unprocesableEntity("電話號碼已經註冊過");
        }
        //檢查email是否重複
        u = userMapper.findUserByEmail(registerVo.getEmail());
        if(u!=null){
            throw ServiceException.unprocesableEntity("信箱已經註冊過");
        }
        //創建User並且插入數據
        User user = new User()
                .setUsername(registerVo.getUsername())
                .setPassword("{bcrypt}"+passwordEncoder.encode(registerVo.getPassword()))
                .setEmail(registerVo.getEmail())
                .setPhone(registerVo.getPhone())
                .setCreatetime(LocalDateTime.now())
                .setEnabled(1)
                .setLocked(0);
        log.debug("註冊用戶:{}",user);
        int rows = userMapper.insert(user);
        if(rows!=1){
            throw new ServiceException("服務器繁忙,請稍後再試");
        }
        //添加用戶角色
        UserRole userRole = new UserRole()
                .setUserId(user.getId())
                .setRoleId(2);
        rows = userRoleMapper.insert(userRole);
        if(rows!=1){
            throw new ServiceException("服務器繁忙,請稍後再試");
        }
        log.debug("用戶註冊完成");
    }

    /*
    更新用戶
     */
    @Transactional
    public void updateUser(UpdateVo updateVo,String username) {
        if(updateVo==null){
            throw ServiceException.unprocesableEntity("表單數據為null");
        }
        if(username==null){
            throw ServiceException.invalidRequest("用戶尚未登入");
        }
        //獲取當前用戶id
        Integer id = userMapper.findUserIdByUsername(username);
        //拼湊UpdateUserVo對象
        UpdateUserVo updateUserVo;
        if(updateVo.getPassword()=="") {
            updateUserVo = new UpdateUserVo()
                    .setId(id)
                    .setUsername(updateVo.getUsername())
                    .setPassword("")
                    .setEmail(updateVo.getEmail())
                    .setPhone(updateVo.getPhone());
        }else{
            updateUserVo = new UpdateUserVo()
                    .setId(id)
                    .setUsername(updateVo.getUsername())
                    .setPassword("{bcrypt}" + passwordEncoder.encode(updateVo.getPassword()))
                    .setEmail(updateVo.getEmail())
                    .setPhone(updateVo.getPhone());
        }
        //更新用戶信息
        Integer rows = userMapper.updateUser(updateUserVo);
        if(rows!=1){
            throw new ServiceException("服務器繁忙,請稍後再試");
        }
        log.debug("用戶信息更新完成");
    }


    /*
    獲得user信息提供給gateway做登入驗證
     */
    public User findUserByUserName(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }

    /*
    獲得權限提供給gateway做登入驗證
     */
    public List<Permission> findPermissionByUserId(Integer id) {
        return userMapper.findPermissionsByUserId(id);
    }

    /*
    根據username獲得userId
     */
    public Integer getUserIdByUsername(String username) {
        return userMapper.findUserIdByUsername(username);
    }
}
