package uz.tigersteam.repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Nodirbek Abdukarimov Fri. 10:03 AM. 12/24/2021
 */
public interface IBaseCrudRepository<E, ID> {
    default void save(E e) {
    }

    default Optional<E> get(ID id) {
        return Optional.empty();
    }

    default Optional<List<E>> getAll() {
        return Optional.empty();
    }

    default void update(E e) {
        return;
    }

    default void delete(ID id) {
    }

}
