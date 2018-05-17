package com.ass.DA;

import com.ass.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBookByName(String name);
    List<Book> getBookById(int id);
    boolean updateBookState(int id, boolean isBorrowed);
}
