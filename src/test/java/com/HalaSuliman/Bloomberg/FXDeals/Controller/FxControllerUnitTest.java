package com.HalaSuliman.Bloomberg.FXDeals.Controller;
import com.HalaSuliman.Bloomberg.FXDeals.Entites.DealDetails;
import com.HalaSuliman.Bloomberg.FXDeals.Services.DealDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Currency;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(controllers = FxController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FxControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DealDetailsService dealDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    DealDetails dealDetails;

    @BeforeEach
    public void setup(){
         dealDetails = new DealDetails(Currency.getInstance("AED"),Currency.getInstance("USD"), System.currentTimeMillis(),20.0);


    }

    //Post Controller
    @Test
    @Order(1)
    public void saveDealDetailsTest() throws Exception {
        // precondition
        given(dealDetailsService.addDealDetails(any(DealDetails.class))).willReturn(ResponseEntity.ok(dealDetails));

        // action
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/addDeal")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dealDetails)));

        // verify
        response.andDo(print()).
                andExpect(MockMvcResultMatchers.status().isOk());
    }
}
