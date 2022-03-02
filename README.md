# Heritage_API_Server
Backend API Server Repository

## branch -> autoComponentScan

### 해당 브랜치는 @ComponentScan을 활용하여 자동으로 의존성을 주입한 방식입니다. 

@ComponentScan을 작성하여 @Component가 적용된 클래스들을 Bean으로 등록합니다.
@Service, @Repository, @RestController 내의 @Component 기능이 있습니다.

자동 스캔 방식

추가로 등록한 애플리케이션 빈을 조회하는 테스트를 진행했습니다.

오류가 없음을 확인했고, 앞으로 주로 사용할 방법이기 때문에 `master` 브랜치와 merge 했습니다.

---

앞으로 어떠한 변화가 생겨서 `생성자 주입 방식` 을 진행할 때 따로 의존성을 주입해야하는 불필요함을 없애기 위해 `자동 스캔 주입 방식` 으로 진행합니다.
