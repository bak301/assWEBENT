package com.ass.controller;

import com.ass.DA.BookDAO;
import com.ass.DA.BookDAOImpl;
import com.ass.DA.DBConnect;
import com.ass.entity.Book;
import com.mysql.jdbc.MySQLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO dao = new BookDAOImpl();

        List<Book> list = new LinkedList<>();
        if (request.getParameter("sname") != null) {
            String name = request.getParameter("searchByName");
            list = dao.getBookByName(name);
        } else if (request.getParameter("sid") != null) {
            String data = request.getParameter("searchById");
            boolean isIdNull = "".equals(data);

            list = isIdNull ? new LinkedList<>() : dao.getBookById(Integer.valueOf(data));
        }

        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
}
