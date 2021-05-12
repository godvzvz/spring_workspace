package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring!!");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        // test case
//        Assertions.assertEquals(member, result);
//        Assertions.assertEquals(member, null);

//        assertThat(member).isEqualTo(result);
        Assertions.assertThat(member).isEqualTo(null);
    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setName("spr1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spr2");
        repository.save(member2);

        Member result = repository.findByName("spr1").get();
        Assertions.assertThat(result).isEqualTo(member1);
//        Assertions.assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spr1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spr2");
        repository.save(member2);

        int size = repository.findAll().size();
        Assertions.assertThat(size).isEqualTo(2);

    }
}
