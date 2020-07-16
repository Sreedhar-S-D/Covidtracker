package sample;

import java.sql.*;

public class requesthandler {

    public static void get( String Hospname,String first, String second, String third)  {
        int masks =0 ,chloro=0, paracetmol=0;
        int newmasks = Integer.parseInt(first);
        int newchloro = Integer.parseInt(second);
        int newpara = Integer.parseInt(third);
        String query1 = "update hospitalreq set Masks =? where Hospital = ?";
        String query2 = "update hospitalreq set Chloro ="+ Integer.parseInt(second)+
                " where Hospital ="+"'"+Hospname+"'";
        String query3 = "update hospitalreq set Paracetmol ="+ Integer.parseInt(third)+
                "where Hospital ="+"'"+Hospname+"'";
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\a_hosp\\hello.db");
            Statement statement = conn.createStatement();

            statement.executeUpdate(query2);
            statement.executeUpdate(query3);


        }catch(Exception e1){
            System.out.println("error "+e1);
        }

    }
}
