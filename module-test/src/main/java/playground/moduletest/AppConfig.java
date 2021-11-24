package playground.moduletest;

import playground.moduletest.discount.FixDiscountPolicy;
import playground.moduletest.discount.RateDiscountPolicy;
import playground.moduletest.model.member.MemberService;
import playground.moduletest.model.member.MemberServiceImpl;
import playground.moduletest.model.member.MemoryMemberRepository;
import playground.moduletest.order.OrderService;
import playground.moduletest.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        //생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository()); //MemoryMemberRepository를 넘겨주면 생성자에 주입됨
    }

    public OrderService orderService() {
        //생성자 주입 (DiscountPolicy - FixDiscount, RateDiscount 선택)
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
