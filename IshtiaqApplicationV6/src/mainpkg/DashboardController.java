/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelCLass.Expences;
import ModelCLass.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Ishti
 */
public class DashboardController implements Initializable {

    @FXML
    private Label totalCostLabel;
    private User s;
    
    @FXML
    private Label incomeLabel;
    @FXML
    private Label remainingBalanceLabel;
    
    @FXML
    private BarChart<String, Number> barChart;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            try
            {
                totalCostLabel.setText(Double.toString(s.getTotalCost()));
                incomeLabel.setText(Double.toString(s.getBalance()));
                remainingBalanceLabel.setText(String.valueOf(s.getBalance()-s.getTotalCost()));
                
                barChart.getData().clear();
                
                XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
                XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
                XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
                XYChart.Series<String,Number> series4 = new XYChart.Series<String,Number>();
                XYChart.Series<String,Number> series5 = new XYChart.Series<String,Number>();
                XYChart.Series<String,Number> series6 = new XYChart.Series<String,Number>();
                XYChart.Series<String,Number> series7 = new XYChart.Series<String,Number>();
                XYChart.Series<String,Number> series8 = new XYChart.Series<String,Number>();
                XYChart.Series<String,Number> series9 = new XYChart.Series<String,Number>();

                
                //===========bar chart code==========/
                double food=0d,shop=0d,cm=0d,em=0d,uni=0d,hmR=0d,hmM=0d,hmU=0d,ot=0d,total=0d;                
                for(Expences temp: s.getEx())
                {
                    food+=temp.getFoodCost();
                    shop+=temp.getShoppingCost();
                    cm+=temp.getComunicationCost();
                    em+=temp.getEmergencyCost();
                    uni+=temp.getUniversityAllCost();
                    hmR+=temp.getHomeRent();
                    hmM+=temp.getHomeMealCost();
                    hmU+=temp.getHomeUtility();
                    ot+=temp.getOtherExpences();
                    total+=temp.getTotalCost();
                }
                
                series1.getData().add(new XYChart.Data<String,Number>("1",food));
                series2.getData().add(new XYChart.Data<String,Number>("2",shop));
                //series3.getData().add(new XYChart.Data<String,Number>("3",cm));
                //series4.getData().add(new XYChart.Data<String,Number>("4",em));
                series5.getData().add(new XYChart.Data<String,Number>("3",uni));
                series6.getData().add(new XYChart.Data<String,Number>("4",ot));
                series7.getData().add(new XYChart.Data<String,Number>("5",total));
                series8.getData().add(new XYChart.Data<String,Number>("6",s.getBalance()));
                
      
                
                series1.setName("1.Food");
                series2.setName("2.Shopping");
                //series3.setName("3.CM");
                //series4.setName("4.EM");
                series5.setName("3.UNI");
                series6.setName("4.Other");
                series7.setName("5.Total Cost");
                series8.setName("6.Income");
                
                barChart.getData().addAll(series1,series2,series5,series6,series7,series8);
            }
            
            catch(Exception ex){}
        }
    }    

    @FXML
    private void editButtonOnClick(MouseEvent event) {
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input Alert");
        dialog.setHeaderText("Enter OTP");
        dialog.setContentText("User authenticity need to be established to open the file.\nPlease enter the OTP sent to unlock this button.");
     
        Optional<String> result = dialog.showAndWait();
        if(result.isPresent()){
            //you need to write the code to verify OTP for authenticity and open the file 
            if("123".equals(result.get())){
                Alert a=new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Thank you for entering right otp, remaining service will be available soon.");
                a.showAndWait();
            
            }
            else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("Wrong OTP");
                a.showAndWait();
            }
            
        }
        else {
            //you need to write the code to perform the actual task 
             Alert a=new Alert(Alert.AlertType.ERROR);
             a.setContentText("Operation cancelled");
             a.showAndWait();
        } 
    }
    
}
