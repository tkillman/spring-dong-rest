package com.springdongrest.springdongrest.events;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EventController {

	@Autowired
	EventRepository eventReposity;

	@PostMapping("/api/events")
	public ResponseEntity createEvent(@RequestBody Event event){

		Event newEvent = eventReposity.save(event);
		URI url = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EventController.class).createEvent(event)).slash("{id}").toUri();
		
		return ResponseEntity.created(url).body(event);
	}
}
