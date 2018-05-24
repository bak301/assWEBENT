package com.assignment.DA;

import com.assignment.entity.Book;
import com.assignment.entity.BorrowHistory;
import com.assignment.utility.SQLDateTimeFormatter;
import org.mariadb.jdbc.MariaDbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private MariaDbConnection con;

    public BookDAOImpl() {
        con = DBConnect.getConnection();
    }

    @Override
    public List<Book> getBookByName(String name) {
        try {
            if (con == null) {
                System.out.println("CONNECTION IT\"S NULL  !");
                return null;
            }
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
    public Book getBookById(int id)
    {
        try {
            String query = "select * from book where id=?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));

            return book;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateHistory(int id, LocalDateTime returnDate) {
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
    public boolean createBorrowHistory(int bookId, LocalDateTime borrowDate) {
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
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));

            list.add(book);
        }
        rs.close();
        return list;
    }

    @Override
    public List<BorrowHistory> getHistories(int id) {
        String query = "select * from borrowHistory inner join book on book.id=borrowHistory.book_id where borrowHistory.book_id = ? order by borrow_date";
        LinkedList<BorrowHistory> list = new LinkedList<>();
        try {
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                BorrowHistory history = new BorrowHistory();
                history.setId(rs.getInt("id"));
                history.setBook_id(rs.getInt("book_id"));
                history.setBorrowedTime(rs.getTimestamp("borrow_date").toLocalDateTime());
                history.setReturnedTime(rs.getTimestamp("return_date").toLocalDateTime());
                list.add(history);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
