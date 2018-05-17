package com.ass.DA;

import com.ass.entity.Book;
import com.ass.entity.BorrowHistory;
import com.mysql.jdbc.MySQLConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private MySQLConnection con;

    public BookDAOImpl(MySQLConnection con) {
        this.con = con;
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
    public boolean updateBookState(int id, boolean isBorrowed) {
        try {
            String query = "update book set isborrowed = ? where id = ?";

            PreparedStatement stm = con.prepareStatement(query);
            stm.setBoolean(1, isBorrowed);
            stm.setInt(2, id);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private List<Book> getBookListFromResultSet(ResultSet rs) throws SQLException {
        LinkedList<Book> list = new LinkedList<>();
        while (rs.next()) {
            Book b = new Book();
            int id = rs.getInt("id");

            b.setId(id);
            b.setName(rs.getString("name"));
            b.setAuthor(rs.getString("author"));
            b.setBorrowed(rs.getBoolean("isborrowed"));
            b.setHistory(getBookHistory(id));

            list.add(b);
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
            history.setBorrowedTime(rs.getDate("borrow_date").toLocalDate());
            history.setReturnedTime(rs.getDate("return_date").toLocalDate());
            list.add(history);
        }
        return list;
    }
}
