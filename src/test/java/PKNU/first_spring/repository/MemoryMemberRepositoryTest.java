/*
package PKNU.first_spring.repository;

import PKNU.first_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void deleteOne(){
        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member1);
        repository.save(member2);

        List<Member> result = repository.findAll();
        System.out.println("result = " + result);

        repository.deleteMember(member1);

        List<Member> result2 = repository.findAll();
        System.out.println("result = " + result2);
    }

    @Test
    public void findAll(){
        Member member2 = new Member();
        member2.setName("spring2");
        Member member4 = new Member();
        member4.setName("spring4");

        repository.save(member2);
        repository.save(member4);

        List<Member> result = repository.findAll();
        System.out.println("result = " + result);

    }
}
*/
