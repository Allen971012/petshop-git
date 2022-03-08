package home.petshop.sys.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateUserVo {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
}
