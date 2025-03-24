# 🤓내가 처음 만드는 게시판 구축하기 #

## 📌개발 환경 ##
### 1. IDE : IntelliJ IDEA Community ###
### 2. Spring Boot : 3.4.4  ###
### 3. JDK : 17 ###
### 4. mySQL : 8.0  ###
### 5. Spring Data JPA ###
### 6. Thymeleaf ###

# 📌게시판 주요 기능
 1. 글쓰기(/board/save)
 2. 글목록(/board/)
 3. 글조회(board/{id})
 4. 글수정(board/update/{id})
    - 상세화면에서 수정 버튼 클릭
    - 서버에서 해당 게시글의 정보를 가지고 수정 화면 출력
    - 제목, 내용 수정
 5. 글삭제(board/delete/{id})  
 6. ***페이징처리***(/board/paging)