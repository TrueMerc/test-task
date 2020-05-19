package com.mcb.creditfactory.services;

/**
 * Extends @see CollateralService interface with method which returns
 * string identifier of type.
 */
public interface TypedCollateralService extends CollateralService {
    String typeId();
}
