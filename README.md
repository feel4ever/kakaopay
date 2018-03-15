# kakaopay
kakopay

# 과제 해결 전략
   - 과제의 핵심은 중복없는 쿠폰 번호 발급으로 판단하였고, 다음과 같은 알고리즘으로 쿠폰번호가 지급 됨.
   
   1. 이메일 주소를 입력받아 해당 e-mail 주소를 SHA-256 으로 암호화.(해당 암호화는 유니크한 64바이트의 16진수를 제공함.)
   
   2. 암호화된 hash 값은 64바이트의 길이를 가지므로, 4자리씩 나누어 총 16개의 4자리 16진수를 얻음
   
   3. 해당 4자리의 16진수를 62로 나눈 값을 해당 쿠폰번호로 매핑하는 Hash 함수를 구현하여 쿠폰번호 발급. (0-9a-zA-Z 의 총 62자리 배열을 이용)
   
   - 결론 : 현존하는 무결성, 무중복 알고리즘으로 판단하였고, 해당 알고리즘의 Hash 값을 seed로 가지는 hash를 만들면, 무중복성을 가장 효율적으로 해결 할 수 있다고 판단하였음.
  
# Project build
  - 해당 프로젝트를 eclipse에 Gradle Project로 프로젝트를 만들어, Spring Boot APP 로 Run.
  
# 실행 방법
 1. 클라이언트를 로컬 파일로 테스트를 진행하였기 때문에, 크롬의 외부요청 가능 옵션 혹은 외부요청 가능 플러그인을 설치한다.
 2. https://chrome.google.com/webstore/detail/allow-control-allow-origi/nlfbmbojpeacfghkpbjhddihlkkiljbi?utm_source=chrome-ntp-icon 
 3. 브라우져에 index.html 경로 입력하여, 웹 어플리케이션을 호출한다.
 4. e-mail 입력부에 공백으로 조회 버튼을 호출하면, 전체조회(페이징 : 5 row, 2 page)가 가능하다.
 5. e-mail 입력 후에 조회 버튼을 호출하면, 단건 조회를 한다.
 6. e-mail 입력 후에 발급 버튼을 누르면, 쿠폰번호를 발급 받는다.
