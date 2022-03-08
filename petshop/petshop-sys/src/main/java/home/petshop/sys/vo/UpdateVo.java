package home.petshop.sys.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UpdateVo implements Serializable {

    private String username;

    private String password;

    private String confirm;

    private String email;

    private String phone;
}
