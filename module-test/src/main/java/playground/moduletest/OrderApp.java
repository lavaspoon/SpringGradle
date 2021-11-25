package playground.moduletest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import playground.moduletest.model.member.Grade;
import playground.moduletest.model.member.Member;
import playground.moduletest.model.member.MemberService;
import playground.moduletest.model.member.MemberServiceImpl;
import playground.moduletest.order.Order;
import playground.moduletest.order.OrderService;
import playground.moduletest.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        //스프링컨테이너 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        //MemberService memberService = new MemberServiceImpl(); //1
        //OrderService orderService = new OrderServiceImpl(); //2

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);//1에 값을 넣고 : memberService.join(member)

        Order order = orderService.createOrder(memberId, "itemA", 20000); //2에서 값을 뺴: orderService.createOrder.createOrder()

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
