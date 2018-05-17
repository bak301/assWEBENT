package com.ass.controller;

import com.ass.DA.BookDAO;
import com.ass.DA.BookDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class BorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.valueOf(request.getParameter("bookId"));
        LocalDateTime borrowDateTime = LocalDateTime.parse(request.getParameter("borrowDateTime"));

        BookDAO dao = new BookDAOImpl();
        boolean result = dao.borrowBook(bookId, borrowDateTime);

        RequestDispatcher dispatcher = request.getRequestDispatcher(result ? "result.jsp" : "error.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("borrow.jsp").forward(request, response);
    }
}
