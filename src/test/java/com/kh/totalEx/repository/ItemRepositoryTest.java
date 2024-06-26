package com.kh.totalEx.repository;

import com.kh.totalEx.constant.ItemSellStatus;
import com.kh.totalEx.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000);
            item.setItemDetail("테스트 상품 상세 설명");
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepository.save(item);
        }
    }

    //    @Test
//    @DisplayName(" 상품명 조회 테스트")
//    public void findByItemNmTest() {
//        this.createItemTest();
//        List<Item> itemList = itemRepository.findByItemNm("테스트 상품3");
//        for (Item item : itemList) {
//            System.out.println(item.toString());
//        }
//    }
//        @Test
//        @DisplayName(" 상품명 또는 상품상세데이터 조회")
//        public void findByItemNmOrItemDetailTest() {
//            this.createItemTest();
//            List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트상품 1", "테스트 상품 상세 설명5");
//            for (Item item : itemList) {
//                System.out.println(item.toString());
//
//            }
//        }
//        @Test
//        @DisplayName("가격 LessThan 테스트")
//        public void findByPriceLessThanTest() {
//            this.createItemTest();
//            List<Item> itemList = itemRepository.findBypriceLessThanOrderByPriceDesc(10005);
//            for(Item item : itemList) {
//                System.out.println(item.toString());
//                LOGGER.info(item.toString());
//            }
//        }
//    @Test
//    @DisplayName("가격 Between 범위 테스트")
//    public void findByPriceBetweenTest() {
//        this.createItemTest();
//        List<Item> itemList = itemRepository.findByPriceBetween(100, 10000);
//        for (Item item : itemList) {
//            System.out.println(item.toString());
//        }
//    }

//    @Test
//    @DisplayName("키워드 검색 테스트")
//    public void findByItemNmContainingTest() {
//        this.createItemTest();
//        List<Item> itemList = itemRepository.findByItemNmContaining("상품1");
//        for (Item item : itemList) {
//            System.out.println(item.toString());
//        }
//    }
    @Test
    @DisplayName("@Query를 이용한 검색 기능 구현")
    public void findByItemDetailTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemDetailByNative("테스트 상품");
        for(Item e: itemList) System.out.println(e.toString());
    }



}