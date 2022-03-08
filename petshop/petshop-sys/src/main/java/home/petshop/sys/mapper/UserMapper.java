package home.petshop.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import home.petshop.commons.model.Permission;
import home.petshop.commons.model.User;
import home.petshop.sys.vo.UpdateUserVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author home
* @since 2021-12-27
*/
    @Repository
    public interface UserMapper extends BaseMapper<User> {

        /*
        根據username查詢user信息
         */
        @Select("SELECT id,username,password,email,phone,createtime,enabled,locked " +
                "FROM user WHERE username=#{username}")
        public User findUserByUsername(String username);

        /*
        根據userId查詢permission
         */
        @Select("SELECT p.id,p.name FROM user u " +
                "LEFT JOIN user_role ur ON u.id=ur.user_id " +
                "LEFT JOIN role r ON r.id=ur.role_id " +
                "LEFT JOIN role_permission rp ON rp.role_id=r.id " +
                "LEFT JOIN permission p ON rp.permission_id=p.id " +
                "WHERE u.id=#{id}")
        public List<Permission> findPermissionsByUserId(Integer id);

        /*
        根據phone查詢user信息
         */
        @Select("SELECT username,password,email,phone,createtime,enabled,locked " +
                "FROM user WHERE phone=#{phone}")
        public User findUserByPhone(String phone);

        /*
        根據email查詢user信息
        */
        @Select("SELECT username,password,email,phone,createtime,enabled,locked " +
                "FROM user WHERE email=#{email}")
         public User findUserByEmail(String email);

        /*
        根據username查詢id
         */
        @Select("SELECT id FROM user WHERE username=#{username}")
        public Integer findUserIdByUsername(String username);

        /*
        根據userId動態更新用戶信息
         */
        public Integer updateUser(UpdateUserVo updateUserVo);























    }
