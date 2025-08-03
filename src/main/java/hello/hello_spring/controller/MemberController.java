package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
스프링 빈을 등록하는 2가지 방법 (pdf 파일 보면 초록색 동그라미가 빈을 의미.)

1. 컴포넌트 스캔과 자동 의존관계 설정. (왜 컴포넌트 스캔일까? @Controller에 마우스를 갖다 대고 살펴보자. (@Component가 있음)
2. 자바 코드로 직접 스프링 빈 등록하기.

스프링 빈을 등록하니까 좀 기능이 편리해진 것 같다.

그럼 빈을 아무곳이나 등록 해도 되나? -> X.

_______________________________________

컴포넌트 스캔은 아무렇게 하나?

-> 이것도 아니다. 왜냐하면 우리가 프로그램을 실행할 때, HelloSpringApplication에서 시작 한다.
그럼 HelloSpringApplication이 속한 패키지의 하위 폴더 들은 전부 컴포넌트 스캔의 대상이 된다!

*참고 : 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다.(유잃하게 하나만 등록해서 공유)
따라서 같은 스프링 빈이면 모두 같은 인스턴스다.

_______________________________________

컴포넌트는 컨테이너 관리 대상이 될 "후보", 빈은 이미 관리 대상임. (오해 X)


_______________________________________
Dependency Injection(의존성 주입) 3가지 방법.

1. 생성자를 통한 주입
public MemberController(MemberService memberService) {
  this.memberService = memberService;
}

2. 필드 주입
@Autowired private MemberService memberService; (좋은 방식은 아님!)

3. Setter주입
@Autowired
public void setMemberService(MemberService memberService) {
  this.memberService = memberService;
}

public 노출이라 별로임.

요즘 트랜드는 "생성자를 통한 주입"이다.


 */





@Controller // @Controller 는 스프링이 뜰 때 생성을 해서 관리를 함.
public class MemberController {

  private final MemberService memberService;

  /*
  new로 생성해서 쓸 수도 있긴 함.
  그런데 스프링이 관리를 하게 되면 스프링 컨테이너에 등록을 하고
  컨테이너 안에서 받아서 쓰도록 바꿈.
   */

  @Autowired
  /*
  @Autowired를 쓰면 멤버 컨트롤러가 생성이 될 때 스프링 빈에 등록되어 있는 멤버 서비스 객체를 갖다 줌. (Dependency Injection)
  */
  public MemberController(MemberService memberService) { // 생성자를 통해서 서비스가 들어옴 (생성자 주입)
    this.memberService = memberService;

    /*
    @Controller를 쓰면 스프링이 뜰 때 스프링 컨테이너에서 관리
    @Autowired는 스프링이 스프링 컨테이너에 있는 MemberService를 연결 해주는 것.

    MemberService에 따로 어노테이션을 지정 하지 않으면 스프링 컨테이너에 있을 수가 없음. (애초에 스프링이 관리를 못 함.)
    어노테이션을 달아보자.

    @Autowired 를 통한 DI는 helloController, MemberService 등과 같이 스프링이 관리하는 객체(빈)에서만 동작 한다.

    스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
    */
  }




}


