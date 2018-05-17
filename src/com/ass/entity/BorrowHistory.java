package com.ass.entity;

import java.time.LocalDate;

public class BorrowHistory {
    private LocalDate borrowedTime;
    private LocalDate returnedTime;

    public LocalDate getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(LocalDate borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public LocalDate getReturnedTime() {
        return returnedTime;
    }

    public void setReturnedTime(LocalDate returnedTime) {
        this.returnedTime = returnedTime;
    }
}
