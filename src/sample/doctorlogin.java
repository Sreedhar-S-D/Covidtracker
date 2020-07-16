package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class doctorlogin {

    public static void add()
    {
        Stage wi = new Stage();
        Label Name = new Label("Enter Name :");
        Label Password = new Label("Enter hospital :");
        Label RefNo = new Label("Enter reference number ");
        GridPane grid1 = new GridPane();
        grid1.setPadding(new Insets(10,10,10,10));
        grid1.setVgap(8);
        grid1.setHgap(10);
        GridPane.setConstraints(Name,0,0);
        TextField uname = new TextField();
        uname.setPromptText("Name required");
        GridPane.setConstraints(uname,1,0);

        GridPane.setConstraints(Password,0,1);
        TextField hosp = new TextField();
        hosp.setPromptText("Hospital required");
        GridPane.setConstraints(hosp,1,1);

        GridPane.setConstraints(RefNo,0,2);
        TextField refno = new TextField();
        refno.setPromptText("Ref No required");
        GridPane.setConstraints(refno,1,2);

        Button logins = new Button("Login");
        GridPane.setConstraints(logins,1,3);
        Button back = new Button("Back");
        GridPane.setConstraints(logins,1,4);
        grid1.getChildren().addAll(Name,uname,Password,hosp,RefNo,refno,logins);
        logins.setOnAction(e2 ->
        {
            String query = "select exists(select * from doctors where Name ="+"'"+uname.getText()+"'"
                    +" and " +"Hospital ="+ "'"+hosp.getText()+"'"
                    +" and " +"Ref_No ="+ "'"+refno.getText()+"'" +")";
            String query2 = "exists(select * from doctors where Name ="+"'"+uname.getText()+"'"
                    +" and " +"Hospital ="+ "'"+hosp.getText()+"'"
                    +" and " +"Ref_No ="+ "'"+refno.getText()+"'" +")";

            try{
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\a_hosp\\hello.db");
                Statement statement = conn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS doctors " +
                        " (Name TEXT, Hospital TEXT, Ref_No INTEGER)");
                statement.execute(query);
                ResultSet rs = statement.getResultSet();
                {
                    if (rs.getString(query2).compareTo("1")==0)
                    {
                        doccheck.execute(hosp.getText());

                    }
                    else
                    {
                        Stage window = new Stage();
                        window.initModality(Modality.APPLICATION_MODAL);
                        window.setTitle("Not Registered");
                        window.setMinWidth(200);
                        window.setMinHeight(300);

                        Label label = new Label();
                        label.setText("You are not a registered doctor ");
                        Button closebutton = new Button("Close the window");
                        closebutton.setOnAction(e -> window.close());

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
        VBox peak = new VBox(10);
        peak.getChildren().add(grid1);
        Scene low = new Scene(peak);
        wi.setScene(low);
        wi.show();

    }
}
