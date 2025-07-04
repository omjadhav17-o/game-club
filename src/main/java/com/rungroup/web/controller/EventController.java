package com.rungroup.web.controller;

import com.rungroup.web.dto.EventDto;
import com.rungroup.web.model.Club;
import com.rungroup.web.model.Event;
import com.rungroup.web.service.ClubService;
import com.rungroup.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {


    EventService eventService;
    ClubService clubService;

    @Autowired
    public EventController(EventService eventService,ClubService clubService) {

        this.eventService = eventService;
        this.clubService = clubService;

    }

    @GetMapping("/events/{clubId}/create")
    public String createEvent(@PathVariable("clubId") int clubId, Model model)
    {
        Event event=new Event();
        model.addAttribute("clubId",clubId);
        model.addAttribute("event",event);
        return "event-create";
    }

    @GetMapping("/events/{eventId}/edit")
    public String editClubFrom(@PathVariable("eventId") Long eventId,Model model)
    {
        EventDto event=eventService.findEventbyId(eventId);
        model.addAttribute("event",event);
        return "event-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") Long eventId,@ModelAttribute("event") EventDto event)
    {
        EventDto eventDto=eventService.findEventbyId(eventId);
        event.setId(eventId);
        event.setClub(eventDto.getClub());
        eventService.updateEvent(event);

        return "redirect:/events";
    }

    @GetMapping("/events")
    public String listALlEvents(Model model)
    {
        List<EventDto> evenList=eventService.findallEvents();
        model.addAttribute("events",evenList);

        return "event-list";
    }

    @GetMapping("/events/{eventId}")
    public String eventsDetails(@PathVariable("eventId")Long eventId,Model model)
    {
        EventDto event=eventService.findEventbyId(eventId);
        model.addAttribute("event",event);

        return "event-details";
    }

    @PostMapping("/events/{clubId}")
    public String createEventFrom(@PathVariable("clubId") int clubId, @ModelAttribute("event") EventDto event, Model model)
    {
        eventService.createEvent(clubId,event);
        return "redirect:/clubs/"+clubId;
    }
}
