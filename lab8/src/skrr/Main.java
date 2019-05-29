package skrr;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;


public class Main extends Application{

    Stage window;
    Button addButton;
    Button deleteButton;
    Button sortButton;
    ListView<String> listView;
    Text details;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("lab8-save.xml")));
        ArrayList<Applicant> applicants = (ArrayList<Applicant>) decoder.readObject();
        //ArrayList<Applicant> applicants = new ArrayList<>();

        window = stage;
        window.setTitle("lab8");

        // encode and close
        window.setOnCloseRequest(e -> {
            XMLEncoder encoder = null;
            try {
                encoder = new XMLEncoder(new BufferedOutputStream((new FileOutputStream("lab8-save.xml"))));

            } catch (Exception a) {
                System.out.println("Couldn't save");
            }
            encoder.writeObject(applicants);
            encoder.close();
            System.out.println("Saved");
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(5);
        //grid.setGridLinesVisible(true);

        listView = new ListView<>();
        listView.setMinHeight(250);
        listView.setMaxWidth(110);
        GridPane.setConstraints(listView, 0, 0, 2, 1);
        updateList(applicants, listView);

        details = new Text(" ");
        GridPane.setConstraints(details, 4, 0, 4,  1);

        //update text
        listView.getSelectionModel().selectedItemProperty().addListener((v, oldVal, newVal) -> {
            for (Applicant a : applicants) {
                if (a.getRegistrationNumber().equals(newVal)) {
                    details.setText(a.toString());
                }
            }
        });

        addButton = new Button("Add");
        addButton.setStyle("-fx-background-color: #42adf4");
        addButton.setOnAction(e -> {
            Applicant toAdd = AlertBox.display("Add a new entry");
            applicants.add(toAdd);
            updateList(applicants, listView);
            System.out.println(applicants);
        });
        GridPane.setConstraints(addButton, 0, 1);


        deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #ff6666");
        deleteButton.setOnAction(e -> {
            ObservableList<String> toDelete;
            toDelete = listView.getSelectionModel().getSelectedItems();

            if (toDelete.size() > 0) {
                for (int i = 0; i < applicants.size(); i++) {
                    if (toDelete.get(0).equals(applicants.get(i).getRegistrationNumber()) || toDelete.get(0) == null) {
                        applicants.remove(i);
                    }
                }

                updateList(applicants, listView);
            }
        });
        GridPane.setConstraints(deleteButton, 1, 1);

        sortButton = new Button("Sort");
        sortButton.setStyle("-fx-background-color: #42adf4");
        sortButton.setOnAction(e -> {
            IdComparator idComparator = new IdComparator();
            Collections.sort(applicants, idComparator);
            updateList(applicants, listView);
        });
        GridPane.setConstraints(sortButton,40,1, 10, 1);

        grid.getChildren().addAll(listView, addButton, deleteButton, sortButton, details);
        Scene scene = new Scene(grid, 370, 350);
        window.setScene(scene);
        window.show();
    }

    private static void updateList(ArrayList<Applicant> arrayList, ListView listView){
        listView.getItems().clear();
        for(Applicant a: arrayList)
            listView.getItems().addAll(a.getRegistrationNumber());
    }
}
