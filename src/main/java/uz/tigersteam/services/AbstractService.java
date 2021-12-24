package uz.tigersteam.services;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Nodirbek Abdukarimov Fri. 10:04 AM. 12/24/2021
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractService<R, M> {
    protected M mapper;
    protected R repository;

    public AbstractService(M mapper, R repository) {
        this.mapper = mapper;
        this.repository = repository;
    }
}
