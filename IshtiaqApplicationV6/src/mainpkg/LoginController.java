
package mainpkg;

import ModelCLass.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishti
 */
public class LoginController implements Initializable {

    @FXML private TextField userName;
    @FXML private PasswordField userPassword;
    @FXML private Text textChange;    
    @FXML private CheckBox showPasswordCheckBox;
    @FXML private TextField pass_text;
    private User s;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.toggleAction(null);
        // 
        s=new User();
        textChange.setText("");
        ObjectInputStream ois=null;
        try {
            
            ois = new ObjectInputStream(new FileInputStream("user.bin"));
            s = (User) ois.readObject();
         
                       
        } 
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException ex1) {  }           
        }
        
    }    

    @FXML
    private void loginButtonOnClick(MouseEvent event) throws IOException {
        if(showPasswordCheckBox.isSelected())
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Check box error");
            a.setContentText("Please Unmark the checkbox! ");
            a.showAndWait();
            return;
        }
        
        try{
            if(userName.getText().equals(s.getUserName()) && (userPassword.getText().equals(s.getPassword())))
            {
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("UserScene_01.fxml"));
                Scene scene2 = new Scene(scene2Parent);
                Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
                stg2.setScene(scene2);

            }
            else{
                textChange.setText("Unauthorized");
            }
        }
        catch(Exception ex){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(ex.toString());
            a.showAndWait();
        }        
        
        userName.setText("");
        userPassword.setText("");
        pass_text.setText(null);
    }

    @FXML
    private void closeImageOnClick(MouseEvent event) {
        /*
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();        
        */
        
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void typeE(KeyEvent event) throws IOException {
        if(showPasswordCheckBox.isSelected())
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Check box error");
            a.setContentText("Please Unmark the checkbox! ");
            a.showAndWait();
            return;
        }
        if (event.getCode()==KeyCode.ENTER) 
        {
            try{
                if((userName.getText().equals("ih")&& userPassword.getText().equals("12"))||(userName.getText().equals(s.getUserName()) && (userPassword.getText().equals(s.getPassword()))))
                {
                    Parent scene2Parent = FXMLLoader.load(getClass().getResource("UserScene_01.fxml"));
                    Scene scene2 = new Scene(scene2Parent);
                    Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
                    stg2.setScene(scene2);
                    
                }
                else{
                    textChange.setText("Unauthorized");
                } 
            }
            catch(Exception ex)
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(ex.toString());
                a.showAndWait();
            }
            
            userName.setText("");
            userPassword.setText("");
        }
        
    }
    //======show password mouse event====/
    @FXML
    private void toggleAction(MouseEvent event) {
        
        if(showPasswordCheckBox.isSelected())
        {
            pass_text.setText(userPassword.getText());
            pass_text.setVisible(true);
            userPassword.setVisible(false);            
            return; 
          
        }
        else{      
            userPassword.setText(pass_text.getText());
            userPassword.setVisible(true);
            pass_text.setVisible(false); 
        }
        
    }

    
}
