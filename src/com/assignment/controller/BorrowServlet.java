package com.assignment.controller;

import com.assignment.model.BookBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class BorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("_method") != null) {
            doPut(request, response);
            return;
        }
        int bookId = Integer.valueOf(request.getParameter("bookId"));
        String datetime = request.getParameter("borrowDateTime") + ":01";

        BookBean bean = new BookBean();
        boolean result = bean.borrowBook(bookId, LocalDateTime.parse(datetime));

        response.sendRedirect(result ? "/result.jsp" : "/error.jsp");
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        LocalDateTime returnDateTime = LocalDateTime.parse(request.getParameter("returnDateTime") + ":01");

        BookBean bean = new BookBean();
        boolean result = bean.returnBook(id, returnDateTime);

        response.sendRedirect(result ? "/result.jsp" : "/error.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        String id = request.getParameter("id");

        if (bookId != null) {
            request.setAttribute("bookId", bookId);
            request.getRequestDispatcher("/borrow.jsp").forward(request, response);
        } else if (id != null) {
            request.setAttribute("id", id);
            request.getRequestDispatcher("/return.jsp").forward(request, response);
        }
    }
}
