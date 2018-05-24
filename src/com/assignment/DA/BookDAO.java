package com.assignment.DA;

import com.assignment.entity.Book;
import com.assignment.entity.BorrowHistory;

import java.time.LocalDateTime;
import java.util.List;

public interface BookDAO {
    List<Book> getBookByName(String name);

    Book getBookById(int id);

    boolean updateHistory(int id, LocalDateTime returnDate);

    boolean createBorrowHistory(int bookId, LocalDateTime borrowDate);

    List<BorrowHistory> getHistories(int id);
}
