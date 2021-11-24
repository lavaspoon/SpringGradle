package playground.moduletest.discount;

import playground.moduletest.model.member.Grade;
import playground.moduletest.model.member.Member;

// 인터페이스 DiscountPolicy 에 대한 구현체
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
