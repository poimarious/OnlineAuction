
package com.auction.client.model.enums;

// Status of an Auction session
public enum AuctionStatus {

    // OPEN -> RUNNING |-> FINISHED -> PAID
    //                 |-------------> CANCELED

    OPEN, // Session created

    RUNNING, // Session in progress

    FINISHED, // Winner determined

    PAID, // Winner has successfully completed the payment

    CANCELED; // Session aborted

    public boolean isAcceptingBids() { // Check if session is open for bidding
        return this == RUNNING;
    }

    public boolean isEnded() { // Check if session has ended
        return this != OPEN && this != RUNNING;
    }
}