/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Ishti
 */
public class AboutController implements Initializable {

    private TextField aboutTextField;
    @FXML
    private Text text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        text.setText(
                "==============================\n"+
                "This software is build by IT.\n"
                +"This software will help to monitor user regular cost.\n"
                +"User can download a pdf .It will help user to have a hard copy \n"
                +"of total cost/expence data\n\n"
                +"=============================\n"
                +"[ User Guide: ]\n"
                
                +"1.User must save the expence 1st if save text is shown below the save button\n"
                +"user need to add it to the database\n"
                +"2.Before adding expences to the database user need to check if there is any info\n"
                +"regarding lend /loan.\nIn that case user must check the lend loan checkBox \n"
                +"for seeing the lend loan info in the downloaded pdf\n\n"
                
                +"Thank you\n-IH\n"  
                        
                +"======Premium service=========\n"      
                +"1.User can edit dashboard by purchasing premium serivice.\n"
                +"Dashborad contain(last 10 day cost,saving,task setup,lend loan and many more)\n"
                +"2.User can edit note text field.\n"
                +"3.User can see lend loan info on software\n "
                +"though user can see lend loan info by downloading pdf\n"
                
        );
    }    

    @FXML
    private void linkOnClick(MouseEvent event) throws URISyntaxException,IOException {
        Desktop.getDesktop().browse(new URI("https://ishtiaq-hossen.github.io/Port/"));
    }
    
}
