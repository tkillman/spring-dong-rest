package com.springdongrest.springdongrest.events;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EventTest {
	
	@Test
	public void builder() {
		Event event = Event.builder().build();
		
		assertThat(event).isNotNull();
	}
}
