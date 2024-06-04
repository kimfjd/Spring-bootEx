package com.kh.totalEx.repository;

import com.kh.totalEx.constant.ItemSellStatus;

import com.kh.totalEx.entity.Item;
import com.kh.totalEx.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations ="classpath:application-test.properties")
class MemberRepositoryTest {

@Autowired
MemberRepository memberRepository;

    @Test
    @DisplayName("맴버 저장 테스트")
    public void createMemberTest() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int randomInt = random.nextInt(10);
            Member member = new Member();
            member.setName(String.valueOf(randomInt));
            member.setPwd(String.valueOf(i));
            member.setEmail(String.valueOf(i));
            member.setIamge("null");
            member.setRegDate(LocalDateTime.now());
            memberRepository.save(member);
        }
    }
    @Test
    @DisplayName("모든 회원 출력 테스트")
    public void allFindTest(){
        this.createMemberTest();
        List<Member> memberList=memberRepository.findAll();
        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }
    @Test
    @DisplayName("이메일 회원 출력 테스트")
    public void emailFind(){
        this.createMemberTest();
        Optional<Member> memberList=memberRepository.findByEmail("1");
            System.out.println(memberList.toString());
    }
    @Test
    @DisplayName("이메일 회원가입 여부 출력 테스트")
    public void emailBooFind(){
        this.createMemberTest();
        Optional<Member> memberList=memberRepository.findByEmail("156565");
        if(memberList.isPresent()){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }

    @Test
    @DisplayName("로그인 여부 출력 테스트")
    public void loginTest(){
        this.createMemberTest();
        Optional<Member> memberList=memberRepository.findByEmailAndPwd("1","1");
            System.out.println(memberList.toString());
    }
//    @Test
//    @DisplayName("로그인 여부 출력 테스트")
//    public void logFind(){
//        this.createMemberTest();
//        Optional<Member> memberList=memberRepository.findByEmail("1");
//        if(memberList.isPresent()){
//            String pass=memberList.get().getPwd();
//            Optional<Member> memberpwd=memberRepository
//
//        }
//        else {
//            System.out.println("아이디가 없습니다");
//        }
//    }
}