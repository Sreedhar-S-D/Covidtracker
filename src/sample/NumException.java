package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NumException {

    static void display()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Errooor");
        window.setMinWidth(200);
        window.setMinHeight(300);

        Label label = new Label();
        label.setText("Age field is incorrect");
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
