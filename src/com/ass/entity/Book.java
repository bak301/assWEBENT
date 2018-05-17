package com.ass.entity;
import java.util.List;

public class Book {
    private int id;
    private String name;
    private String author;
    private boolean isBorrowed;
    private List<BorrowHistory> history;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public List<BorrowHistory> getHistory() {
        return history;
    }

    public void setHistory(List<BorrowHistory> history) {
        this.history = history;
    }
}
