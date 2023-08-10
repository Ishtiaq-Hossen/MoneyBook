
package mainpkg;

import ModelCLass.User;
import com.itextpdf.io.image.ImageDataFactory;
import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import com.sun.scenario.effect.ImageData;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Ishti
 */
public class ProfileController implements Initializable{

    @FXML private ImageView imageView;
    private String imageUrl;
    @FXML private TextField nameTextField;
    @FXML private DatePicker dateOfBirthDatePicker;
    @FXML private TextField userNameTextField;
    @FXML private TextField passswordTextField;
    @FXML private TextField phoneTextField;
    @FXML private TextField emailTextField;
    private Image image;
    private String newPath="Profile",destPath;
    String extention;
    /**
     * Initializes the controller class.
     */
    private User s,m;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
           ObjectInputStream ois=null;
           try {
               ois = new ObjectInputStream(new FileInputStream("user.bin"));
               s = (User) ois.readObject();
               
           } 
           catch (Exception ex) {

            try{
                if(ois!=null)
                    ois.close();
               } 
               catch (IOException ex1) {  }           
           } 
        
        
         
         if(s!=null)
         {
            nameTextField.setText(s.getName());
            userNameTextField.setText(s.getUserName());
            //passswordTextField.setText(s.getPassword());
            dateOfBirthDatePicker.setValue(s.getDob());
            emailTextField.setText(s.getEmail());
            phoneTextField.setText(s.getPhone());
            image=new Image(s.getImageExtension());
            imageView.setImage(image);
         }
         
         
    }    
    
    
    @FXML private void updateImageButtonOnClick(MouseEvent event) throws MalformedURLException, IOException {
         
         FileChooser fc = new FileChooser();        
         fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files","*.jpg"));        
         File file = fc.showOpenDialog(null);
         
         if (file != null) {
             
            try {
               imageUrl = file.toURI().toURL().toExternalForm();
               image = new Image(imageUrl);               
               imageView.setImage(image);
               extention=imageUrl.substring(imageUrl.lastIndexOf('.')+1);             
               File temp=file;
               File dir=new File(newPath);
               
               if(!dir.exists())
               {
                    dir.mkdirs();
               }
               
               File destinationFile=new File(newPath+"/Profile235."+extention);
               if(destinationFile.exists()){ 
                   destinationFile.delete();
               }
               destPath=destinationFile.toURI().toURL().toExternalForm();
               Files.copy(temp.toPath(),destinationFile.toPath());
                
            } 
            catch (MalformedURLException ex) 
            {
               throw new IllegalStateException(ex);
            }
        }      
         
        
        
    }

    @FXML
    private void saveProfileOnClick(MouseEvent event) throws IOException {
        
        Alert a = new Alert(Alert.AlertType.ERROR);
        Image temp=imageView.getImage();
        if(
           dateOfBirthDatePicker.getValue() == null || 
           nameTextField.getText().isEmpty() ||
           userNameTextField.getText().isEmpty() ||
           passswordTextField.getText().isEmpty()||
           phoneTextField.getText().isEmpty()||
           emailTextField.getText().isEmpty()||
           (temp==null)
        )
        {
                //======Alert: profile making field is empty =====  /
                if(dateOfBirthDatePicker.getValue() == null )
                {

                    a.setContentText("Date picker value is empty");
                    a.showAndWait();
                }
                else if(nameTextField.getText().isEmpty())
                {
                    a.setContentText("Name field is empty!");
                    a.showAndWait();
                }
                else if(userNameTextField.getText().isEmpty())
                {
                    a.setContentText("User Name field is empty!");
                    a.showAndWait();
                }
                else if(passswordTextField.getText().isEmpty())
                {
                    a.setContentText("Password field is empty!");
                    a.showAndWait();
                }
                else if(phoneTextField.getText().isEmpty())
                {
                    a.setContentText("Phone Number field is empty!");
                    a.showAndWait();
                }
                else if(emailTextField.getText().isEmpty())
                {
                    a.setContentText("Email field is empty!");
                    a.showAndWait();
                }
                else if(temp==null)
                {
                    a.setContentText("Image is empty");
                    a.showAndWait();
                }
        }
        else{
            
            
            File f = null;
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            //======creating bin file exception handling=====/     
            try {
                f = new File("user.bin"); 
                
                if(f.exists()){ 
                   f.delete();
                }
                
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos); 
                if(s!=null)
                {
                       m=new User(userNameTextField.getText(),passswordTextField.getText(),
                       phoneTextField.getText(),emailTextField.getText(),nameTextField.getText(),
                       dateOfBirthDatePicker.getValue(),s.getImageExtension()
                       );
                       m.setEx(s.getEx());
                       m.setBalance(s.getBalance());
                      
                }
                else{
                       m=new User(userNameTextField.getText(),passswordTextField.getText(),
                       phoneTextField.getText(),emailTextField.getText(),nameTextField.getText(),
                       dateOfBirthDatePicker.getValue(),destPath
                       );
                       
                }  
                
                //======write at bin file exception handling=====/      
                
                try{
                    oos.writeObject(m); 
                }
                catch(Exception ex)
                {
                    //======Alert: write at bin file =====  /
                    Alert a2 = new Alert(Alert.AlertType.ERROR);
                    a2.setContentText(ex.toString()+"\n"+
                    "=====done=======");                       
                    a2.showAndWait();
                                              
                }
                   
                
                
            }
            catch (IOException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            } 
            finally {
                
                try {
                    if(oos != null) oos.close();
                } 
                catch (IOException ex) {
                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
            nameTextField.setText("");
            userNameTextField.setText("");
            passswordTextField.setText("");
            dateOfBirthDatePicker.setValue(null);
            emailTextField.setText("");
            phoneTextField.setText("");
            
        }
    }
    
}
