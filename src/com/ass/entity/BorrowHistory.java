package com.ass.entity;

import java.time.LocalDateTime;

public class BorrowHistory {
    private LocalDateTime borrowedTime;
    private LocalDateTime returnedTime;

    public LocalDateTime getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(LocalDateTime borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public LocalDateTime getReturnedTime() {
        return returnedTime;
    }

    public void setReturnedTime(LocalDateTime returnedTime) {
        this.returnedTime = returnedTime;
    }
}
