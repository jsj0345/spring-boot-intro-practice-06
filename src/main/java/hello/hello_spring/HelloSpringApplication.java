package hello.hello_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

	/*
	Tomcat started on port 8080 (http)
	http 8080 포트가 뜸.
	웹 브라우저를 연 후, localhost:8080을 쳐보자.

	코드 실행을 끄고 localhost:8080으로 가면 아무 것도 안뜸.

	메인 메서드를 보면 ..
	HelloSpringApplication 클래스를 run에 넣어주면 @SpringBootApplication 이걸로 인해
	SpringBootApplication이 실행 . Tomcat이라는 웹 서버를 띄움.

	메뉴로 가면 Settings 에 Gradle을 보면 Build and run using: Intellij IDEA
	Run tests using: IntelliJ IDEA로 수정.

	이러한 이유는?

  Gradle로 설정하면 Gradle을 통해서 작동하기 때문에 속도가 느림.

  왼쪽 프로젝트에 External Libraries -> 외부 라이브러리들 볼 수 있음. 엄청 많음.
	 */

	/*
	스프링 부트 라이브러리
	spring-boot-starter-web
	-spring-boot-starter-tomcat: 톰캣 (웹서버)
	-spring-webmvc: 스프링 웹 MVC

	spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)

	테스트 라이브러리
	spring-boot-starter-test

	junit: 테스트 프레임워크
	mockito : 목 라이브러리
	assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리.
	spring-test: 스프링 통합 테스트 지원.

	 */

}
