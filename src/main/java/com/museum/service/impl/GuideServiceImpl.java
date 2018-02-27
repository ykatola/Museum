package com.museum.service.impl;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.repository.GuideRepository;
import com.museum.service.AbstractService;
import com.museum.service.GuideService;
import com.museum.service.impl.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class GuideServiceImpl extends AbstractService<Guide, Integer, GuideRepository> implements GuideService {
    
    @Autowired
    private GuideRepository repository;
    
    @Override
    public GuideRepository getRepository() {
        return repository;
    }
    
    @Override
    public List<Guide> findAllByPosition(GuidePosition position) {
        Objects.requireNonNull(position, "position");
        return getRepository().findAllByPosition(position);
    }
    
    @Override
    public List<Guide> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        Validations.period(fromTime, toTime);
        return getRepository().findAllByPeriod(fromTime, toTime);
    }

    @Override
    public Long getWorkTime(Guide guide) {
        return getRepository().getWorkTime(guide);
    }
    
    @Override
    public Long getWorkTimeByPeriod(Guide guide, LocalDateTime fromTime, LocalDateTime toTime) {
        Validations.period(fromTime, toTime);
        Validations.entity(repository, guide, "guide");
        return getRepository().getWorkTimeByPeriod(guide, fromTime, toTime);
    }
}
