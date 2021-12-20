package com.example.demo.comtroller;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.impl.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private UserRepository userRepository =new UserRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        userRepository.deleteById(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("users");
    }
}
