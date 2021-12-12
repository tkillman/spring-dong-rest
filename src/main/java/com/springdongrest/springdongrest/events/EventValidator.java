package com.springdongrest.springdongrest.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class EventValidator {

    public void valid(EventDto eventDto, Errors errors){
        if (eventDto.getEndEventDateTime().isBefore(eventDto.getBeginEventDateTime())) {
            errors.rejectValue("endEventDateTime","wrongValue", "endEventDateTime is before BeginEventDateTime");
        }
    }
}
