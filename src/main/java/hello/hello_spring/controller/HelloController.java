package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
맨 처음에 start.spring.io 에서 프로젝트 생성..

근데 처음엔 코드가 안 돌아감 . 왜 그런 걸까? JDK 17 버전을 안 맞췄었음. temurin - 17

JDK, SDK의 버전 문제가 있었음. 이거를 17로 맞춰주는게 좋음.

왜 17로 맞춰야할까? -> 버그 안정성 O, 가장 안정화 된 버전임.
 */

/*
웹 애플리케이션에서 첫번째 진입점은 Controller이다.
 */

@Controller
public class HelloController {

  @GetMapping("hello") // 만약에 GetMapping에 아무 것도 없으면 static 아래에 있는 파일을 찾는다. 단 파일은 index.html만..
  public String hello(Model model) {  // 여기서 model은 스프링에서 알아서 객체를 주입 해줌. 즉 컨트롤러는 Model에 의존.

    // 위에 GetMapping("hello")는 /hello를 웹에서 마주치는 순간 GetMapping 아래에 있는 메서드로 감.
    // Model addAttribute(String attributeName, @Nullable Object attributeValue);
    model.addAttribute("data", "spring!!");
    return "hello";

  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model) { // RequestParam은 외부에서 이름을 받아야함.
    model.addAttribute("name" , name); // url에서 받은 변수를 name으로. 즉 value값이 name.
    return "hello-template";
    // http://localhost:8080/hello-mvc?name=spring!!!!!!
  }



  /*
  실행을 하고 나서 whitelabel이 뜨면 아래 콘솔창을 본다.
  Resolved [org.springframework.web.bind.MissingServletRequestParameterException:
  Required request parameter 'name' for method parameter type String is not present]

  name을 외부에서 받아야함. 근데 내부 의미를 파악해보자.

  public @interface RequestParam {
  @AliasFor("name")
  String value() default "";

  @AliasFor("value")
  String name() default "";

  boolean required() default true;

  String defaultValue() default "\n\t\t\n\t\t\n\ue000\ue001\ue002\n\t\t\t\t\n";
  }

  RequestParam은 애초에 required() 메서드가 true로 default되어 있음.
  따라서 이름이 있으면 true인데 없으면 false라 에러가 뜸.
   */

  /*
  웹 애플리케이션에서 /hello라고 들어오면 hello 메서드를 호출.
   */


}

/*
@Controller // SpringBootApplication이 엔진, 출발하면 제일 먼저 오는 곳.
public class HelloController {

  @GetMapping("hello") // 만약에 GetMapping에 아무 것도 없으면 static 아래에 있는 파일을 찾는다. 단, index.html만..
  public String hello(Model model) { // 여기서 model은 스프링에서 알아서 객체를 주입 해줌 (Dependency Injection) 즉, 컨트롤러는 model에 의존.
    // 위에 GetMapping("hello")는 /hello를 웹에서 마주치는 순간 GetMapping 아래에 있는 메서드로 간다.
    model.addAttribute("data","spring!!");
    return "hello";
    // templates 밑에 있는 hello.html로 이동.

    컨트롤러에서 문자를 반환 한다면?

    뷰 리졸버(Resolver)가 화면을 찾아서 처리함.

    resources: templates/ + {ViewName} + .html

    여기서 ViewName은 return에 있는 것을 의미함.
  }


  참고사항: spring-boot-devtools 라이브러리를 추가하면, html 파일을 컴파일만 해주면
  서버 재시작 없이 View 파일 변경이 가능하다.


  인텔리제이에서 실행 하지 않고 빌드 한 다음에 실행 해보자.

  cmd창을 킨 다음에 hello-spring의 위치를 cd로 찾기

  찾은 후에 gradlew.bat build를 실행

  실행을 하면 BUILD SUCCESSFUL이 뜸.

  이 상태에서 libs 아래에 있는 jar파일 실행.

}

_________________________________________________________________________

스프링 웹 개발 기초

1. 정적 컨텐츠
-> 파일을 그대로 웹 브라우저에 내려다줌.

2. MVC와 템플릿 엔진
-> 서버에서 변형을 해서 html 파일을 내림.

3. API
-> JSON 데이터 포맷으로 클라이언트한테 데이터 전달.
 */

