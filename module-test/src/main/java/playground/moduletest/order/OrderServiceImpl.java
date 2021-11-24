package playground.moduletest.order;

import playground.moduletest.discount.DiscountPolicy;
import playground.moduletest.discount.FixDiscountPolicy;
import playground.moduletest.discount.RateDiscountPolicy;
import playground.moduletest.model.member.Member;
import playground.moduletest.model.member.MemberRepository;
import playground.moduletest.model.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    //메모리 회원 리포지토리와, 고정 금액 할인 정책을 구현체로 생성한다.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //final -> 생성자 필요

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
