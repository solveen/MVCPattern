package service;

import DBConnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    //inserting value into the table
    //User is object and user ma j rakhda ni hunxa
    public void insertUser(User user) {
        String SQl = "insert into studentinfo (user_name, password, full_name)" + "Values(?,?,?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(SQl);
//        DBConnection dbConnection = new DBConnection();
//        dbConnection.getStatement(SQl);
        try {
            preparedStatement.setString(1, user.getUser_name());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFull_name());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //Yele delete garxa

    public void deleteid(int id) {
        String deleteId = "delete from studentinfo where id = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(deleteId);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void userUpdate(User updateModel, int id) throws SQLException {
        String update = "UPDATE studeninfo" +
                "SET user_name = ?, password = ? , full_name = ?" +
                "WHERE id = ?;";
        PreparedStatement preparedStatements = new DBConnection().getStatement(update);
        preparedStatements.setString(1, updateModel.getUser_name());
        preparedStatements.setString(2, updateModel.getPassword());
        preparedStatements.setString(3, updateModel.getFull_name());
        preparedStatements.setInt(4, id);
        preparedStatements.execute();

    }

    public User getUser(String user_name, String password) {
        User user = null;
        String login = "select * from studentinfo where user_name=? and password=?";
        try {
            PreparedStatement preparedStatement = new DBConnection().getStatement(login);
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, password);
            ResultSet re = preparedStatement.executeQuery();
            //next method le cursor move garxa
            while (re.next()) {
                user = new User();
                user.setId(re.getInt("id"));
                user.setUser_name(re.getString("user_name"));
                user.setFull_name(re.getString("full_name"));
                user.setPassword(re.getString("password"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }

    public List<User> getUserList() throws SQLException {

        List<User> users = new ArrayList<>();
        String query = "select * from studentinfo";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        ResultSet re = preparedStatement.executeQuery();
        //next method le cursor move garxa
        while (re.next()) {
            User user = new User();
            user.setId(re.getInt("id"));
            user.setUser_name(re.getString("user_name"));
            user.setFull_name(re.getString("full_name"));
            user.setPassword(re.getString("password"));

            users.add(user);
        }
        return users;

    }
}

