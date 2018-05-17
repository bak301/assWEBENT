package com.ass.DA;

import com.ass.entity.Book;

import java.time.LocalDateTime;
import java.util.List;

public interface BookDAO {
    List<Book> getBookByName(String name);
    List<Book> getBookById(int id);

    boolean returnBook(int id, LocalDateTime returnDate);

    boolean borrowBook(int bookId, LocalDateTime borrowDate);
}
