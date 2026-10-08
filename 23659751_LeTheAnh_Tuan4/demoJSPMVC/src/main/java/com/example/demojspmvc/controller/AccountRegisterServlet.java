package com.example.demojspmvc.controller;

import com.example.demojspmvc.model.Account;
import com.example.demojspmvc.util.AccountUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@WebServlet("/registerform")
public class AccountRegisterServlet extends HttpServlet {
    private AccountUtil accountUtil;
    @Resource(name="jdbc/storedb")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        accountUtil= new AccountUtil(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname= req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int ngay= Integer.parseInt(req.getParameter("birthDay"));
        int thang= Integer.parseInt(req.getParameter("birthMonth"));
        int nam= Integer.parseInt(req.getParameter("birthYear"));

        LocalDate lcDate= LocalDate.of(nam,thang,ngay);
        Date date= Date.valueOf(lcDate);

        Account acc= new Account(fname,lastname,email,password,date);

        try {
            accountUtil.themAccount(acc);
            List<Account> accounts= accountUtil.getDsAccount();
            req.setAttribute("accounts",accounts);
            req.getRequestDispatcher("WEB-INF/views/account.jsp").forward(req,resp);
        }catch (Exception e) {
            throw new RuntimeException(e);
            }


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/accountform.jsp").forward(req, resp);
    }

}
