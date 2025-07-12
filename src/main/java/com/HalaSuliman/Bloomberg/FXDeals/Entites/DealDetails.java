package com.HalaSuliman.Bloomberg.FXDeals.Entites;
import jakarta.persistence.*;
import java.util.Currency;

@Entity
@Table(name = "deals_details",uniqueConstraints={
        @UniqueConstraint( name = "idx_col1_col2",
                columnNames ={"From_Currency_ISO_Code","To_Currency_ISO_Code","Deal_Timestamp","Deal_Amount"})
})

public class DealDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long Deal_Unique_Id;
    @Column(nullable = false)
    public Currency From_Currency_ISO_Code;
    @Column(nullable = false)
    public Currency To_Currency_ISO_Code;
    @Column(nullable = false)
    public long Deal_Timestamp;
    @Column(nullable = false)
    public Double Deal_Amount;
    public DealDetails( Currency from_Currency_ISO_Code,  Currency to_Currency_ISO_Code,  long deal_Timestamp,  Double deal_Amount) {
        From_Currency_ISO_Code = from_Currency_ISO_Code;
        To_Currency_ISO_Code = to_Currency_ISO_Code;
        Deal_Timestamp = deal_Timestamp;
        Deal_Amount = deal_Amount;
    }

    public DealDetails() {

    }

    public long getDeal_Unique_Id() {
        return Deal_Unique_Id;
    }

    public void setDeal_Unique_Id(long deal_Unique_Id) {
        Deal_Unique_Id = deal_Unique_Id;
    }

    public Currency getFrom_Currency_ISO_Code() {
        return From_Currency_ISO_Code;
    }

    public void setFrom_Currency_ISO_Code(Currency from_Currency_ISO_Code) {
        From_Currency_ISO_Code = from_Currency_ISO_Code;
    }

    public Currency getTo_Currency_ISO_Code() {
        return To_Currency_ISO_Code;
    }

    public void setTo_Currency_ISO_Code(Currency to_Currency_ISO_Code) {
        To_Currency_ISO_Code = to_Currency_ISO_Code;
    }

    public long getDeal_Timestamp() {
        return Deal_Timestamp;
    }

    public void setDeal_Timestamp(long deal_Timestamp) {
        Deal_Timestamp = deal_Timestamp;
    }

    public Double getDeal_Amount() {
        return Deal_Amount;
    }

    public void setDeal_Amount(Double deal_Amount) {
        Deal_Amount = deal_Amount;
    }
}
