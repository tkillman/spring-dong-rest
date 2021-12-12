package com.springdongrest.springdongrest.events;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity
public class Event {

	@Id @GeneratedValue
	private Integer id;

	private String name; 
	private String description; 
	private LocalDateTime beginEnrollmentDateTime; 
	private LocalDateTime closeEnrollmentDateTime;
	private LocalDateTime beginEventDateTime; 
	private LocalDateTime endEventDateTime; 
	private String location; // (optional) 이게 없으면 온라인 모임 
	private int basePrice; // (optional) 
	private int maxPrice; // (optional) 
	private int limitOfEnrollment; 

	private boolean offline; 
	private boolean free = false;

	@Enumerated(EnumType.STRING)
	private EventStatus eventStatus = EventStatus.DRAFT;

	public Event update() {
		if (StringUtils.hasLength(location)) {
			this.offline = true;
		}
		return this;
	}
}
