package assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.Objects;

public class FormController {
    public TextField txtName;
    public TextField txtRoom;
    public TextField txtCourse;

    public void submit(ActionEvent actionEvent) {
        String name = txtName.getText();
        String room = txtRoom.getText();
        String course = txtCourse.getText();
        try {
            for (ClassRoom c: HomeController.listClasses) {
                if (c.getName().equals(name))
                    throw new Exception("Ten lop da ton tai");
            }
            ClassRoom cr = new ClassRoom(name, room, course);
            HomeController.listClasses.add(cr);
            backToList(null);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            return;
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}
