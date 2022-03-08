package home.petshop.sys.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class RegisterVo implements Serializable {

    @NotBlank(message="請輸入用戶名")
    @Pattern(regexp = "^.{2,10}$",message = "用戶名請輸入2~10個任意字符")
    private String username;

    @NotBlank(message="請輸入密碼")
    @Pattern(regexp = "^\\w{4,20}$",message="密碼請輸入4~20英文或數字")
    private String password;

    @NotBlank(message="請輸入確認密碼")
    private String confirm;

    @NotBlank(message="請輸入信箱")
    @Pattern(regexp = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+",message="信箱格式錯誤")
    private String email;

    @NotBlank(message="請輸入手機號碼")
    @Pattern(regexp = "09\\d{8}",message="手機號碼格式錯誤")
    private String phone;
}
