# 프로젝트 구조

sparta-scheduler/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sparta/
│   │   │           └── spartascheduler/
│   │   │               ├── controller/       # API 컨트롤러
│   │   │               ├── entity/           # JPA 엔티티
│   │   │               ├── exception/        # 사용자 정의 예외
│   │   │               ├── repository/       # JPA 레포지토리
│   │   │               ├── security/         # 보안 관련 코드
│   │   │               ├── service/          # 서비스 레이어
│   │   │               └── util/             # 유틸리티 클래스
│   │   ├── resources/
│   │   │   ├── application.properties         # 설정 파일
│   │   │   └── static/                        # 정적 리소스 (CSS, JS 등)
│   │   └── webapp/                            # 웹 관련 리소스
│   └── test/
│       └── java/
│           └── com/
│               └── sparta/
│                   └── spartascheduler/
│                       └── ...               # 테스트 클래스
├── pom.xml                                     # Maven 의존성 관리
└── README.md                                   # 프로젝트 설명서



설명<br>

엔티티: Schedule과 Comment 엔티티를 정의하였고, JPA의 Auditing 기능을 활용하여
생성 및 수정일자를 자동으로 관리합니다.

레포지토리: JpaRepository를 상속받아 기본적인 CRUD 기능을 제공합니다.

서비스: 비즈니스 로직을 처리하며, 필요한 경우 데이터베이스와 상호작용합니다.

컨트롤러: REST API를 제공하여 클라이언트와의 통신을 담당합니다.

DTO: 유효성 검사 및 요청/응답 모델을 정의합니다.

## API 명세서
![img.png](img.png)

## ERD
![img_1.png](img_1.png)
