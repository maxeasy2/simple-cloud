# Simple-Cloud
  
본 프로젝트는 심플한 파일관리 서비스를 제공할 예정 입니다.   
Docker를 통해 배포하여 간단하게 웹에서 파일을 공유할 수 있는 파일서버를 구축 하고자 합니다.   
개발이 완료 되면 Docker Hub에 올라갈 예정 입니다.   

## 제공하고자 하는 기능
![simple-file-upload-usecase](https://user-images.githubusercontent.com/7065267/76703142-ae537a00-6712-11ea-854c-7562d5bb1a88.png)
 - 파일 관리
   - 파일 등록/수정/삭제
   - 파일 리스트/상세 조회
      
 - 파일 및 사용자 권한 관리   
   - 사용자 권한별 파일 노출 제어
   - 사용자 권한별 파일 관리 기능 제어
   
## 사용된 기술

- Spring Boot 2.2.5
- Spring Web(MVC)
- Spring Data JPA
- Spring Security
- Thymeleaf
- H2 Database
- Docker
- Mysql-8.0.19

