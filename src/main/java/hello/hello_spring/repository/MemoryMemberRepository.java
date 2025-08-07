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
  }

  @Override
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

  @Override
  public Optional<Member> findByName(String name) {
    return store.values().stream()
              .filter(member -> member.getName().equals(name))
              .findAny();
  }

  public void clearStore() {
    store.clear();
  }

}


package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려

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
  }

  @Override
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

  public void clearStore() {
    store.clear();
  }

  @Override
  public Optional<Member> findByName(String name) {
    return store.values().stream()
            .filter(member -> member.getName().equals(name))
            .findAny();
  }

}


컬렉션 프레임워크에서 Map 인터페이스에 values()라는 메서드는 Collection형으로 반환.

ArrayList라는 클래스에는 생성자에 Collection형인 자료를 넣을 수 있음.






 */
