package com.kh.totalEx.repository;

import com.kh.totalEx.entity.Board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations ="classpath:application-test.properties")
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("맴버 저장 테스트")
    public void createMemberTest() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int randomInt = random.nextInt(10);
            int randomIn1 = random.nextInt(100);
            Board board = new Board();
            board.setTitle(String.valueOf(randomInt));
            board.setContent(String.valueOf(randomIn1));
            board.setImgPath(String.valueOf(i));
            board.setRegDate(LocalDateTime.now());
            boardRepository.save(board);
        }

    }

    @Test
    @DisplayName("키워드 검색 테스트")
    public void findByBoardNmContainingTest() {
        this.createMemberTest();
        List<Board> BoardSer = boardRepository.findByContent("10");
        for (Board board : BoardSer) {
            System.out.println(board.toString());
        }
    }

    @Test
    @DisplayName("게시판 전부 출력 테스트")
    public void findByallTest() {
        this.createMemberTest();
        List<Board> BoardSer = boardRepository.findAll();
        for (Board board : BoardSer) {
            System.out.println(board.toString());
        }
    }
}