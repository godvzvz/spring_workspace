package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    public final MemberRepository repository;
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름 중복 체크
        validateDuplicateMember(member);

        repository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
            .ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재하는 회원");
        });
    }

    public List<Member> findMembers(){
        return repository.findAll();
    }

    public Optional<Member> findOne(long id){
        return repository.findById(id);
    }

}
