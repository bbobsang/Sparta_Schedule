# [[ 데이터베이스 연결 정보 ]]
- **데이터베이스 URL**: `jdbc:mysql://localhost:3306/schedule`
- **사용자명**: `root`
- **비밀번호**: (사용자 설정에 따라 다름) <br><br><br>
  


# [[ 프로젝트 구조 ]]

```
sparta-scheduler/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sparta/
│   │   │           └── spartascheduler/
│   │   │               ├── config/                    # 설정 클래스 패키지
│   │   │               │   ├── CustomPasswordEncoder.java
│   │   │               │   └── SecurityConfig.java
│   │   │               ├── controller/                 # API 컨트롤러
│   │   │               │   ├── AuthController.java
│   │   │               │   ├── ScheduleController.java
│   │   │               │   └── CommentController.java
│   │   │               ├── dto/                         # 데이터 전송 객체
│   │   │               │   ├── UserDto.java
│   │   │               │   ├── ScheduleDto.java
│   │   │               │   └── CommentDto.java
│   │   │               ├── entity/                      # JPA 엔티티
│   │   │               │   ├── User.java
│   │   │               │   ├── Schedule.java
│   │   │               │   └── Comment.java
│   │   │               ├── exception/                   # 사용자 정의 예외
│   │   │               │   ├── UserNotFoundException.java
│   │   │               │   └── ScheduleNotFoundException.java
│   │   │               ├── repository/                  # JPA 레포지토리
│   │   │               │   ├── UserRepository.java
│   │   │               │   ├── ScheduleRepository.java
│   │   │               │   └── CommentRepository.java
│   │   │               ├── security/                    # 보안 관련 코드
│   │   │               │   ├── JwtUtil.java
│   │   │               │   └── SecurityConfig.java
│   │   │               ├── service/                     # 서비스 레이어
│   │   │               │   ├── UserService.java
│   │   │               │   ├── ScheduleService.java
│   │   │               │   └── CommentService.java
│   │   │               └── util/                        # 유틸리티 클래스
│   │   │                   └── ResponseUtil.java
│   │   ├── resources/
│   │   │   ├── application.properties                    # 설정 파일
│   │   │   └── static/                                   # 정적 리소스 (CSS, JS 등)
│   │   └── webapp/                                       # 웹 관련 리소스
│   └── test/
│       └── java/
│           └── com/
│               └── sparta/
│                   └── spartascheduler/
│                       └── ...                          # 테스트 클래스
├── pom.xml                                               # Maven 의존성 관리
└── README.md                                             # 프로젝트 설명서


```

<br><br><br>

## [[ API 명세서 ]]
![image](https://github.com/user-attachments/assets/67369278-80dc-4591-8b46-4090e15e9be2)


<br><br><br>

## [[ ERD ]]
![image](https://github.com/user-attachments/assets/1952fad7-1044-4629-8217-b2449dda4914)

