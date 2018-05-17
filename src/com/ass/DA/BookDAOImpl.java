package com.ass.DA;

import com.ass.entity.Book;
import com.ass.entity.BorrowHistory;
import com.ass.utility.SQLDateTimeFormatter;
import com.mysql.jdbc.MySQLConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private MySQLConnection con;

    public BookDAOImpl() {
        con = DBConnect.getConnection();
    }

    @Override
    public List<Book> getBookByName(String name) {
        try {
            String query = "select * from book where name like ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, "%" + name + "%");

            ResultSet rs = stm.executeQuery();
            return getBookListFromResultSet(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Book> getBookById(int id)
    {
        try {
            String query = "select * from book where id=?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();
            return getBookListFromResultSet(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean returnBook(int id, LocalDateTime returnDate) {
        try {
            String query = "update borrowHistory set return_date = ? where id = ?";

            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, SQLDateTimeFormatter.format(returnDate));
            stm.setInt(2, id);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean borrowBook(int bookId, LocalDateTime borrowDate) {
        try {
            String query = "INSERT into borrowHistory (book_id, borrow_date) values (?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, bookId);
            stm.setString(2, SQLDateTimeFormatter.format(borrowDate));

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private List<Book> getBookListFromResultSet(ResultSet rs) throws SQLException {
        LinkedList<Book> list = new LinkedList<>();
        while (rs.next()) {
            Book book = new Book();
            int id = rs.getInt("id");

            book.setId(id);
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setBorrowed(rs.getBoolean("isborrowed"));
            book.setHistory(getBookHistory(id));

            list.add(book);
        }
        rs.close();
        return list;
    }

    private List<BorrowHistory> getBookHistory (int id) throws SQLException{
        String query = "select * from borrowHistory inner join book on book.id=borrowHistory.book_id where borrowHistory.book_id = ?";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        LinkedList<BorrowHistory> list = new LinkedList<>();

        while (rs.next()) {
            BorrowHistory history = new BorrowHistory();
            history.setBorrowedTime(rs.getTimestamp("borrow_date").toLocalDateTime());
            history.setReturnedTime(rs.getTimestamp("return_date").toLocalDateTime());
            list.add(history);
        }
        return list;
    }
}
