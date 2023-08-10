package mainpkg;

import ModelCLass.User;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishti
 */
public class UserScene_01Controller implements Initializable {

    @FXML
    private Label dashBoardLabel;
    @FXML
    private BorderPane borderpane;
    @FXML
    private AnchorPane ap1;
    @FXML
    private Label profileLabel;
    @FXML
    private Label expencesLID;
    @FXML
    private Label downloadLid;
    private User s;
    @FXML
    private Label userNameShow;
    @FXML
    private ImageView imageView;
    @FXML
    private HBox profileHbox;
    @FXML
    private Label downloadLid1;
    @FXML
    private HBox dashBoardHbox;
    @FXML
    private HBox expenceHbox;
    @FXML
    private HBox aboutHbox;
    @FXML
    private TextField noteTextField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadUI("Dashboard");
        noteTextField.setText("About button contain User guide [necessary read for new user]");
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
              userNameShow.setText(s.getName()) ;
              Image image=new Image(s.getImageExtension());
              imageView.setImage(image);
             
           }
           
           
           
    }    
    private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            ap1.getChildren().add(root);
        }
        catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void dashboardMouseOnClick(MouseEvent event) {
        
        dashBoardLabel.setStyle("-fx-font-weight: bold;");
        profileLabel.setStyle("-fx-font-weight: normal;");
        expencesLID.setStyle("-fx-font-weight: normal;");
        downloadLid1.setStyle("-fx-font-weight: normal;");
        
        aboutHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        expenceHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        profileHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        dashBoardHbox.setStyle("-fx-background-color: dbdce7;"+"-fx-background-radius: 20px");
        
        
        loadUI("Dashboard");
    }

    @FXML
    private void profileLabelOnClick(MouseEvent event) {
        dashBoardLabel.setStyle("-fx-font-weight: normal;");
        profileLabel.setStyle("-fx-font-weight: bold;");
        expencesLID.setStyle("-fx-font-weight: normal;");
        downloadLid1.setStyle("-fx-font-weight: normal;");
        
        aboutHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        expenceHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        dashBoardHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        profileHbox.setStyle("-fx-background-color: dbdce7;"+"-fx-background-radius: 20px");
        
        loadUI("Profile");
    }

    @FXML
    private void expencesLableOnClick(MouseEvent event) {
        
        dashBoardLabel.setStyle("-fx-font-weight: normal;");
        profileLabel.setStyle("-fx-font-weight: normal;");
        expencesLID.setStyle("-fx-font-weight: bold;");
        downloadLid1.setStyle("-fx-font-weight: normal;");
        
        aboutHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        profileHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        dashBoardHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        expenceHbox.setStyle("-fx-background-color: dbdce7;"+"-fx-background-radius: 20px");
        loadUI("Expences");
    }

    @FXML
    private void downloadLabelOnClick(MouseEvent event) throws IOException {
        
        
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("Download.fxml"));
        Scene scene2 = new Scene(scene2Parent);              
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();        
        stg2.setScene(scene2);
        stg2.show();
    }

    @FXML
    private void LogoutLablOnClick(MouseEvent event) throws IOException {
        
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void exitLabelOnClick(MouseEvent event) {
        
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void aboutLabelOnClick(MouseEvent event) {
        dashBoardLabel.setStyle("-fx-font-weight: normal;");
        profileLabel.setStyle("-fx-font-weight: normal;");
        expencesLID.setStyle("-fx-font-weight: normal;");
        downloadLid1.setStyle("-fx-font-weight: bold;");
        
        expenceHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        profileHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        dashBoardHbox.setStyle("-fx-background-color: f6f6fa;"+"-fx-background-radius: 0px");
        aboutHbox.setStyle("-fx-background-color: dbdce7;"+"-fx-background-radius: 20px");
        loadUI("about");
    }

    @FXML
    private void noteTextFieldKeyReleased(KeyEvent event) {
       
    }
    
}
