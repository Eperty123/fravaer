package Dashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardController {
    @FXML
    private AnchorPane dRoot;
    @FXML
    private Label lblName;


    public void exit(){
        System.exit(0);
    }

    public void minimize(MouseEvent mouseEvent) {
        Stage stage = (Stage) dRoot.getScene().getWindow();
        stage.setIconified(true);
    }

    public void maximize(MouseEvent mouseEvent) {

    }

    public void logout(){

    }

    public void setName(String name){
        lblName.setText("Velkommen til " + name);
    }
}
