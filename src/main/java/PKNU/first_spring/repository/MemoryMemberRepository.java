/*
package PKNU.first_spring.repository;

import PKNU.first_spring.domain.Member;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements StudentRepository {

    public static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public void deleteMember(Member member) {
        store.remove(member.getId());
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.sameName(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
*/
