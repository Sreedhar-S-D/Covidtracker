package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class buymedforhosp {

    public static void display(String Hospname)
    {
        Stage window = new Stage();
        window.setTitle("Request for medicines ");
        Label r = new Label("WARNING.. You can't procure for more than twice than the hospital capacity");
        Label p = new Label("Enter the the needed requirement of masks");
        Label q = new Label("Enter the the needed requirement of chloroquine");
        Label t = new Label("Enter the the needed requirement of paracetmol");
        GridPane grid1 = new GridPane();
        grid1.setPadding(new Insets(10,10,10,10));
        grid1.setVgap(8);
        grid1.setHgap(10);
        GridPane.setConstraints(r,0,0);
        GridPane.setConstraints(p,0,1);
        TextField mask = new TextField();
        mask.setPromptText("only an integer please");
        GridPane.setConstraints(mask,1,1);

        GridPane.setConstraints(q,0,2);
        TextField chloroquine = new TextField();
        chloroquine.setPromptText("only an integer please");
        GridPane.setConstraints(chloroquine,1,2);

        GridPane.setConstraints(t,0,3);
        TextField paracetmol = new TextField();
        paracetmol.setPromptText("only an integer please");
        GridPane.setConstraints(paracetmol,1,3);

        Button requests = new Button("Request");
        GridPane.setConstraints(requests,1,4);
        requests.setOnAction(e -> requesthandler.get(Hospname,mask.getText(),chloroquine.getText(),paracetmol.getText()));
        grid1.getChildren().addAll(r,p,mask,q,chloroquine,t,paracetmol,requests);
        VBox peak = new VBox(10);
        peak.getChildren().add(grid1);
        Scene low = new Scene(peak);
        window.setScene(low);
        window.show();
    }
}
