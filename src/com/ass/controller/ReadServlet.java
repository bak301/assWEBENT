package com.ass.controller;

import com.ass.entity.Book;
import com.ass.entity.BorrowHistory;
import com.ass.model.BookBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookBean bean = new BookBean();

        List<BookBean> bookList = new LinkedList<>();
        if (request.getParameter("sname") != null) {
            String name = request.getParameter("searchByName");
            List<Book> books = bean.getBooksByName(name);

            for (Book b : books) {
                BookBean bookModel = new BookBean();
                bookModel.setBook(b);

                List<BorrowHistory> histories = bean.getHistoriesByBookId(b.getId());
                bookModel.setHistories(histories);
                bookList.add(bookModel);
            }

        } else if (request.getParameter("sid") != null) {
            String strId = request.getParameter("searchById");
            boolean isIdNull = "".equals(strId);

            if (!isIdNull) {
                int id = Integer.valueOf(strId);

                BookBean model = new BookBean();
                Book b = new Book();
                List<BorrowHistory> histories = bean.getHistoriesByBookId(b.getId());

                model.setBook(b);
                model.setHistories(histories);
                bookList.add(model);
            }
        }

        request.setAttribute("list", bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

}
