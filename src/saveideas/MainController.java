package saveideas;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.Statement;
import java.util.Properties;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ASUS
 */
public class MainController implements Initializable {
    
   
    @FXML
    private TextField tfid;
    @FXML
    private TextField tftitle;
    @FXML
    private TextField tfauthor;
    @FXML
    private TextArea taidea;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tfdate;
    @FXML
    private TableView<Ideas> tableview;
    @FXML
    private TableColumn<Ideas, Integer> colid;
    @FXML
    private TableColumn<Ideas,String> coltitle;
    @FXML
    private TableColumn<Ideas,String> colauthor;
    @FXML
    private TableColumn<Ideas, String> colidea;
    @FXML
    private TableColumn<Ideas,String> coltype;
    @FXML
    private TableColumn<Ideas,String> coldate;
    @FXML
    private Button btnsave;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public Connection getConnection(){
        Connection conn ;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/saveit","root","");
            return conn;
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
            return null;
        }
    }
    public ObservableList<Ideas> getIdeasList(){
        
        ObservableList<Ideas> IdeasList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String quiry = "SELECT * FROM Ideas";
        Statement st ; 
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(quiry);
            
            Ideas ideas;
            while(rs.next()){
                Ideas idea= new Ideas(rs.getInt("id"),
                                  rs.getString("title"),
                                  rs.getString("author"),
                                  rs.getString("idea"),
                                  rs.getString("type"),
                                  rs.getString("date"));
                IdeasList.add(idea);
            }
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public void showIdeas(){
        ObservableList<Ideas> ideas = getIdeasList();
        colid.setCellValueFactory(new PropertyValueFactory<Ideas,Integer>("id"));
        coltitle.setCellValueFactory(new PropertyValueFactory<Ideas,String>("title"));
        colauthor.setCellValueFactory(new PropertyValueFactory<Ideas,String>("author"));
        colidea.setCellValueFactory(new PropertyValueFactory<Ideas,String>("idea"));
        coltype.setCellValueFactory(new PropertyValueFactory<Ideas,String>("type"));
        coldate.setCellValueFactory(new PropertyValueFactory<Ideas,String>("date"));
    }
    
}
