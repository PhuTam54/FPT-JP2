package assignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx2.Product;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

import static assignment1.HomeController.listClasses;

public class EditController implements Initializable {
    public TextField txtName;
    public TextField txtRoom;
    public TextField txtCourse;
    public ListView<ClassRoom> listView;
    public static ClassRoom editClass;
    public void edit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String room = txtRoom.getText();
            String course = txtCourse.getText();
            if (editClass != null) {
                editClass.setName(name);
                editClass.setRoom(room);
                editClass.setCourse(course);

                listView.setItems(listClasses);
                listView.refresh();
                editClass = null;
                backToList(null);
                return;
            }
            for (ClassRoom s : listClasses) {
                if (s.getName().equals(name))
                    throw new Exception("Lop da ton tai");
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    public void editClass(MouseEvent mouseEvent) {
        editClass = listView.getSelectionModel().getSelectedItem();
        if (editClass != null) {
            txtName.setText(editClass.getName());
            txtRoom.setText(editClass.getRoom());
            txtCourse.setText(editClass.getCourse());
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }

    public void delete(ActionEvent actionEvent) {
        try {
            listView.setItems(listClasses);
            listView.refresh();
            editClass = null;
            editClass = listView.getSelectionModel().getSelectedItem();
            if (editClass != null) {
                for (ClassRoom cr: listClasses) {
                    listClasses.remove(cr);
                }
                return;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        listView.setItems(listClasses);
    }
}
