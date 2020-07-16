package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.jar.Attributes;

public class gotocheck {

    public static void weet( String Hosp,String name, String yano)
    {
        String query = "select * from upofthis where Name ="+"'"+ name +"'"
                +" and " +"Hospital ="+ "'"+Hosp+"'"
                +" and " +"_Foreign ="+ "'"+yano+"'";
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\a_hosp\\hello.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS upofthis " +
                    " (Name TEXT, Age INTEGER, Blood_Grp TEXT, Fever TEXT, Cough TEXT,_Foreign TEXT , _Password TEXT, Hospital TEXT)");
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            Stage wi = new Stage();
            Label l1 = new Label(rs.getString("Name"));
            Label l2 = new Label(rs.getString("Age"));
            Label l3 = new Label(rs.getString("Blood_Grp"));
            Label l4 = new Label(rs.getString("Fever"));
            Label l5 = new Label(rs.getString("Cough"));
            Label l6 = new Label(rs.getString("_Foreign"));
            Label l7 = new Label(rs.getString("Hospital"));
            Label name1 = new Label("The name is :");
            Label Age = new Label("The age is :");
            Label Bldgrp = new Label("The blood group is :");
            Label Fever = new Label("Has Fever ?");
            Label Cough = new Label("Has Cough ?");
            Label Foreign = new Label("Has travel hist. to foreign nations ?:");
            Label Hosp1 = new Label("Hospital being treated :");
            GridPane grid1 = new GridPane();
            grid1.setPadding(new Insets(10,10,10,10));
            grid1.setVgap(8);
            grid1.setHgap(10);
            GridPane.setConstraints(name1,0,0);
            GridPane.setConstraints(l1,1,0);
            GridPane.setConstraints(Age,0,1);
            GridPane.setConstraints(l2,1,1);
            GridPane.setConstraints(Bldgrp,0,2);
            GridPane.setConstraints(l3,1,2);
            GridPane.setConstraints(Fever,0,3);
            GridPane.setConstraints(l4,1,3);
            GridPane.setConstraints(Cough,0,4);
            GridPane.setConstraints(l5,1,4);
            GridPane.setConstraints(Foreign,0,5);
            GridPane.setConstraints(l6,1,5);
            GridPane.setConstraints(Hosp1,0,6);
            GridPane.setConstraints(l7,1,6);
            grid1.getChildren().addAll(name1,l1,Age,l2,Bldgrp,l3,Fever,l4,Cough,l5,Foreign,l6,Hosp1,l7);
            VBox vbox = new VBox(20);
            vbox.getChildren().addAll(grid1);
            Scene scene = new Scene(vbox);
            wi.setScene(scene);
            wi.show();


        }catch(Exception e1){
            System.out.println("error "+e1);
        }


    }
}
