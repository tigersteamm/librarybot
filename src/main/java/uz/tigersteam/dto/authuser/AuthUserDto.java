package uz.tigersteam.dto.authuser;

import lombok.*;
import uz.tigersteam.dto.BaseGenericDto;

/**
 * @author Nodirbek Abdukarimov Fri. 9:58 AM. 12/24/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDto extends BaseGenericDto {
    private String username;
    private String role;
    private String status;
    private String createdAt;
    private Long createdBy;
    private String updatedAt;
    private Long updatedBy;

    @Builder(builderMethodName = "childBuilder")
    public AuthUserDto(Long id, String username, String role, String status, String createdAt, Long createdBy, String updatedAt, Long updatedBy) {
        super(id);
        this.username = username;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }
}
