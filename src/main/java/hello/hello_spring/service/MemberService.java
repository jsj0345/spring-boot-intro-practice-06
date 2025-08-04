package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service
public class MemberService {

  // Test를 하고 싶으면 ctrl+shift+T

  private final MemberRepository memberRepository;

  //@Autowired // 멤버 서비스를 생성 할 때, 스프링이 멤버 리포지토리가 필요 하다고 생각하고 서비스에 주입 시켜줌.
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * 회원 가입.
   */
  public Long join(Member member) {
    //같은 이름이 있는 중복 회원X
    validateDuplicateMember(member); // 중복 회원 검증.

    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    Optional<Member> result = memberRepository.findByName(member.getName());
    result.ifPresent(m -> {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    });
  }

  /**
   *
   * 전체 회원 조회
   */

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }


}

/*
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Long join(Member member) {
    validateDuplicateMember(member);  // 중복 회원 검증
    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent( m -> {
                 throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
  }

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }

}

 */
