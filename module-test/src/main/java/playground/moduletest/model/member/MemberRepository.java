package playground.moduletest.model.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
