package com.springdongrest.springdongrest.events;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class EventTest {
	
	@Test
	public void builder() {
		Event event = Event.builder().build();
		assertThat(event).isNotNull();
	}

	@Test
	public void testOffline() {
		//given
		Event event = Event.builder()
							.location("강남")
							.build()
							.update();

		//then
		assertThat(event.isOffline()).isTrue();

		//given
		Event event2 = Event.builder()
				.build()
				.update();

		//then
		assertThat(event2.isOffline()).isFalse();
	}

	public static Stream<Arguments> paramsForTestOffline2(){
		return Stream.of(
				Arguments.of("강남", true),
				Arguments.of("", false)
		);
	}

	@ParameterizedTest
	@MethodSource("paramsForTestOffline2")
	public void testOffline2(String location, boolean offline) {
		//given
		Event event = Event.builder()
				.location(location)
				.build()
				.update();

		//then
		assertThat(event.isOffline()).isEqualTo(offline);
	}
}
