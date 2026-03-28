package com.auction.client.model;

import com.auction.client.model.enums.AuctionStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Auction {

    private String id;
    private Item item;
    private double currentPrice;
    private String currentLeaderId;
    private String currentLeaderName;
    private AuctionStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;

    private int totalBids;
    private List<BidTransaction> bidHistory;


    public Auction(String id,
                   Item item,
                   double currentPrice,
                   String currentLeaderId,
                   String currentLeaderName,
                   AuctionStatus status,
                   LocalDateTime startTime,
                   LocalDateTime endTime) {
        this.id = id;
        this.item = item;
        this.currentPrice = currentPrice;
        this.currentLeaderId = currentLeaderId;
        this.currentLeaderName = currentLeaderName;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalBids = 0;
        this.bidHistory = new ArrayList<>();
    }

    // Help methods
    // check nếu lượt đấu giá đã được chấp nhận
    public boolean isAcceptingBids() {
        return status.isAcceptingBids();
    }

    // check nếu phiên đã kết thúc
    public boolean isEnded() {
        return status.isEnded();
    }

    // Tính thời gian(giây) còn lại của phiên
    public long getSecondRemaining() {
        return Math.max(0, java.time.Duration.between(LocalDateTime.now(), endTime).getSeconds());
    }

    // Thêm lượt bid vào lịch sử
    public void addBid(BidTransaction bid) {
        bidHistory.add(0, bid);
    }

    // Cập nhật lượt đấu giá dẫn đầu
    public void applyBidUpdate(double newPrice, String leaderId, String leaderName) {
        this.currentPrice = newPrice;
        this.currentLeaderId = leaderId;
        this.currentLeaderName = leaderName;
    }

    // Getters - Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCurrentLeaderId() {
        return currentLeaderId;
    }

    public void setCurrentLeaderId(String currentLeaderId) {
        this.currentLeaderId = currentLeaderId;
    }

    public String getCurrentLeaderName() {
        return currentLeaderName;
    }

    public void setCurrentLeaderName(String currentLeaderName) {
        this.currentLeaderName = currentLeaderName;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getTotalBids() {
        return totalBids;
    }

    public void setTotalBids(int totalBids) {
        this.totalBids = totalBids;
    }

    public List<BidTransaction> getBidHistory() {
        return bidHistory;
    }

    public void setBidHistory(List<BidTransaction> bidHistory) {
        this.bidHistory = bidHistory;
    }

    // Override methods

    @Override
    public String toString() {
        return "Auction{id='" + id + "', status=" + status + ", currentPrice=" + currentPrice + "}";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Auction other)) return false;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {return id.hashCode();}
}
