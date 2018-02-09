package Admin;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import sample.option;

/**
 *
 * @author Ashutosh
 */
public class adminController  implements Initializable{

    adminLoginId al=new adminLoginId();

    @FXML
    private JFXTextField userid;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField addItem;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXButton additemBtn;

    @FXML
    private JFXButton loginbtn;

    @FXML
    private JFXComboBox<option> optionCombobox;

    @FXML
    private Label labelStatus;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(this.al.isDatabaseConnected()){
            this.labelStatus.setText("DataBase Connected");
        }else{
            this.labelStatus.setText("DataBase Not Connected");
        }



    }

}
