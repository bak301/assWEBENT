package com.ass.controller;

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
import java.util.LinkedList;
import java.util.List;

public class CrudServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MySQLConnection con = DBConnect.getConnection();
        BookDAOImpl dao = new BookDAOImpl(con);

        List<Book> list = new LinkedList<>();
        if (request.getParameter("sname") != null) {
            String name = request.getParameter("searchByName");
            list = dao.getBookByName(name);
        } else if (request.getParameter("sid") != null) {
            int id = Integer.valueOf(request.getParameter("searchById"));
            list = dao.getBookById(id);
        }

        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
