package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class doccheck {

    public static void execute( String Hospname)
    {
        Stage window = new Stage();
        Button a = new Button("See all patients");
        Button b = new Button("See potentially dangerous patients");
        Button c = new Button("Check the patient by name and foreign trips");
        Button d = new Button("request medicines for hospital from med officer");
        a.setOnAction(e -> seepatients.doit(Hospname));
        b.setOnAction(e -> seedp.doit(Hospname));
        c.setOnAction(e -> check_the_person.display(Hospname));
        d.setOnAction(e -> buymedforhosp.display(Hospname));
        VBox nem = new VBox(20);
        nem.getChildren().addAll(a,b,c,d);
        Scene w = new Scene(nem,300,200);
        window.setScene(w);
        window.show();

    }
}
