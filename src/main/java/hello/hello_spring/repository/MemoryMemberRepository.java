package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

  private static Map<Long, Member> store = new HashMap<>();
  private static long sequence = 0L;



  @Override
  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    return Optional.ofNullable(store.get(id));
    //ofNullable()은 매개변수가 null 일 수도있어서  안전하게 ofNullable메서드를 씀. NPE를 방지하기 위함.

    /*
    public static <T> Optional<T> of(T value) {
    return new Optional<>(Objects.requireNonNull(value));
    }

    이건 of 메서드. value가 null이면 바로 NPE 터짐. null일수가 없음.

    public static <T> Optional<T> ofNullable(T value) {
      return value == null ? empty() : of(value);
    }

    ofNullable 메서드는 null이면 empty()를 반환 이때 empty()는 Optional 클래스의 value가 null
    하지만 Optional 형으로 감싼것.
     */
  }

  @Override
  public Optional<Member> findByName(String name) {
    return store.values().stream()
        .filter(member -> member.getName().equals(name))
        .findAny(); // name이 같으면 Option형이 반환 된다. 물론 Optional 클래스 멤버 변수 value의 형태는 Member.
  }

  @Override
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

  public void clearStore() {
    store.clear();
  }
}

/*
public class MemoryMemberRepository implements MemberRepository {

  private static Map<Long, Member> store = new HashMap<>();
  private static Long sequence = 0L;

  @Override
  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    return Optional.ofNullable(store.get(id));
  }

  //ofNullable()은 매개변수가 null 일 수도 있어서 안전하게 ofNullable메서드를 씀. NPE를 방지하기 위함.


    public static <T> Optional<T> of(T value) {
    return new Optional<>(Objects.requireNonNull(value));
    }

    이건 of 메서드. value가 null이면 바로 NPE 터짐. null일수가 없음.

    public static <T> Optional<T> ofNullable(T value) {
      return value == null ? empty() : of(value);
    }

    ofNullable 메서드는 null이면 empty()를 반환 이때 empty()는 Optional 클래스의 value가 null
    하지만 Optional 형으로 감싼것.

  @Override
  public Optional<Member> findByName(String name) {
    return store.values().stream()
        .filter(member -> member.getName().equals(name))
        .findAny(); // name이 같으면 Optional형이 반환 된다. 물론 Optional 클래스 멤버 변수 value의 형태는 Member.
  }

  @Override
  public Optional<Member> findByName(String name) {
    return store.values().stream()
            .filter(member -> member.getName().equals(name))
            .findAny(); // name이 같으면 Optional형 반환. 물론 Optional 클래스 멤버 변수 value의 형태는 Member.
  }

  @Override
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

}



 */
