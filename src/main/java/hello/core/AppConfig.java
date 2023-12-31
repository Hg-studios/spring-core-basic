package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    //스프링 컨테이너에 등록이 됨
    public MemberService memberService() { //MemberService 역할
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() { //orderService 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() { //MemberRepository 역할
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() { //discountPolicy 역할
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
