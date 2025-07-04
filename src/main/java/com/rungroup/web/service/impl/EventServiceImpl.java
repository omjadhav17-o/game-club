package com.rungroup.web.service.impl;

import com.rungroup.web.dto.EventDto;
import com.rungroup.web.model.Club;
import com.rungroup.web.model.Event;
import com.rungroup.web.repository.ClubRepo;
import com.rungroup.web.repository.EventRepo;
import com.rungroup.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rungroup.web.Mapper.EventMapper.MaptoEvent;
import static com.rungroup.web.Mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {

    private ClubRepo clubRepo;
    private EventRepo eventRepo;

    @Autowired
    public EventServiceImpl(ClubRepo clubRepo, EventRepo eventRepo) {
        this.clubRepo = clubRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public void createEvent(int clubId, EventDto eventDto) {
        Club club= clubRepo.findById(clubId).get();
        Event event=MaptoEvent(eventDto);
        event.setClub(club);
       eventRepo.save(event);

    }

    @Override
    public List<EventDto> findallEvents() {
        List<Event> event = eventRepo.findAll();

        return event.stream().map(event1 -> mapToEventDto(event1)).collect(Collectors.toList());

    }

    @Override
    public EventDto findEventbyId(Long eventId) {
        Event event= eventRepo.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event=MaptoEvent(eventDto);
        eventRepo.save(event);
    }


}
