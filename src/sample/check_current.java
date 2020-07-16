
package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.net.*;
import java.io.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

public class check_current {
    int i;
    private static HttpURLConnection connection;

    public static void showcurrentsceanrio() {

        ObservableList<indiavschinesevirus> q = FXCollections.observableArrayList();
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("https://api.covid19api.com/live/country/india/status/confirmed");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);

            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader((connection.getErrorStream())));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }

            //System.out.println(responseContent.toString());
            //parse(responseContent.toString());
            String responseBody = responseContent.toString();
            JSONArray albums = new JSONArray(responseBody);
            System.out.println(albums);
            for( int i = 0 ; i <albums.length();i++)
            {
                JSONObject album= albums.getJSONObject(i);
                String country= album.getString("Country");
                String  date= album.getString("Date");
                int cases= album.getInt("Confirmed");
                String statuses = album.getString("Status");
                q.add(new indiavschinesevirus(country,date,cases,statuses));

            }
            Stage window3 = new Stage();
            TableView<indiavschinesevirus> table;

            TableColumn<indiavschinesevirus, String> first = new TableColumn<>("Country");
            first.setMinWidth(200);
            first.setCellValueFactory(new PropertyValueFactory<>("country"));

            TableColumn<indiavschinesevirus, String > second = new TableColumn<>("Date");
            second.setMinWidth(300);
            second.setCellValueFactory(new PropertyValueFactory<>("date"));

            TableColumn<indiavschinesevirus, Integer > third = new TableColumn<>("Cases");
            third.setMinWidth(200);
            third.setCellValueFactory(new PropertyValueFactory<>("cases"));

            TableColumn<indiavschinesevirus, String > fourth = new TableColumn<>("Status");
            fourth.setMinWidth(100);
            fourth.setCellValueFactory(new PropertyValueFactory<>("Status"));


            table = new TableView<>();
            table.setItems(q);
            table.getColumns().addAll(first,second,third,fourth);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(table);

            Scene scene = new Scene(vbox);
            window3.setScene(scene);
            window3.show();



        } catch (MalformedInputException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

    }

}

