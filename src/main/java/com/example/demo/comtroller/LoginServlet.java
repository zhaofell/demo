package com.example.demo.comtroller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.impl.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserRepository userRepository =new UserRepositoryImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userRepository.findByUsernameAngPassword(
                req.getParameter("username"), req.getParameter("password"));
        if(user!=null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("main.jsp");
        } else {
            resp.sendRedirect("login.jsp");

        }
    }
}
