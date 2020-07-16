package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {

    Stage window;
    user[] u = new user[100];
    int k = 0;
    Scene s1,scene2,scene3,scene4,scene5,makingofuser,doclogin;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setMinHeight(300);
        window.setMinWidth(300);
        window.setTitle("Corona Outbreak");
        Label l1 = new Label("Enter who you are :");
        l1.setPadding(new Insets(10,10,10,10));
        l1.setTextFill(Color.web("#ffffff"));
        l1.setFont(new Font("Arial", 30));
        Button b1 = new Button("User");
        Button b2 = new Button("Doctor");
        Button b3 = new Button("Medical officer");
        Button b4 = new Button("Check the stats");
        b1.setPadding(new Insets(10,10,10,10));
        b1.setLayoutX(200);
        b2.setPadding(new Insets(10,10,10,10));
        b2.setLayoutX(200);
        b3.setPadding(new Insets(10,10,10,10));
        b3.setLayoutX(200);
        b4.setPadding(new Insets(10,10,10,10));
        b4.setLayoutX(200);
        b4.setOnAction(e -> check_current.showcurrentsceanrio());
        b1.setOnAction(e -> window.setScene(makingofuser));

        VBox newest = new VBox(20);
        Label label10 = new Label("If you have not registered please click this button :");
        Button register = new Button("Register here ");
        register.setOnAction(e -> window.setScene(scene2));
        Label m = new Label("If you have registered please check whether you need to to go to quarantine :");
        Button login = new Button("Login (Name and password required )");
        Button backto = new Button("Back");
        backto.setOnAction(e -> window.setScene(s1));
        newest.getChildren().addAll(label10,register,m,login,backto);
        login.setOnAction(e ->
        {
            Stage wi = new Stage();
            Label Name = new Label("Enter Name :");
            Label Password = new Label("Enter Password :");
            GridPane grid1 = new GridPane();
            grid1.setPadding(new Insets(10,10,10,10));
            grid1.setVgap(8);
            grid1.setHgap(10);
            GridPane.setConstraints(Name,0,0);
            TextField uname = new TextField();
            uname.setPromptText("Name required");
            GridPane.setConstraints(uname,1,0);

            GridPane.setConstraints(Password,0,1);
            TextField passw = new TextField();
            passw.setPromptText("Password required");
            GridPane.setConstraints(passw,1,1);

            Button logins = new Button("Login");
            GridPane.setConstraints(logins,1,2);
            grid1.getChildren().addAll(Name,uname,Password,passw,logins);
            logins.setOnAction(e2 ->
            {            Stage window3 = new Stage();
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

                TableColumn<user, String> seventh = new TableColumn<>("Password");
                seventh.setMinWidth(100);
                seventh.setCellValueFactory(new PropertyValueFactory<>("password"));

                TableColumn<user, String> eight = new TableColumn<>("NearbyHosp");
                eight.setMinWidth(100);
                eight.setCellValueFactory(new PropertyValueFactory<>("Nearbyhosp"));

                ObservableList<user> oblist = FXCollections.observableArrayList();
                String query = "select * from upofthis where Name ="+"'"+uname.getText()+"'"
                        +" and " +"_Password ="+
                    "'"+passw.getText()+"'";

                try{
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\a_hosp\\hello.db");
                    Statement statement = conn.createStatement();
                    statement.execute("CREATE TABLE IF NOT EXISTS upofthis " +
                            " (Name TEXT, Age INTEGER, Blood_Grp TEXT,Fever TEXT,Cough TEXT,_Foreign TEXT,_Password TEXT, Hospital TEXT)");
                    statement.execute(query);
                    ResultSet rs = statement.getResultSet();
                    while(rs.next()){
                        oblist.add(new user(rs.getString("Name"),rs.getInt("Age"),rs.getString("Blood_Grp"),rs.getString("Fever"),rs.getString("Cough"),rs.getString("_Foreign"),rs.getString("_Password"),rs.getString("Hospital")));
                    }
                }catch(Exception e1){
                    System.out.println("error "+e1);
                }



                table = new TableView<>();
                table.setItems(oblist);
                table.getColumns().addAll(first,second,third,fourth,fifth,sixth,seventh,eight);

                VBox vbox = new VBox();
                vbox.getChildren().addAll(table);

                Scene scene = new Scene(vbox);
                window3.setScene(scene);
                window3.show();
            });
            VBox peak = new VBox(10);
            peak.getChildren().add(grid1);
            Scene low = new Scene(peak);
            wi.setScene(low);
            wi.show();

        });
        makingofuser = new Scene(newest,300,200);


        VBox layout = new VBox(20);
        layout.getChildren().addAll(l1,b1,b2,b3,b4);

        // create a input stream
        FileInputStream input = new FileInputStream("f:\\corona.jpeg");

        // create a image
        Image image = new Image(input);

        // create a background image
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        // create Background
        Background background = new Background(backgroundimage);
        layout.setBackground(background);

        s1 = new Scene(layout,300,300);

        // scene 2 -> where the user fills form.
        Label label2 = new Label("Enter the Name :");
        Label label3 = new Label("Enter the Age :");
        Label label4 = new Label("Enter the Blood group :");
        Label label5 = new Label("Are you suffering from fever :");
        Label label6 = new Label("Are you suffering from dry cough :");
        Label label7 = new Label("Have you come from a foreign country infected by virus :");
        Label label8 = new Label("Enter password ");
        Label label9 = new Label("Enter nearby Hospital( Select only from Pimpri, Chinchwad, Aundh, Nigadi ");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);


        GridPane.setConstraints(label2,0,0);

        TextField nameinput = new TextField("Sreedhar");
        GridPane.setConstraints(nameinput,1,0);

        GridPane.setConstraints(label3,0,1);

        //password input
        TextField passinput = new TextField();
        passinput.setPromptText("Age");
        GridPane.setConstraints(passinput,1,1);


        GridPane.setConstraints(label4,0,2);
        TextField bloodgroup = new TextField();
        bloodgroup.setPromptText("Like O+ve");
        GridPane.setConstraints(bloodgroup,1,2);

        GridPane.setConstraints(label5,0,3);
        TextField fever = new TextField();
        fever.setPromptText("Yes or No");
        GridPane.setConstraints(fever,1,3);

        GridPane.setConstraints(label6,0,4);
        TextField cough = new TextField();
        cough.setPromptText("Yes or No");
        GridPane.setConstraints(cough,1,4);


        GridPane.setConstraints(label7,0,5);
        TextField foreign = new TextField();
        foreign.setPromptText("Like USA,China or Italy");
        GridPane.setConstraints(foreign,1,5);

        GridPane.setConstraints(label8,0,6);
        TextField password = new TextField();
        password.setPromptText("Make the password complex");
        GridPane.setConstraints(password,1,6);

        GridPane.setConstraints(label9,0,7);
        TextField hospital = new TextField();
        hospital.setPromptText("Abide to the hospital list");
        GridPane.setConstraints(hospital,1,7);

        Button loginButton = new Button("Register");
        GridPane.setConstraints(loginButton,1,8);

        loginButton.setOnAction(e -> {
            boolean p = registertheuser( nameinput, passinput, bloodgroup , fever, cough, foreign, password, hospital );
            if(p)
            {
                window.setScene(makingofuser);
            }
        });

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton,1,10);

        backButton.setOnAction(e ->{
            window.setScene(makingofuser);
        });

        grid.getChildren().addAll(label2,nameinput,label3,passinput,label4,bloodgroup,label5,fever,label6,cough,label7,foreign,label8,password,label9,hospital,loginButton,backButton);

        scene2 = new Scene(grid, 500,400);


        b2.setOnAction(e -> doctorlogin.add());


        // for the patient list

        Label l2 = new Label("This is the list of the entries :");
        Button new1 = new Button("See Patient List");
        new1.setOnAction(e ->
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
            String query = "select Name, Age,Blood_Grp, Fever, Cough, _Foreign, Hospital from upofthis";

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


        });

        Button new2 = new Button("Back");
        new2.setOnAction(e -> window.setScene(s1));

        VBox layout2 = new VBox(40);
        layout2.getChildren().addAll(l2,new1,new2);

        scene3 = new Scene(layout2,400,400);

        window.setScene(s1);
        window.show();

    }


    public boolean  registertheuser( TextField input1, TextField input2,TextField input3,TextField input4,TextField input5,TextField input6,TextField input7,TextField input8) {
        try{
            int p = Integer.parseInt(input2.getText());
            boolean x = confirmBox.display("Confirmation","Are you sure you want to register");
            if(x) {

                u[k++] = new user( input1.getText(), p,input3.getText(),input4.getText(),input5.getText(),input6.getText(),input7.getText(), input8.getText());
                AlertBox.display();
                try {
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\a_hosp\\hello.db");

                    Statement statement = conn.createStatement();
                    statement.execute("CREATE TABLE IF NOT EXISTS upofthis " +
                            " (Name TEXT, Age INTEGER, Blood_Grp TEXT, Fever TEXT, Cough TEXT,_Foreign TEXT , _Password TEXT, Hospital TEXT)");
                    statement.execute("INSERT INTO upofthis (Name, Age, Blood_Grp, Fever, Cough, _Foreign, _Password, Hospital ) " +
                            "VALUES "+"("+"'"+u[k-1].getName()+"'"+","+u[k-1].getAge()+","+"'"+u[k-1].getBloodgrp()+"'"+","+"'"+u[k-1].getUfever()+"'"+
                            ","+"'"+u[k-1].getCough()+"'"+","+"'"+u[k-1].getUforeign()+"'"+","+"'"+u[k-1].getPassword()+"'"+","+"'"+u[k-1].getNearbyhosp()+"'"+")");
                    statement.close();
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
                return true;
            }
            else
                return false;
        }catch (NumberFormatException e)
        {
            NumException.display();
            return false;
        }
    }


    public static void main(String[] args) {
        launch(args);

    }
}

