package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

/*
Repository는 domain을 DB에 저장하거나 불러오는 통로.
 */

public interface MemberRepository {
  Member save(Member member);
  Optional<Member> findById(Long id);
  Optional<Member> findByName(String name);
  List<Member> findAll();

}

/*
public interface MemberRepository {
  Member save(Member member);
  Optional<Member> findById(Long id);
  Optional<Member> findByName(String name);
  List<Member> findAll();
}

 */

/*
Optional은 null 그대로 반환하지 않고 Optional을 감싸서 반환.
 */
