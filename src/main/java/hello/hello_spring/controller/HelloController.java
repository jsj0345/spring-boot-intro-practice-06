package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    // templates 밑에 있는 hello.html을 찾아 감.

    /*
    컨트롤러에서 리턴 값으로 문자를 반환하면..

    뷰 리졸버(viewResolver)가 화면을 찾아서 처리한다.

    resources:templates/ + {ViewName} + .html

    여기서 ViewName은 return에 있는 것을 의미함.

     */

    /*
    참고사항: spring-boot-devtools 라이브러리를 추가하면, html 파일을 컴파일만 해주면
    서버 재시작 없이 View 파일 변경이 가능하다.
     */
  }

  /*
  웹 애플리케이션에서 /hello라고 들어오면 hello 메서드를 호출.
   */

  /*
  인텔리제이에서 실행 하지 않고 빌드 한 다음에 실행 해보자.

  cmd창을 킨 다음에 hello-spring의 위치를 cd로 찾기

  찾은 후에 gradlew.bat build를 실행

  실행을 하면 BUILD SUCCESSFUL이 뜸.

  이 상태에서 libs 아래에 있는 jar파일 실행.
   */

}


