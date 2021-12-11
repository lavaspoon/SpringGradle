package playground.moduletest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import playground.moduletest.discount.DiscountPolicy;
import playground.moduletest.discount.FixDiscountPolicy;
import playground.moduletest.discount.RateDiscountPolicy;
import playground.moduletest.model.member.MemberRepository;
import playground.moduletest.model.member.MemberService;
import playground.moduletest.model.member.MemberServiceImpl;
import playground.moduletest.model.member.MemoryMemberRepository;
import playground.moduletest.order.OrderService;
import playground.moduletest.order.OrderServiceImpl;

@Configuration
public class AppConfig {
//    public MemberService memberService() {
//        //생성자 주입
//        return new MemberServiceImpl(new MemoryMemberRepository()); //MemoryMemberRepository를 넘겨주면 생성자에 주입됨
//    }
//
//    public OrderService orderService() {
//        //생성자 주입 (DiscountPolicy - FixDiscount, RateDiscount 선택)
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }

    /**
     * 리팩토링
     */

    /**
     *
     *  . @Bean -> memberService -> new MemoryMemberRepository
     *  . @Bean -> 스프링 생성될때 orderService() 메서드 호출 -> new MemoryMemberRepository
     */

        @Bean
        public MemberService memberService() {
            //생성자 주입
            //System.out.println("call - AppConfig.memberService");
            return new MemberServiceImpl(memberRepository()); //MemoryMemberRepository를 넘겨주면 생성자에 주입됨
        }
        @Bean
        public MemberRepository memberRepository() {
            //System.out.println("call - AppConfig.memberRepository");
            return new MemoryMemberRepository();
        }
        @Bean
        public OrderService orderService() {
            //생성자 주입 (DiscountPolicy - FixDiscount, RateDiscount 선택)
            //System.out.println("call - AppConfig.orderService");
            return new OrderServiceImpl(memberRepository(), discountPolicy());
        }
        @Bean
        public DiscountPolicy discountPolicy() {
            //System.out.println("call - AppConfig.discountPolicy");
            return new RateDiscountPolicy();
        }
}

