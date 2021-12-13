package com.springdongrest.springdongrest.events;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class EventResource extends EntityModel<Event> {

    protected EventResource(Event content) {
        super(content);
        add(WebMvcLinkBuilder.linkTo(EventController.class).slash(content.getId()).withSelfRel());
    }
}
