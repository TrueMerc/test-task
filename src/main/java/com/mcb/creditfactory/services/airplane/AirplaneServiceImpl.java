package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.entities.Airplane;
import com.mcb.creditfactory.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public boolean approve(AirplaneDto dto) {
        return false;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return null;
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return Optional.empty();
    }

    @Override
    public Airplane fromDto(AirplaneDto dto) {
        return null;
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane) {
        return null;
    }

    @Override
    public Long getId(Airplane airplane) {
        return null;
    }
}
