package com.example.demo.repository.impl;

import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public int save(User user) {
            String sql = "insert into users(username, password, age, birthday, mobile, sex) values (?, ?, ?, ?, ?, ?)";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/text", "tom", "123456")) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString( 1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setInt(3, user.getAge());
                preparedStatement.setDate(4, java.sql.Date.valueOf(user.getBirthday()));
                preparedStatement.setString(5, user.getMobile());
                preparedStatement.setString(6, user.getSex().toString());
                return preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return -1;
    }

    @Override
    public User findByUsernameAngPassword(String username, String password) {
        String sql = "select*from users where username=?and password=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "tom", "123456")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet=preparedStatement.executeQuery(); // 运行
            if (resultSet != null&& resultSet.next()){
                return  new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getString(6),
                        Sex.valueOf(resultSet.getString(7))

                );

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return null;
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from users";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "tom", "123456")) {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);
           List<User> users = new ArrayList<>();

            if (resultSet != null){
                while (resultSet.next())

                users.add(new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getString(6),
                        Sex.valueOf(resultSet.getString(7))

                ));

            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return null;
    }

    @Override
    public int deleteById(int id) {
        String sql = " delete from users where user_id=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "tom", "123456")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;
    }

    @Override
    public User findByUserId(int userId) {
        String sql = "select*from users where user_id = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "tom", "123456")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,userId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet != null&& resultSet.next()){
                return  new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getString(6),
                        Sex.valueOf(resultSet.getString(7)));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();



    }
        return null;
    }


    @Override
    public int update(User user) {
        String sql = "update users set username=?, password=?, age=?, birthday=?, mobile=?, sex=? where user_id = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "peter", "820517")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setDate(4, Date.valueOf(user.getBirthday()));
            preparedStatement.setString(5, user.getMobile());
            preparedStatement.setString(6, user.getSex().toString());
            preparedStatement.setInt(7, user.getUserId());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}





