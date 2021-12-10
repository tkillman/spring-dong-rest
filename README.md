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
