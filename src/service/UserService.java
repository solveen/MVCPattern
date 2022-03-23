package service;

import DBConnection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserService {

    //inserting value into the table
    //User is object and user ma j rakhda ni hunxa
    public void insertUser(User user) {
        String SQl = "INSERT INTO studentinfo (user_name, password, full_name)" + "Values(?,?,?)";
      PreparedStatement preparedStatement = new DBConnection().getStatement(SQl);
//        DBConnection dbConnection = new DBConnection();
//        dbConnection.getStatement(SQl);
      try{
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFullName());
        preparedStatement.execute();

    }catch (SQLException e){
          e.printStackTrace();
      }

      }
      //Yele delete garxa

      public void deleteid(int id){
        String deleteId = "delete from studentinfo where id = ?";
          PreparedStatement preparedStatement = new DBConnection().getStatement(deleteId);
          try {
              preparedStatement.setInt(1, id);
              preparedStatement.execute();
          }catch (SQLException e){
              e.printStackTrace();
          }
      }

    public void userUpdate(User updateModel, int id ) throws SQLException{
        String update = "UPDATE studeninfo" +
                "SET user_name = ?, password = ? , full_name = ?" +
                "WHERE id = ?;";
        PreparedStatement preparedStatements = new DBConnection().getStatement(update);
            preparedStatements.setString(1, updateModel.getUserName());
            preparedStatements.setString(2, updateModel.getPassword());
            preparedStatements.setString(3, updateModel.getFullName());
            preparedStatements.setInt(4, id);
            preparedStatements.execute();

    }
}
