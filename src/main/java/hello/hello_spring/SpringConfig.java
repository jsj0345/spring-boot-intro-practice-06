package hello.hello_spring;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration // Spring이 뜰 때, Configuration을 읽고 @Bean을 보고 스프링 빈에 등록하라고 인식함.
public class SpringConfig {

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  /*
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
  여기서 MemberRepository형을 매개변수로 필요로 함. 그래서 아래에 memberRepository() 메서드에 객체를 생성해서 생성한 객체를 반환한 다음
  생성자에 넣어준 것.
   */

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
}

/*
@Configuration
public class SpringConfig {

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

}
 */
