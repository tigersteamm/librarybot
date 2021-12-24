package uz.tigersteam.dto.authuser;

import lombok.Builder;
import uz.tigersteam.dto.BaseGenericDto;

/**
 * @author Nodirbek Abdukarimov Fri. 9:58 AM. 12/24/2021
 */
public class AuthUserUpdateDto extends BaseGenericDto {
    private String username;
    private String password;
    private String role;
    private String status;

    @Builder(builderMethodName = "childBuilder")
    public AuthUserUpdateDto(Long id, String username, String password, String role, String status) {
        super(id);
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }
}
