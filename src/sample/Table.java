package sample;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Table{

    static void display()
    {
        Stage window3 = new Stage();
        TableView<user> table;

        TableColumn<user, String> first = new TableColumn<>();
        first.setMinWidth(200);
        first.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<user, Integer> second = new TableColumn<>();
        second.setMinWidth(100);
        second.setCellValueFactory(new PropertyValueFactory<>("Age"));

        TableColumn<user, String> third = new TableColumn<>();
        third.setMinWidth(200);
        third.setCellValueFactory(new PropertyValueFactory<>("Blood Grp"));

        TableColumn<user, Boolean> fourth = new TableColumn<>();
        fourth.setMinWidth(100);
        fourth.setCellValueFactory(new PropertyValueFactory<>("Fever"));

        TableColumn<user, Boolean> fifth = new TableColumn<>();
        fifth.setMinWidth(100);
        fifth.setCellValueFactory(new PropertyValueFactory<>("Cough"));

        TableColumn<user, String> sixth = new TableColumn<>();
        sixth.setMinWidth(100);
        sixth.setCellValueFactory(new PropertyValueFactory<>("Foreign"));

        table = new TableView<>();
//        table.setItems();
//        table.getColumns().addAll();

    }
}
