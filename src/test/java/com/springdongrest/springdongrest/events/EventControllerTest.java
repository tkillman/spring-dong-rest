package com.springdongrest.springdongrest.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springdongrest.springdongrest.common.TestDescription;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @TestDescription("이벤트 생성 테스튼")
    public void createEvent() throws Exception {
        // 주석1 시작
//        boolean freeValue = true;
//        Event event = Event.builder().name("이벤트").free(freeValue).build();

//        mockMvc.perform(MockMvcRequestBuilders.post("/api/events")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaTypes.HAL_JSON)
//                        .content(objectMapper.writeValueAsString(event))
//                )
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("id").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("free").value(Matchers.not(freeValue)));
//
        EventDto eventDto = EventDto.builder()
                                        .name("이벤트")
                .beginEventDateTime(LocalDateTime.of(2021, 12,12,12,12))
                .endEventDateTime(LocalDateTime.of(2021, 12,13,12,12))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/events")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(eventDto))
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("id").exists());
    }

    @Test
    @TestDescription("spring validator에 의해 error 발생")
    public void createEvent_bad_req() throws Exception {

        EventDto eventDto = EventDto.builder().build();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(eventDto))
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @TestDescription("custom validator에 의해 error 발생")
    public void createEvent_bad_req_custom() throws  Exception {
        EventDto eventDto = EventDto.builder()
                .name("이벤트")
                .beginEventDateTime(LocalDateTime.of(2021, 12,12,12,12))
                .endEventDateTime(LocalDateTime.of(2021, 12,11,12,12))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(eventDto))
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
