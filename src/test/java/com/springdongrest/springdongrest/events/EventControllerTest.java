package com.springdongrest.springdongrest.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springdongrest.springdongrest.common.RestDocConfiguration;
import com.springdongrest.springdongrest.common.TestDescription;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.headers.HeaderDocumentation;
import org.springframework.restdocs.hypermedia.HypermediaDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Import(RestDocConfiguration.class)
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
                .andExpect(MockMvcResultMatchers.jsonPath("id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("_links.self").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("_links.query-event").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("_links.update-event").exists())
                .andDo(MockMvcRestDocumentation
                        .document("create-event",
                            HypermediaDocumentation.links(
                                    HypermediaDocumentation.linkWithRel("self").description("link to self"),
                                    HypermediaDocumentation.linkWithRel("update-event").description("update event"),
                                    HypermediaDocumentation.linkWithRel("query-event").description("query-event")),
                            HeaderDocumentation.requestHeaders(
                                    HeaderDocumentation.headerWithName(HttpHeaders.ACCEPT).description("accept header"),
                                    HeaderDocumentation.headerWithName(HttpHeaders.CONTENT_TYPE).description("accept CONTENT_TYPE")
                            ),
                            PayloadDocumentation.requestFields(
                                    PayloadDocumentation.fieldWithPath("name").description("name of event"),
                                    PayloadDocumentation.fieldWithPath("description").description("name of description"),
                                    PayloadDocumentation.fieldWithPath("beginEnrollmentDateTime").description("name of beginEnrollmentDateTime"),
                                    PayloadDocumentation.fieldWithPath("closeEnrollmentDateTime").description("name of closeEnrollmentDateTime"),
                                    PayloadDocumentation.fieldWithPath("beginEventDateTime").description("name of beginEventDateTime"),
                                    PayloadDocumentation.fieldWithPath("endEventDateTime").description("name of endEventDateTime"),
                                    PayloadDocumentation.fieldWithPath("location").description("name of location"),
                                    PayloadDocumentation.fieldWithPath("basePrice").description("name of basePrice"),
                                    PayloadDocumentation.fieldWithPath("maxPrice").description("name of maxPrice"),
                                    PayloadDocumentation.fieldWithPath("limitOfEnrollment").description("name of limitOfEnrollment")
                            ),
                            HeaderDocumentation.responseHeaders(
                                    HeaderDocumentation.headerWithName(HttpHeaders.LOCATION).description("accept LOCATION"),
                                    HeaderDocumentation.headerWithName(HttpHeaders.CONTENT_TYPE).description("accept CONTENT_TYPE")
                            ),
                            PayloadDocumentation.relaxedResponseFields(
                                    PayloadDocumentation.fieldWithPath("id").description("name of id"),
                                    PayloadDocumentation.fieldWithPath("offline").description("name of offline"),
                                    PayloadDocumentation.fieldWithPath("free").description("name of free"),
                                    PayloadDocumentation.fieldWithPath("eventStatus").description("name of eventStatus"),
                                    PayloadDocumentation.fieldWithPath("name").description("name of event"),
                                    PayloadDocumentation.fieldWithPath("description").description("name of description"),
                                    PayloadDocumentation.fieldWithPath("beginEnrollmentDateTime").description("name of beginEnrollmentDateTime"),
                                    PayloadDocumentation.fieldWithPath("closeEnrollmentDateTime").description("name of closeEnrollmentDateTime"),
                                    PayloadDocumentation.fieldWithPath("beginEventDateTime").description("name of beginEventDateTime"),
                                    PayloadDocumentation.fieldWithPath("endEventDateTime").description("name of endEventDateTime"),
                                    PayloadDocumentation.fieldWithPath("location").description("name of location"),
                                    PayloadDocumentation.fieldWithPath("basePrice").description("name of basePrice"),
                                    PayloadDocumentation.fieldWithPath("maxPrice").description("name of maxPrice"),
                                    PayloadDocumentation.fieldWithPath("limitOfEnrollment").description("name of limitOfEnrollment"),
                                    PayloadDocumentation.fieldWithPath("_links.self.href").description("name of _links.self.href"),
                                    PayloadDocumentation.fieldWithPath("_links.query-event.href").description("name of _links.query-event.href"),
                                    PayloadDocumentation.fieldWithPath("_links.update-event.href").description("name of _links.update-event.href")
                            )
                        )
                )
        ;
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

    @Test
    @TestDescription("잘못된 input의 에러확인")
    public void createEvent_bad_req_wrong_input() throws  Exception {
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
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].objectName").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].field").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].defaultMessage").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].code").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rejectedValue").exists());
    }
}
