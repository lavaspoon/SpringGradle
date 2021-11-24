package playground.moduletest.discount;

import playground.moduletest.model.member.Grade;
import playground.moduletest.model.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountFixAmount / 100;
        } else {
            return 0;
        }
    }
}
