package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class check_the_person {

    public static void display( String Hospname)
    {
        Stage wi = new Stage();
        wi.setTitle("Check the patient");
        Label r = new Label("Enter the Name :");
        Label p = new Label("Enter whether the person has gone for a foreign trip :");
        GridPane grid1 = new GridPane();
        grid1.setPadding(new Insets(10,10,10,10));
        grid1.setVgap(8);
        grid1.setHgap(10);
        GridPane.setConstraints(r,0,0);
        TextField hesaru = new TextField();
        hesaru.setPromptText("Name of patient");
        GridPane.setConstraints(hesaru,1,0);

        GridPane.setConstraints(p,0,1);
        TextField hauda = new TextField();
        hauda.setPromptText("only Yes or No");
        GridPane.setConstraints(hauda,1,1);

        Button check = new Button("check");
        GridPane.setConstraints(check,1,2);
        check.setOnAction(e -> {
            String query = "select exists(select * from upofthis where Name ="+"'"+hesaru.getText()+"'"
                    +" and " +"Hospital ="+ "'"+Hospname+"'"
                    +" and " +"_Foreign ="+ "'"+hauda.getText()+"'"+")";
            String query2 = "exists(select * from upofthis where Name ="+"'"+hesaru.getText()+"'"
                    +" and " +"Hospital ="+ "'"+Hospname+"'"
                    +" and " +"_Foreign ="+ "'"+hauda.getText()+"'"+")";

            try{
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\a_hosp\\hello.db");
                Statement statement = conn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS upofthis " +
                        " (Name TEXT, Age INTEGER, Blood_Grp TEXT, Fever TEXT, Cough TEXT,_Foreign TEXT , _Password TEXT, Hospital TEXT)");
                statement.execute(query);
                ResultSet rs = statement.getResultSet();
                {
                    if (rs.getString(query2).compareTo("1")==0)
                    {
                        gotocheck.weet(Hospname,hesaru.getText(),hauda.getText());

                    }
                    else
                    {
                        Stage window = new Stage();
                        window.initModality(Modality.APPLICATION_MODAL);
                        window.setTitle("Not Registered");
                        window.setMinWidth(200);
                        window.setMinHeight(300);

                        Label label = new Label();
                        label.setText("The patient is not in your list ");
                        Button closebutton = new Button("Close the window");
                        closebutton.setOnAction(e3 -> window.close());

                        VBox layout = new VBox(30);
                        layout.getChildren().addAll(label,closebutton);
                        layout.setAlignment(Pos.CENTER);

                        Scene scene = new Scene(layout,200,300);
                        window.setScene(scene);
                        window.showAndWait();

                    }
                }
            }catch(Exception e1){
                System.out.println("error "+e1);
            }
        });
        grid1.getChildren().addAll(r,hesaru,p,hauda,check);
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(grid1);
        Scene scene = new Scene(vbox);
        wi.setScene(scene);
        wi.show();

    }
}
