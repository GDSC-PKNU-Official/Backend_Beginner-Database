/*
package PKNU.first_spring.service;

import PKNU.first_spring.domain.Member;
import PKNU.first_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void setUp() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @Test
    public void 회원삭제(){
        //Arrange
        Member member1 = new Member();
        member1.setName("Spring1");
        Member member2 = new Member();
        member2.setName("Spring2");

        memberService.join(member1);
        memberService.join(member2);

        List<Member> result = memberRepository.findAll();

        //Act
        memberService.delete("Spring1");
        memberService.findMembers();

        //Assert
        List<Member> result1 = memberRepository.findAll();
        System.out.println("result = " + result1);
    }
}
*/
