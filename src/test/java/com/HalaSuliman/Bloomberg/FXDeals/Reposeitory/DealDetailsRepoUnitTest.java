package com.HalaSuliman.Bloomberg.FXDeals.Reposeitory;

import com.HalaSuliman.Bloomberg.FXDeals.Entites.DealDetails;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Currency;
import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DealDetailsRepoUnitTest {
    @Autowired
    private DealDetailsRepo dealDetailsRepo;
    @Test
    @DisplayName("Test 1: Save Deal details")
    @Order(1)
    @Rollback(value = false)
    public void saveDealDetails() {
        /*Action*/
        DealDetails dealDetails = new DealDetails(Currency.getInstance("AED"),Currency.getInstance("USD"), System.currentTimeMillis(),20.0);
        dealDetailsRepo.save(dealDetails);
        /*Verify*/
        System.out.println(dealDetails);
        Assertions.assertTrue(dealDetails.getDeal_Unique_Id()>0, "deal Details id is greater than 0");
    }
    @Test
    @Order(2)
    public void getDealTest(){

        //Action
        DealDetails dealDetails = dealDetailsRepo.findById(1L).get();
        //Verify
        System.out.println(dealDetails);
        Assertions.assertEquals(1L, dealDetails.getDeal_Unique_Id());
    }
    @Test
    @Order(3)
    public void getListOfDealsDetailsTest(){
        //Action
        List<DealDetails> dealDetails = dealDetailsRepo.findAll();
        //Verify
        System.out.println(dealDetails);
        Assertions.assertFalse(dealDetails.isEmpty());

    }
}
