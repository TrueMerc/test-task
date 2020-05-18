package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;

public interface CollateralService {
    Long saveCollateral(Collateral object);

    Collateral getInfo(Collateral object);
}
