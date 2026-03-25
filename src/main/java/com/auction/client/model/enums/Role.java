package com.auction.client.model.enums;

// Role of a user
public enum Role {

    BIDDER,

    SELLER,

    ADMIN;

    public boolean canBid() {return this == BIDDER;} // check if user can bid

    public boolean canSell() {return this == SELLER;} // check if user can sell

    public boolean isAdmin() {return this == ADMIN;} // check if user is admin

}
