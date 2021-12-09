package com.springdongrest.springdongrest.events;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class EventControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void createEvent() throws Exception{
		
		Event event = Event.builder()
				.name("Spring")
				.description("REST API")
				.beginEnrollmentDateTime(LocalDateTime.of(2021, 12, 06, 13, 00))
				.closeEnrollmentDateTime(LocalDateTime.of(2021, 12, 06, 13, 00))
				.beginEventDateTime(LocalDateTime.of(2021, 12, 06, 13, 00))
				.endEventDateTime(LocalDateTime.of(2021, 12, 06, 13, 00))
				.basePrice(100)
				.maxPrice(200)
				.limitOfEnrollment(100)
				.location("gg")
				.build();
		
		mockMvc.perform(
			post("/api/events")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaTypes.HAL_JSON).content(objectMapper.writeValueAsString(event))
		)
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("id").exists());
	}
}
