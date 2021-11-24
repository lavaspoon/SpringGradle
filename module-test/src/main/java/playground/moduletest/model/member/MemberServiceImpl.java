package playground.moduletest.model.member;

//관례상 구현체가 1개 일때는 인터페이스 뒤에 Impl 이라는 단어를 많이 씀
public class MemberServiceImpl implements MemberService{

    //인터페이스만 가지고 있으면 null point 인셉션 발생하므로 구현객체를 선택해줘야함 -> MemoryMemberRepository
    //나는 MemoryMemberRepository의 save를 호출하고 싶어. 근데 이 MemoryMemberRepository는 MemberRepository의 인터페이스르 implement 하네?
    /**
     * join()에서 save 호출시, 다형성에의해서
     * MemoryMemberRepository에 있는 MemberRepository 인터페이스가 아니라
     * MemoryMemberRepository에 있는 Override 한 save() 가 호출됨
     */
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //생성자를 통해 memberRepository에 어떤 구현체가 들어갈지 정함
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
