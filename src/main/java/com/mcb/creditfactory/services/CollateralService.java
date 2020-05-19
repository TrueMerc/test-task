package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;

/**
 * Provides interface for services which works with collateral object.
 */
public interface CollateralService {
    /**
     * Saves collateral object.
     * @param object collateral object
     * @return saved object identifier or null if object doesn't approved by external approve service.
     */
    Long saveCollateral(Collateral object);

    /**
     * Returns collateral object information.
     * @param object collateral object.
     * @return collateral object information.
     */
    Collateral getInfo(Collateral object);
}
