package com.example.demo.comtroller;

import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.impl.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/singIn")
public class SignInServlet extends HttpServlet {
    private UserRepository userRepository =new UserRepositoryImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setAge(Integer.parseInt(req.getParameter("age"))); //一切从网页上取得的内容都是String类型
        user.setMobile(req.getParameter("mobile"));
        user.setBirthday(LocalDate.parse(req.getParameter("birthday")));
        user.setSex(Sex.valueOf(req.getParameter("sex")));
        userRepository.save(user);
        resp.sendRedirect("login.jsp");
    }
}
