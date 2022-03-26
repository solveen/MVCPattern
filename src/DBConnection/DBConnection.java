package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    Connection connection = null;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //name of the data base
            String DB_URL = "jdbc:mysql://localhost:3306/collegedb";
            //user accounts ma name ra password j xa tei rakhne ho
            String name = "root";
            String password = "";

            this.connection = DriverManager.getConnection(DB_URL, name, password);
            System.out.println("Database Connected !! ");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

        //yele database ko query use garxa ani uta main method ma call garne ani query pass garne
    public PreparedStatement getStatement(String query) {
            PreparedStatement pstm = null;
            try{
                pstm = connection.prepareStatement(query);

            }catch (SQLException e){
                e.printStackTrace();
            }
            return pstm;
    }

}
