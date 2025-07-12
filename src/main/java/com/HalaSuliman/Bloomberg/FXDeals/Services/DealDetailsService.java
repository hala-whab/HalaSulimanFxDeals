package com.HalaSuliman.Bloomberg.FXDeals.Services;

import com.HalaSuliman.Bloomberg.FXDeals.Controller.FxController;
import com.HalaSuliman.Bloomberg.FXDeals.Entites.DealDetails;
import com.HalaSuliman.Bloomberg.FXDeals.Reposeitory.DealDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DealDetailsService {
    @Autowired
    private DealDetailsRepo dealDetailsRepo ;
    /*this value is readed from application configration to prevent
    past values for the Fx deal timestamp that has been older than the application start time
    here I assume that the start time is  Saturday, July 11, 2015 1:20:33 PM
     */
    @Value("${app.startTs}")
    private long startTs;
    private static final Logger logger = LoggerFactory.getLogger(DealDetailsService.class);

    public List<DealDetails> getDealDetails() {

        List<DealDetails> dealDetails = dealDetailsRepo.findAll();
        logger.info("getDealDetails Response{}", dealDetails);
         return dealDetails;
     }
     public ResponseEntity<DealDetails> validateDealDetails(DealDetails dealDetails) {
         /*this condition to validate deal amount is not null or zero */
         if (dealDetails.Deal_Amount != null && dealDetails.Deal_Amount > 0) {
             /*this condition is to validate deal timestamp is not in the future and not earlier than StartTs*/
             if (dealDetails.Deal_Timestamp <= System.currentTimeMillis() && dealDetails.Deal_Timestamp >= startTs) {
                 logger.info("validateDealDetails Response is okay checking duplicate ");
                 return addDealDetails(dealDetails);
             } else {
                 logger.error("validateDealDetails Response is incorrect TimeStamp");
                 throw new HttpMessageNotReadableException(" Enter Correct TimeStamp");
             }
         } else {
             logger.error("validateDealDetails Response is incorrect Deal Amount");
             throw new HttpMessageNotReadableException("Deal Amount can't be Null and  must be greater than 0");
         }
     }
    public ResponseEntity<DealDetails> addDealDetails(DealDetails dealDetails) {
        //try to save and throw exption when same vlaues tries to be saved twice
        /* Here validate the inputs First then will Save them
        will validate null values
        not correct currency values
         */
        dealDetailsRepo.save(dealDetails);
        logger.info("Saved to Database succesfully");
        return new ResponseEntity<>(dealDetails, HttpStatus.OK);
    }
}
