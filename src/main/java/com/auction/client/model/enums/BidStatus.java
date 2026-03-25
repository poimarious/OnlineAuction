package com.auction.client.model.enums;

// Status of a bid transaction
public enum BidStatus {

    WINNING, // this bid is currently leading the auction

    OUTBID, // this bid has been surpassed

    REJECTED; // this bid is invalid

    public boolean isWinning() {return this == WINNING;} // check if this bid is currenly winning

    public boolean isAccepted() {return this != REJECTED;} // check if this bid is valid

}
