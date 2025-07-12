package com.HalaSuliman.Bloomberg.FXDeals.Controller;
import com.HalaSuliman.Bloomberg.FXDeals.Entites.DealDetails;
import com.HalaSuliman.Bloomberg.FXDeals.Services.DealDetailsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FxController {
    private static final Logger logger = LoggerFactory.getLogger(FxController.class);
    @Autowired
    DealDetailsService dealDetailsService;
    @GetMapping("/getDeals")
    public ResponseEntity<List<DealDetails>> getDeals() {
        logger.info("getDeals Request");
        return new ResponseEntity<>(dealDetailsService.getDealDetails(), HttpStatus.OK);
    }
    @PostMapping("/addDeal")
    public ResponseEntity<DealDetails> addDeal(@Valid @RequestBody DealDetails dealDetails) {
       logger.info("addDeal Request with dealDetails: {}", dealDetails);
        return dealDetailsService.validateDealDetails(dealDetails);
    }
}
