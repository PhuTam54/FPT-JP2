package assignment1;

import javafx.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable{
    public static ObservableList<ClassRoom> listClasses = FXCollections.observableArrayList();

    public ListView<ClassRoom> listView;
    public static ClassRoom editClass;

    public void goToForm(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        Main.mainStage.setScene(new Scene(root,600, 400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(listClasses);
    }

    public void goToEditStudent(MouseEvent mouseEvent) throws IOException {
        editClass = listView.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("editForm.fxml"));
        javafx.Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
