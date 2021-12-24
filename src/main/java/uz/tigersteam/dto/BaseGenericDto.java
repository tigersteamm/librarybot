package uz.tigersteam.dto;

import lombok.*;

/**
 * @author Nodirbek Abdukarimov Fri. 9:58 AM. 12/24/2021
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseGenericDto implements BaseDto {
    private Long id;
}
