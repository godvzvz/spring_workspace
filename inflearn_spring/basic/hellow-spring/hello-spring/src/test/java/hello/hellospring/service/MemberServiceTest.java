package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository repository;
    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }
    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("asdf");

        // when
        long id = memberService.join(member);

        // then
        Member findMember = memberService.findOne(id).get();
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void 중복체크(){
        Member member1 = new Member();
        member1.setName("asdf");

        Member member2 = new Member();
        member2.setName("asdf");

        // when

        memberService.join(member1);
        // 구방식
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
//        }

        // throws
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}