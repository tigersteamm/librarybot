package uz.tigersteam.dto.authuser;

import lombok.*;
import uz.tigersteam.dto.BaseDto;

/**
 * @author Nodirbek Abdukarimov Fri. 9:57 AM. 12/24/2021
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUserCreateDto implements BaseDto {
    private String username;
    private String password;
    private String role;
}
