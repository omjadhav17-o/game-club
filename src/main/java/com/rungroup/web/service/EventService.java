package com.rungroup.web.service;

import com.rungroup.web.dto.EventDto;
import com.rungroup.web.model.Event;

import java.util.List;

public interface EventService {
  void createEvent(int clubId, EventDto eventDto);

  List<EventDto> findallEvents();

  EventDto findEventbyId(Long eventId);

  void updateEvent(EventDto eventDto);
}
