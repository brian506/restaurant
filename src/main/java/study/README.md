# User

## 구현한 기능
1. 회원가입
2. 회원가입 시간 부여
3. 회원정보 조회
   
### 회원가입 상세 기능
- 회원가입을 할 때 필요한 username,password,email을 입력 받는다.
- 각 필드값에 대한 Valid도 설정해준다.
- username,email이 중복되면 예외를 던진다.

### 회원정보 조회
- 회원이름과 이메일로 조회 가능하다.
- 조회를 했을 때 값이 없으면 예외를 던져주었고
- 조회를 했을 때 값이 있으면 성공 코드도 함께 작성했다.
  
# Post

## 구현한 기능
1. 게시물 작성
2. 범위에 따른 평점 부여
3. 게시물 장소,가게 이름,주소에 따른 조회
4. 작성 시간,수정 시간 부여
5. 지역마다 게시물 개수 확인

### 게시물 작성 상세 기능
- user를 먼저 받고 나서 게시물을 작성하도록 설계(아니면 예외 던짐)
- 점수에 따른 평점 범위가 정해져있음(점수 범위에 해당하지 않으면 예외 던짐)
- Place(장소)는 enum값으로 미리 값들을 정해주고 이들 중에 선택해야함(이들 중에 없으면 예외 발생)

 ### 조회 상세 기능
 - 장소에 따른(enum) 값들을 조회할때 생성된 게시물이 없으면 예외 발생
 - 가게이름에 따른 값을 조회할 때 해당되는 게시물이 없으면 예외 발생
 - 주소에 따른 값을 조회할 땐 지역,구역,길 중에서 하나만 선택해서 검색해도, 검색 조건에 맞는 게시물 조회 가능(해당되는 게시물이 없으면 예외 발생)
