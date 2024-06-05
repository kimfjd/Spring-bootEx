package com.kh.totalEx.repository;

import com.kh.totalEx.entity.Cart;
import com.kh.totalEx.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional // 데이터베이스의 논리적인 작업 단위
@TestPropertySource(locations = "classpath:application-test.properties")
class CartRepositoryTest {
    @Autowired //스트링 컨태이너에서 해당 빈에 해당하는 의존성을 주입 받음
    CartRepository cartRepository;
    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext // JPA에의 EntityManager를 사용하겠다는 의미(의존성 주입을 받음)
    EntityManager em;

    // 회원 엔티티 생성
    public Member createMemberInfo(){
        Member member = new Member();
        member.setEmail("kimfjd@naver.com");
        member.setPwd("rla123");
        member.setName("김동환");
        member.setRegDate(LocalDateTime.now());
        return member;
    }
    @Test
    @DisplayName("장바구니와 회원 정보 매핑 테스트")
    public void findCartAndMemberTest(){
        Member member = createMemberInfo();
        memberRepository.save(member);
        Cart cart= new Cart();
        cart.setCardName("오늘의 쇼팡");
        cart.setMember(member);
        cartRepository.save(cart);

        em.flush(); // 데이터베이스에 강제 반영
        em.clear();

        // Cart saveVart = cartRepository.findById(cart.getId()).orElse(EntityNotFoundException::new)
        Optional<Cart> saveCart = cartRepository.findById(cart.getId());
        if(saveCart.isPresent()){
            Cart testCart=saveCart.get();
            log.info(testCart.getMember().getEmail());
        }
    }
}