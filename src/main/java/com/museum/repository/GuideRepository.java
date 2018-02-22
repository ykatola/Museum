package com.museum.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;

public interface GuideRepository extends Repository<Guide, Integer> {
  
    List<Guide> getByPosition(GuidePosition position);
    
    Long getEventAmount(int guidId);
    
    Long getEventAmountByPeriod(int guidId, LocalDateTime fromTime, LocalDateTime toTime);
    
    Long getWorkTime(int guideId);
    
    Long getWorkTimeByPeriod(int guideId, LocalDateTime fromTime, LocalDateTime toTime);
}
