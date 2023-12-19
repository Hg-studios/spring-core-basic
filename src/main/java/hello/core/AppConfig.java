package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() { //MemberService 역할
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() { //orderService 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() { //MemberRepository 역할
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() { //discountPolicy 역할
        return new FixDiscountPolicy();
    }

}
