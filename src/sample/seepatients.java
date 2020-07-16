package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class seepatients {
    public static void doit( String Hospname)
    {
        Stage window3 = new Stage();
        window3.setTitle("Patients and Suspects");
        TableView<user> table;

        TableColumn<user, String> first = new TableColumn<>("Name");
        first.setMinWidth(200);
        first.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<user, Integer> second = new TableColumn<>("Age");
        second.setMinWidth(100);
        second.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<user, String> third = new TableColumn<>("blood Grp");
        third.setMinWidth(200);
        third.setCellValueFactory(new PropertyValueFactory<>("Bloodgrp"));

        TableColumn<user, String> fourth = new TableColumn<>("has fever");
        fourth.setMinWidth(100);
        fourth.setCellValueFactory(new PropertyValueFactory<>("ufever"));

        TableColumn<user, String> fifth = new TableColumn<>("has cough");
        fifth.setMinWidth(100);
        fifth.setCellValueFactory(new PropertyValueFactory<>("cough"));

        TableColumn<user, String> sixth = new TableColumn<>("went to foreign");
        sixth.setMinWidth(100);
        sixth.setCellValueFactory(new PropertyValueFactory<>("uforeign"));

        TableColumn<user, String> seventh = new TableColumn<>("NearbyHosp");
        seventh.setMinWidth(100);
        seventh.setCellValueFactory(new PropertyValueFactory<>("Nearbyhosp"));

        ObservableList<user> oblist = FXCollections.observableArrayList();
        String query = "select Name, Age,Blood_Grp, Fever, Cough, _Foreign, Hospital from upofthis"+
                " where Hospital =" +"'" +Hospname+"'";

        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\a_hosp\\hello.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS upofthis " +
                    " (Name TEXT, Age INTEGER, Blood_Grp TEXT,Fever TEXT,Cough TEXT,_Foreign TEXT,_Password TEXT, Hospital TEXT)");
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while(rs.next()){
                oblist.add(new user(rs.getString("Name"),rs.getInt("Age"),rs.getString("Blood_Grp"),rs.getString("Fever"),rs.getString("Cough"),rs.getString("_Foreign"),rs.getString("Hospital")));
            }
        }catch(Exception e1){
            System.out.println("error "+e1);
        }



        table = new TableView<>();
        table.setItems(oblist);
        table.getColumns().addAll(first,second,third,fourth,fifth,sixth,seventh);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table);

        Scene scene = new Scene(vbox);
        window3.setScene(scene);
        window3.show();


    }
}

