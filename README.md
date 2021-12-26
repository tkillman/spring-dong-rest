# 1. Spring boot 만들기
jpa, hateoas, web, h2, postgresql,  
restdocs, lombok

# 2. Event 객체 만들기
String 타입 이벤트이름  
String 타입 설명  
LocalDateTime 타입 이벤트 등록 일시  
LocalDateTime 타입 이벤트 등록 종료 일시  
LocalDateTime 타입 이벤트 시작일시  
LocalDateTime 타입 이벤트 종료일시  
int 타입 기본금액  
int 타입 최대금액  
int 타입 이벤트 참여자수  
boolean 타입 오프라인여부  
boolean 타입 무료 여부  
enum 타입 이벤트 상태 (DRAFT, PUBLISHED, BEGIN_ENROLLMENT)

# 3. Event 객체 테스트 객체 만들어보기
Event 객체가 만들어지는지 Test 객체 만들어보기  

단축키  

    * Test 클래스 생성
    클래스명 block 잡은 상태로 ctrl + shift + t  
    * 불필요 import 제거  
    ctrl + alt + o

힌트 : @Test, assertThat, lombok, isNotNull

# 4. /api/events api Test 객체 만들어보기
post 요청으로 /api/events 를 요청했을 때 201 응답을  
  받는 Test 객체를 만들어보세요 

힌트 : @ExtendWith , @WebMvcTest, mockMvc

# 5. event를 통과 할 수 있게 EventController를 만들어보세요

힌트 : @Controller, @Postmapping, WebMvcLinkBuilder

# 6. EventControllerTest에서 Event 값을 넣은 객체 만들기
String 타입 이벤트이름  
String 타입 설명  
LocalDateTime 타입 이벤트 등록 일시  
LocalDateTime 타입 이벤트 등록 종료 일시  
LocalDateTime 타입 이벤트 시작일시  
LocalDateTime 타입 이벤트 종료일시  
int 타입 기본금액  
int 타입 최대금액  
int 타입 이벤트 참여자수  
boolean 타입 오프라인여부  
boolean 타입 무료 여부  
enum 타입 이벤트 상태 (DRAFT, PUBLISHED, BEGIN_ENROLLMENT)

# 7. EventControllerTest 수정
Event 객체를 생성하여 요청으로 보내고 응답으로 event json에 id값 있는지 확인하는 
Test 작성하기

힌트 : ObjectMapper

# 8. 위의 Event를 통과할 수 있는 EventController 수정
응답받은 Event 객체에 id 임의의 값을 설정하여 리턴하기
힌트 : @RequestBody

# 9. 입력받을 값 제한하기
1. Jpa 만들어보기 (EventRepository)  
힌트 : JpaRepository

2. (Skip 가능) Jpa를 사용하기 위해 test annotation @WebMvcTest -> @SpringBootTest 변경,
@AutoConfigureMockMvc 추가하기
팁 : jpa 객체가 @WebMvcTest에서는 만들어지질 않는다.
skip : test에서 jpa를 사용하지 않으면 구지 바꿀 필요는 없다.

3. EventControllerTest에서 Event의 free에 true를 보내더라도 응답은 true가 아닌 테스트 작성.

4. EventController postmapping의 event에서 입력받을 값만 dto 객체를 새로 만들기
5. event는 jpa entity로 사용하도록 변경  
힌트 : @Entity

6. 입력받은 dto를 event 객체로 변환하기  
힌트 : modelMapper  
팁 : modelMapper 설정은
  <br/>a) pom.xml 추가, b) main 메소드에 정의하기 @Bean

7. event 객체를 jpa를 통해 저장하고 리턴하기

8. test를 통과하는지 확인하기

# 10. 입력받은 값 검증하기
1. name값을 넘기지 않는 경우 badRequest 응답을 받는 테스트를 작성해보자
2. 테스트를 통과하도록 소스를 수정해보자 
 - pom.xml에 sping-valdation 추가
 - EventDto에 name이 empty 할 수 없다는 annotation을 설정해보자
 - Controller의 param에 valid 설정 @Valid
 - errors.hasError() 로 BadRequest 응답을 보내보자.

# 11. custom validator
1. EventValidator의 valid 메소드를 사용하여 LocalDateTime 타입 이벤트 시작일시가 LocalDateTime 타입 이벤트 종료일시보다 뒤면 에러가 나오도록 
테스트 케이스를 작성해보자.

# 12. custom annotation으로 테스트케이스에 설명을 붙여보자

# 13. validator에 의한 에러를 응답으로 보내보자.
Errors 객체를 responseEntity에 body로 내보내면 에러를 발생한다.  
이유는 errors 객체가 bean spec을 준수하지 않았기 때문에 object에서
json 형태로 변환 시 serialize가 되지 않기 때문이다. 그렇기 때문에
errors 객체에 대한 serialize가 필요하다.  
미션 : errors객체를 serialize해서 응답으로 에러내용을 받도록 해보자.  

테스트 작성
 - 응답받은 json objectName, field, defaultMessage, code, rejectValue가 포함되어 있는지 작성
힌트 : @JsonComponent, JsonSerializer

# 14. 비즈니스 로직 적용
EventTest 에서 location이 있으면 offline true 없으면 false인
케이스를 작성해보자.   

힌트 : Event 객체에 update 메소드 추가

# 15. 위의 14번 테스트를 junitParams를 사용하여 간결화해보자
pom.xml junit-jupiter-params 추가

힌트 : @ParameterizedTest, @MethodSource

# 16. Hateoas 적용
- EventControllerTest에서 _link.self, _link.query-event , _link.update-event 가 있는지 확인하는 테스트 케이스를 작성해보자.
힌트 : @JsonUnwrapped // serialize할 때 json을 객체 이름으로 감싸지 않도록 하는 어노테이션
- @JsonUnwrapped를 매번 사용해야 하는 과정을 피하기 위해 EntityModel을 상속받도록 소스를 수정해보세요.

# 17. RestDoc 적용하기
EventControllerTest에 RestDoc을 적용하기 위한 어노테이션을 붙여보기  
힌트 : @AutoConfigureRestDocs

# 18. RestDoc create-event 만들어보기
EventControllerTest에 createEvent 메소드에 create-event라는 문서 만들어보기  
힌트 : MockMvcRestDocumentation.document  
확인 : target폴더 generated-snippets

# 19. RestDoc 문서 예쁘게 출력하기
test에 common pakage를 생성하고, RestDocConfiguration class를 만든 뒤 RestDocsMockMvcConfigurationCustomizer Bean을 등록해보세요.  
힌트 : @TestConfiguration, RestDocsMockMvcConfigurationCustomizer
, @Import(RestDocConfiguration.class)

# 20. RestDoc link 정보 알려주기
위에서 만든 document메소드 다음 snippets를 추가해보자
힌트 : HypermediaDocumentation.links, HypermediaDocumentation.linkWithRel  
확인 : links.adoc 확인



