package sample;

import javafx.stage.Stage;

import java.sql.*;

public class userlogin {
    Stage window ;
    public boolean input(String x, String y) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\a_hosp\\hello.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS upofthis " +
                    " (Name TEXT, Age INTEGER, Blood_Grp TEXT,Fever TEXT,Cough TEXT,_Foreign TEXT,_Password TEXT, Hospital TEXT)");
            statement.execute(" select * from upofthis" +
            "where Name =" +"'"+x+"'"+" and "+"_Password =" +"'"+y+"'" );
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
