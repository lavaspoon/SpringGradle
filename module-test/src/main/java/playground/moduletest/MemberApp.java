package playground.moduletest;

import playground.moduletest.model.member.Grade;
import playground.moduletest.model.member.Member;
import playground.moduletest.model.member.MemberService;
import playground.moduletest.model.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
