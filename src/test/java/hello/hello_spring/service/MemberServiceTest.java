package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;

/*
MemberService memberService = new MemberService();
원래 정상적으로 import를 해줘야 하는데.. 다른 패키지니까..
그런데 인텔리제이에서 내부적으로 이미 해서 문제 없음.
 */

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

  MemberService memberService;

  MemoryMemberRepository memberRepository;

  // ctrl+r은 이전에 실행 했던 것을 실행해줌.
  @BeforeEach
  public void beforeEach() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }


  @AfterEach
  public void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void 회원가입() {
    //given
    Member member = new Member();
    member.setName("hello");

    //when
    Long saveId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(saveId).get();
    Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  public void 중복_회원_예외() {
    //given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    //when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");



    //member1을 넣으면 예외가 터져야함.

    /*
    try {
      memberService.join(member2);
      fail();
    } catch (IllegalStateException e) {
      Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

     */


  }


}

/*
class MemberServiceTest {

  MemberService memberService;
  MemoryMemberRepository memberRepository;

  @BeforeEach
  public void beforeEach() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach
  public void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  public void 회원가입() throws Exception {

    //Given
    Member member = new Member();
    member.setName("hello");

    Member member2 = new Member();
    member.setName("spring");

    //When
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class,
        () -> memberService.join(member2));

    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

  }

}
 */