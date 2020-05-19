package com.mcb.creditfactory.services;

import com.mcb.creditfactory.dto.Collateral;

import java.util.Optional;

/**
 * Provides basic interface for all collateral objects services.
 * @param <Type> collateral object type
 * @param <DtoType> corresponding DTO type for collateral object type.
 */
public interface TypedCollateralObjectService<Type, DtoType extends Collateral> {

    /**
     * Returns result of collateral object DTO approvement.
     * @param dto
     * @return
     */
    boolean approve(DtoType dto);

    /**
     * Saves collateral object.
     * @param object saving object.
     * @return saved object.
     */
    Type save(Type object);

    /**
     * Loads collateral object with given identifier.
     * @param id collateral object identifier
     * @return optional value for given object identifier.
     */
    Optional<Type> load(Long id);

    /**
     * Constructs collateral object from given collateral DTO object.
     * @param dto collateral DTO object.
     * @return constructed collateral object.
     */
    Type fromDto(DtoType dto);

    /**
     * Construct collateral DTO object from given collateral object.
     * @param object collateral object.
     * @return constructed collateral DTO object.
     */
    DtoType toDTO(Type object);

    /**
     * Returns collateral object identifier.
     * @param object collateral object.
     * @return collateral object identifier.
     */
    Long getId(Type object);
}
