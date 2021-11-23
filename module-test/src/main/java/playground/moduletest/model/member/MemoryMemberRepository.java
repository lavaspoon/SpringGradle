package playground.moduletest.model.member;

import java.util.HashMap;
import java.util.Map;

//구현체
public class MemoryMemberRepository implements MemberRepository {

    //저장소 -> Map
    private Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
