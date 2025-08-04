package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository(); // 다형성

  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();


    Assertions.assertThat(member).isEqualTo(result);

  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    Member result = repository.findByName("spring1").get();


    Assertions.assertThat(result).isEqualTo(member1); // 초록불이 뜨면 정상적임.

  }

  @Test
  public void findAll() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> result = repository.findAll();


    Assertions.assertThat(result.size()).isEqualTo(2);

  }

  /*
  Test를 하면 임의의 순서대로 실행 되기 때문에 repository 같은 경우엔, 참조값이 고정 되어 있는데
  메서드마다 새로 객체를 생성하는데 이때는 참조값이 매번 달라짐.
  테스트를 하면 결과가 이상해 질 수 있다.

  이럴때, 데이터를 클리어 해봐야한다. (테스트를 독립적으로 만들어야 함.)
   */

}

/*
class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    //given
    Member member = new Member();
    member.setName("spring");

    //when
    repository.save(member);

    //then
    Member result = repository.findById(member.getId()).get();
    assertThat(result).isEqualTo(member);
  }

  @Test
  public void findByName() {
    //given
    Member member1 = new Member();
    member1.setName("spring");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");

    //when
    Member result = repository.findByName("spring1").get();

    //then
    assertThat(result).isEqualTo(member1);
  }

  @Test
  public void findAll() {
    //given
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    //when
    List<Member> result = repository.findAll();

    //then
    assertThat(result.size()).isEqualTo(2);
  }

}



 */
