package uz.tigersteam.services;

/**
 * @author Nodirbek Abdukarimov Fri. 10:04 AM. 12/24/2021
 */

import uz.tigersteam.criteria.BaseCriteria;
import uz.tigersteam.dto.BaseDto;
import uz.tigersteam.dto.BaseGenericDto;
import uz.tigersteam.http.Data;
import uz.tigersteam.http.ResponseEntity;

import java.util.List;

/**
 * @param <D>  -> DTO
 * @param <CD> -> Create DTO
 * @param <UD> -> Update DTO
 * @param <ID> -> Primary Key(id)
 * @param <C>  -> Criteria
 */
public interface IBaseCrudService<
        D extends BaseGenericDto,
        CD extends BaseDto,
        UD extends BaseGenericDto,
        C extends BaseCriteria,
        ID extends Number> {

    ResponseEntity<Data<String>> save(CD e);

    ResponseEntity<Data<D>> get(ID id);

    ResponseEntity<Data<List<D>>> getAll(C c);

    ResponseEntity<Data<String>> update(UD e);

    ResponseEntity<Data<String>> delete(ID id);
}
