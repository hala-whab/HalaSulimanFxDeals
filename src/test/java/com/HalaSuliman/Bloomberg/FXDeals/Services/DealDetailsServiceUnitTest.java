package com.HalaSuliman.Bloomberg.FXDeals.Controller;
import com.HalaSuliman.Bloomberg.FXDeals.Entites.DealDetails;
import com.HalaSuliman.Bloomberg.FXDeals.Reposeitory.DealDetailsRepo;
import com.HalaSuliman.Bloomberg.FXDeals.Services.DealDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DealDetailsServiceUnitTest {

        @Mock
        private DealDetailsRepo dealDetailsRepo;
        @InjectMocks
        private DealDetailsService dealDetailsService;

        DealDetails dealDetails;

        @BeforeEach
        public void setup(){
             dealDetails = new DealDetails(Currency.getInstance("AED"),Currency.getInstance("USD"), System.currentTimeMillis(),20.0);

        }
        @Test
        @Order(1)
        public void saveDealDetailsTest()  {
            given(dealDetailsRepo.save(dealDetails)).willReturn(dealDetails);

            //action
            DealDetails savedDealDetails = dealDetailsService.addDealDetails(dealDetails).getBody();

            // verify the output
            System.out.println(savedDealDetails);
            assertThat(savedDealDetails).isNotNull();
        }
}
