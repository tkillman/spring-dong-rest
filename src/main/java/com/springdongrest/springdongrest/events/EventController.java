package com.springdongrest.springdongrest.events;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
public class EventController {

    @PostMapping("/api/events")
    public ResponseEntity createEvent(){

        URI uri = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EventController.class).createEvent())
                .slash("id")
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
