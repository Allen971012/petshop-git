package home.petshop.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import home.petshop.commons.model.Permission;
import home.petshop.commons.model.User;
import home.petshop.sys.vo.RegisterVo;
import home.petshop.sys.vo.UpdateVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
public interface IUserService extends IService<User> {
    /*
    根據用戶名查詢用戶信息和權限,並存到UserDetails對象,提供給SpringSecurity認證
     */
   // UserDetails getUserDetails(String username);

    /*
    註冊用戶
     */
    void registerUser(RegisterVo registerVo);

    /*
     獲取當前登錄用戶名
     */
    //String currentUsername();

    /*
    更新用戶
     */
    void updateUser(UpdateVo updateVo,String username);

    /*
    獲取當前用戶id
     */
    //String getCurrentUserId();

    /*
    獲得user信息提供給gateway做登入驗證
     */
    User findUserByUserName(String username);

    /*
    獲得權限提供給gateway做登入驗證
     */
    List<Permission> findPermissionByUserId(Integer id);

    /*
    根據username獲得userId
     */
    Integer getUserIdByUsername(String username);
}
