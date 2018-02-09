package sample;

import Admin.adminLoginId;
import DbConnection.DbConn;
import FoodData.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private TableView<staterData> statertable;

    @FXML
    private TableColumn<staterData, String> staterItem;

    @FXML
    private TableColumn<staterData, String> staterPrice;

    @FXML
    private TableView<desertData> deserttable;

    @FXML
    private TableColumn<desertData, String> dessertItem;

    @FXML
    private TableColumn<desertData, String> dessertPrice;

    @FXML
    private TableView<biryaniData> biryanitable;

    @FXML
    private TableColumn<biryaniData, String> biryaniItem;

    @FXML
    private TableColumn<biryaniData, String> biryaniPrice;

    @FXML
    private TableView<seaFoodData> seafoodtable;

    @FXML
    private TableColumn<seaFoodData, String> seafoodItem;

    @FXML
    private Label adminStatus;

    @FXML
    private Label addItemStatus;

    @FXML
    private JFXButton order1btn;

    @FXML
    private JFXButton order2btn;

    @FXML
    private TableColumn<oderData, String> orderitem;

    @FXML
    private TableColumn<oderData, String> orderPrice;

   /*@FXML
    private ContextMenu contextMenu;

    @FXML
    private MenuItem refresh;

    @FXML
    private MenuItem edit;

    @FXML
    private MenuItem delete;*/

    @FXML
    private TableView<oderData> orderTable;
    private ObservableList<oderData> orderdata;

    @FXML
    private TableColumn<seaFoodData, String> seafoodPrice;
    private DbConn c;
    private ObservableList<staterData> staterdata;
    private ObservableList<desertData> desertdata;
    private ObservableList<biryaniData> biryanidata;
    private ObservableList<seaFoodData> seafooddata;

    adminLoginId al = new adminLoginId();

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

    @FXML
    private DialogPane dialogBox;

    @FXML
    private Button dialogOkbtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.c = new DbConn();
        if (this.al.isDatabaseConnected()) {
            this.labelStatus.setText("DataBase Connected");
        } else {
            this.labelStatus.setText("DataBase Not Connected");
        }
        this.optionCombobox.setItems(FXCollections.observableArrayList(option.values()));
        // this.additemBtn.setDisable(true);
        LSEAFoodData();
        LBFoodData();
        LSFoodData();
        LDFoodData();

    }

    private void LSFoodData() {
        String sql = "SELECT * FROM A.STATER";
        try {
            Connection c = DbConn.getConnect();
            this.staterdata = FXCollections.observableArrayList();
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.staterdata.add(new staterData(rs.getString(1), rs.getString(2)));

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.staterItem.setCellValueFactory(new PropertyValueFactory<staterData, String>("stateritem"));
        this.staterPrice.setCellValueFactory(new PropertyValueFactory<staterData, String>("staterprice"));
        this.statertable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.statertable.setItems(null);
        this.statertable.setItems(this.staterdata);
    }

    @FXML
    private void loadStaterData(ActionEvent e) {
        LSFoodData();
    }

    private void LDFoodData() {
        String sql = "SELECT * FROM A.DESERT";
        try {
            Connection c = DbConn.getConnect();
            this.desertdata = FXCollections.observableArrayList();
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.desertdata.add(new desertData(rs.getString(1), rs.getString(2)));
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.dessertItem.setCellValueFactory(new PropertyValueFactory<desertData, String>("desertitem"));
        this.dessertPrice.setCellValueFactory(new PropertyValueFactory<desertData, String>("desertprice"));
        this.deserttable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.deserttable.setItems(null);
        this.deserttable.setItems(this.desertdata);
    }

    @FXML
    private void loaddesertData(ActionEvent e) {
        LDFoodData();
    }

    private void LBFoodData() {
        String sql = "SELECT * FROM A.BIRYANI";
        try {
            Connection c = DbConn.getConnect();
            this.biryanidata = FXCollections.observableArrayList();
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.biryanidata.add(new biryaniData(rs.getString(1), rs.getString(2)));

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.biryaniItem.setCellValueFactory(new PropertyValueFactory<biryaniData, String>("biryaniitem"));
        this.biryaniPrice.setCellValueFactory(new PropertyValueFactory<biryaniData, String>("biryaniprice"));
        this.biryanitable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.biryanitable.setItems(null);
        this.biryanitable.setItems(this.biryanidata);
    }

    @FXML
    private void loadBiryaniData(ActionEvent e) {
        LBFoodData();
    }

    @FXML
    private void loadSeaFoodData(ActionEvent e) {
        LSEAFoodData();
    }

    private void LSEAFoodData() {
        String sql = "SELECT * FROM A.SEAFOOD";
        try {
            Connection c = DbConn.getConnect();
            this.seafooddata = FXCollections.observableArrayList();
            ResultSet rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.seafooddata.add(new seaFoodData(rs.getString(1), rs.getString(2)));

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.seafoodItem.setCellValueFactory(new PropertyValueFactory<seaFoodData, String>("seafooditem"));
        this.seafoodPrice.setCellValueFactory(new PropertyValueFactory<seaFoodData, String>("seafoodprice"));
        this.seafoodtable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.seafoodtable.setItems(null);
        this.seafoodtable.setItems(this.seafooddata);
    }

    private void addStater() {
        String sql = "INSERT INTO stater(item,price) VALUES (?,?)";

        try {
            Connection c = DbConn.getConnect();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, this.addItem.getText());
            ps.setString(2, this.price.getText());
            ps.execute();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void addDesert() {
        String sql = "INSERT INTO desert(item,price) VALUES (?,?)";

        try {
            Connection c = DbConn.getConnect();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, this.addItem.getText());
            ps.setString(2, this.price.getText());
            ps.execute();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void addBiryani() {
        String sql = "INSERT INTO biryani(item,price) VALUES (?,?)";

        try {
            Connection c = DbConn.getConnect();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, this.addItem.getText());
            ps.setString(2, this.price.getText());
            ps.execute();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void addseafood() {
        String sql = "INSERT INTO seafood(item,price) VALUES (?,?)";

        try {
            Connection c = DbConn.getConnect();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, this.addItem.getText());
            ps.setString(2, this.price.getText());
            ps.execute();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    public void addFood(ActionEvent e) {

        switch (((option) this.optionCombobox.getValue()).toString()) {
            case "stater":
                addStater();
                break;
            case "desert":
                addDesert();
                break;
            case "biryani":
                addBiryani();
                break;
            case "seafood":
                addseafood();
                break;
        }

    }

    @FXML
    private void loginAdmin(ActionEvent e) throws SQLException {
        if (this.al.isLogin(this.userid.getText(), this.password.getText())) {

            String sql = "SELECT * FROM a.login where u=\"" + this.userid.getText() + "\" && p=\"" + this.password.getText() + "\";";
            try {
                Connection c = DbConn.getConnect();

                ResultSet rs = c.createStatement().executeQuery(sql);
                while (rs.next()) {
                    this.adminStatus.setText(rs.getString(3));

                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            //  this..setCellValueFactory(new PropertyValueFactory<adminInfo, String>("name"));

            // this.adminStatus.setText("Hello");
            //  this.dialogBox.setVisible(true);
            this.addItemStatus.setText("Now You Can Enter the Food Item's");
            //  this.additemBtn.setDisable(true);
        } else {
            // this.additemBtn.setDisable(false);
            this.adminStatus.setText("Invalid");
            this.addItemStatus.setText("sakshi");
        }
    }

    /*@FXML
    private void NotVisibleDialog(ActionEvent  e){
        this.dialogOkbtn.setVisible(false);
    }
     */
    @FXML
    private void addFoods(ActionEvent w) throws SQLException {

        //   staterData starter = statertable.getSelectionModel().getSelectedItem();
        String sql = "INSERT INTO ODERFOODS(item,price) VALUES (?,?)";
        Connection c = DbConn.getConnect();
        PreparedStatement ps = c.prepareStatement(sql);
        //  ps.setString(1, starter.getstateritem().getValue());
        // ps.setString(2, starter.getstaterprice().getValue());
        ps.setString(1, this.statertable.getSelectionModel().getSelectedItem().getstateritem().getValue());
        ps.setString(2, this.statertable.getSelectionModel().getSelectedItem().getstaterprice().getValue());
        ps.execute();
        c.close();

    }

    /* @FXML
    private void setMenue(ActionEvent W) throws Exception {
        loadBiryaniData(W);
        loadSeaFoodData(W);
        loadStaterData(W);
        loaddesertData(W);
    }
     */
    @FXML
    private void order1(ActionEvent e) throws SQLException {
        // this.orderdata.clear();
        Connection c = DbConn.getConnect();
        String sql = "SELECT * FROM A.ODERFOODS";

        // PreparedStatement ps = c.prepareStatement(sql);
        this.orderdata=FXCollections.observableArrayList();
        ResultSet rs=c.createStatement().executeQuery(sql);
        while(rs.next()){
            this.orderdata.add(new oderData((rs.getString(1)), rs.getString(2)));
        }

        this.orderitem.setCellValueFactory(new PropertyValueFactory<oderData , String>("item"));
        this.orderPrice.setCellValueFactory(new PropertyValueFactory<oderData, String>("price"));
        this.orderTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.seafoodtable.setItems(null);
        this.orderTable.setItems(this.orderdata);

    }




    /*@FXML
    private void edit(ActionEvent e) {
        Alert a=new Alert(Alert.AlertType.WARNING);
        oderData ot=orderTable.getSelectionModel().getSelectedItem();
        if(ot==null){

          a.showAndWait();
            return;
        }
        try {
            Stage stage=new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("editClass.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }
         catch (Exception ex) {
             System.out.println("nope - "+ex);
        }


    }*/


}
