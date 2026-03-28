package com.auction.client.model;

import com.auction.client.model.enums.BidStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)


public class BidTransaction {
    private String id;
    private String auctionId;
    private String bidderId;
    private String bidderName;
    private double amount;
    private BidStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public BidTransaction(String id,
                          String auctionId,
                          String bidderId,
                          String bidderName,
                          double amount,
                          BidStatus status,
                          LocalDateTime timestamp) {

        this.id = id;
        this.auctionId = auctionId;
        this.bidderId = bidderId;
        this.bidderName = bidderName;
        this.amount = amount;
        this.status = status;
        this.timestamp = timestamp;
    }


    // Getters - Setters

    public String getId() {return id;}
    public String getAuctionId() {return auctionId;}
    public String getBidderId() {return bidderId;}
    public String getBidderName() {return bidderName;}
    public double getAmount() {return amount;}
    public BidStatus getStatus() {return status;}
    public LocalDateTime getTimeStamp() {return timestamp;}

    public void setId(String id) {this.id = id;}
    public void setAuctionId(String auctionId) {this.auctionId = auctionId;}
    public void setBidderId(String bidderId) {this.bidderId = bidderId;}
    public void setAmount(double amount) {this.amount = amount;}
    public void setBidderName(String bidderName) {this.bidderName = bidderName;}
    public void setStatus(BidStatus status) {this.status = status;}
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp;}

    // Override methods
    @Override
    public String toString() {
        return "BidTransaction{id='" + id  + ", bidder='" + bidderName + ", amount='" + amount + ", status='" + status + "}";
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof BidTransaction other)) return false;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
