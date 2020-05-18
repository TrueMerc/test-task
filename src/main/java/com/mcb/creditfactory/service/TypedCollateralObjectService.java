package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;

import java.util.Optional;

/**
 * Provides basic interface for all collateral objects services.
 * @param <Type> collateral object type
 * @param <DtoType> corresponding DTO type for collateral object type.
 */
public interface TypedCollateralObjectService<Type, DtoType extends Collateral> {
    boolean approve(DtoType dto);

    Type save(Type object);

    Optional<Type> load(Long id);

    DtoType fromCollateral(Collateral collateral);

    Type fromDto(DtoType dto);

    DtoType toDTO(Type object);

    Long getId(Type object);

}
