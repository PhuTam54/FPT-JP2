package assignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EditController {
    public TextField txtName;
    public TextField txtRoom;
    public TextField txtCourse;
    public ListView<ClassRoom> listView;
    public static ClassRoom editClass;
    public static ObservableList<ClassRoom> listClass = FXCollections.observableArrayList();
    public void edit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String room = txtRoom.getText();
            String course = txtCourse.getText();
            if (editClass != null) {
                editClass.setName(name);
                editClass.setRoom(room);
                editClass.setCourse(course);

                listView.setItems(listClass);
                listView.refresh();
                editClass = null;
                backToList(null);
            }
            for (ClassRoom s : listClass) {
                if (s.getName().equals(name))
                    throw new Exception("name da ton tai");
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    public void editClass(ActionEvent actionEvent) {
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
    }
}
