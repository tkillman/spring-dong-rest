package com.springdongrest.springdongrest.events;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;
import java.util.function.Consumer;
import java.util.function.Function;

@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventValidator eventValidator;

    // @PostMapping("/api/events")
    @PostMapping
    public ResponseEntity createEvent(@RequestBody @Valid EventDto eventDto, Errors errors){

// 주석 1 시작
//        URI uri = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EventController.class).createEvent())
//                .slash("id")
//                .toUri();
//
//        return ResponseEntity.created(uri).build();
// 주석 1 종료

        // 주석2 시작
//        int id = 10;
//        event.setId(id);
//        URI uri = WebMvcLinkBuilder.linkTo(EventController.class)
//                .slash(id)
//                .toUri();
//        return ResponseEntity.created(uri).body(event);
        // 주석2 종료

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        eventValidator.valid(eventDto, errors);

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Event event = modelMapper.map(eventDto, Event.class);
        Event newEvent = eventRepository.save(event);

        URI uri = WebMvcLinkBuilder.linkTo(EventController.class).slash(newEvent.getId()).toUri();

        return ResponseEntity.created(uri).body(newEvent);
    }
}
