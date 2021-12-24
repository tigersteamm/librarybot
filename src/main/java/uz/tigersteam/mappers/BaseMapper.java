package uz.tigersteam.mappers;

import uz.tigersteam.dto.BaseDto;
import uz.tigersteam.dto.BaseGenericDto;
import uz.tigersteam.models.BaseEntity;

import java.util.List;

/**
 * @author Nodirbek Abdukarimov Fri. 10:00 AM. 12/24/2021
 */
public interface BaseMapper<E extends BaseEntity, D extends BaseGenericDto, CD extends BaseDto, UD extends BaseGenericDto> {
    D to(E e);

    List<D> to(List<E> e);

    E from(D d);

    E fromCreateDto(CD cd);
}
