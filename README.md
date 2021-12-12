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
