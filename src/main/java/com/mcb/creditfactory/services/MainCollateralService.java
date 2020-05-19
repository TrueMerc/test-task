package com.mcb.creditfactory.services;

import com.mcb.creditfactory.dto.Collateral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

// TODO: reimplement this
@Service
@Qualifier("mainCollateralService")
public class MainCollateralService implements CollateralService {

    @Autowired
    ApplicationContext context;

    Map<String, TypedCollateralService> typedServices = new HashMap<>();

    public Long saveCollateral(Collateral object) {
        final CollateralService service = getService(object);
        return service.saveCollateral(object);
    }

    public Collateral getInfo(Collateral object) {
        final CollateralService service = getService(object);
        return service.getInfo(object);
    }

    private CollateralService getService(Collateral object) {
        final String id = object.getClass().toString();
        return typedServices.get(id);
    }

    @PostConstruct
    private void init() {
        Map<String, TypedCollateralService> services = context.getBeansOfType(TypedCollateralService.class);

        for(TypedCollateralService service: services.values()) {
            final Class<?> serviceClass = service.getClass();
            Service annotation = serviceClass.getAnnotation(Service.class);
            if(service == null) {
                throw new RuntimeException(
                        "Can't add to services class without service annotation: " + serviceClass.toString()
                );
            }
            typedServices.put(service.typeId(), service);
        }
    }
}
