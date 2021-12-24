package uz.tigersteam.models;

import lombok.*;

/**
 * @author Nodirbek Abdukarimov Fri. 10:01 AM. 12/24/2021
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Auditable implements BaseEntity {
    private Long id;
    private String createdAt;
}
