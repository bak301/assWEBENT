package com.assignment.model;

import com.assignment.DA.BookDAO;
import com.assignment.DA.BookDAOImpl;
import com.assignment.entity.Book;
import com.assignment.entity.BorrowHistory;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class BookBean implements Serializable {
    private Book book;
    private List<BorrowHistory> histories;
    private BookDAO dao;

    public BookBean() {
        setDao(new BookDAOImpl());
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<BorrowHistory> getHistories() {
        return histories;
    }

    public void setHistories(List<BorrowHistory> histories) {
        this.histories = histories;
    }

    public void setDao(BookDAO dao) {
        this.dao = dao;
    }

    public List<Book> getBooksByName(String name) {
        return dao.getBookByName(name);
    }

    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

    public List<BorrowHistory> getHistoriesByBookId(int id) {
        return dao.getHistories(id);
    }

    public boolean borrowBook(int bookId, LocalDateTime time) {
        return dao.createBorrowHistory(bookId, time);
    }

    public boolean returnBook(int id, LocalDateTime time) {
        return dao.updateHistory(id, time);
    }
}
