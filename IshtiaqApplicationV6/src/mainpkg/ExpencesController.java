package mainpkg;
import ModelCLass.Expences;
import ModelCLass.LendLoanHandler;
import ModelCLass.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Ishti
 */
public class ExpencesController implements Initializable {

    @FXML private TextField shoppingTextField;
    @FXML private TextField foodTextFiled;
    @FXML private TextField communicationTextField;
    @FXML private TextField toLendTextField;
    @FXML private TextField universityTextField;
    @FXML private TextField loanTextField;
    @FXML private TextField emergencyTextField;
    @FXML private TextField tookLoanTextField;
    @FXML private DatePicker expenceDate;
    @FXML private TextField givenLendToTextField;
    @FXML private TextField otherTextField;
    @FXML private DatePicker loanDate;
    @FXML private DatePicker toLendDate;
    @FXML private TextField homeRentTextField;
    @FXML private TextField homeUtilityTextField;
    @FXML private TextField incomeTextFiled;
    @FXML private TextField mealTextTextField;
    @FXML private Label successfullLabel;
    @FXML private Label unsucessfullLabelOnClick;
    @FXML private Text saveTemporaryLabel;
    private Expences exe;
    private User s;
    private LendLoanHandler k;
    private double balance=0;
  
    float totalExpence,homeExpence,incomeAdd;
    @FXML
    private CheckBox lendCheckBox;
    @FXML
    private CheckBox loanCheckBox;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //===========expence.bin file reading=========/
       
        ObjectInputStream ois=null;
        try {
            ois = new ObjectInputStream(new FileInputStream("expence.bin"));
            exe = (Expences) ois.readObject();
               
        } 
        catch (Exception ex) {

            try{
                if(ois!=null)
                    ois.close();
               } 
               catch (IOException ex1) {  }           
        }
        
        if(exe!=null)
        {
            try{
            expenceDate.setValue(exe.getExpenceDate());
            shoppingTextField.setText(String.valueOf(exe.getShoppingCost()));
            foodTextFiled.setText(String.valueOf(exe.getFoodCost()));
            communicationTextField.setText(String.valueOf(exe.getComunicationCost()));
            emergencyTextField.setText(String.valueOf(exe.getEmergencyCost()));
            universityTextField.setText(String.valueOf(exe.getUniversityAllCost()));
            otherTextField.setText(String.valueOf(exe.getOtherExpences()));
            homeRentTextField.setText(String.valueOf(exe.getHomeRent()));
            homeUtilityTextField.setText(String.valueOf(exe.getHomeUtility()));
            mealTextTextField.setText(String.valueOf(exe.getHomeMealCost()));
                if(exe.getLendLoanDate1()!=null){
                    toLendTextField.setText(String.valueOf(exe.getLendLoanDate1().getLendLoan()));
                    toLendDate.setValue(exe.getLendLoanDate1().getLendLoanDate());
                    givenLendToTextField.setText(exe.getLendLoanDate1().getLendLoanpeopleName());
                }
                if(exe.getLendLoanDate2()!=null)
                {
                    loanTextField.setText(String.valueOf(exe.getLendLoanDate2().getLendLoan()));
                    tookLoanTextField.setText(exe.getLendLoanDate2().getLendLoanpeopleName());
                    loanDate.setValue(exe.getLendLoanDate2().getLendLoanDate());
                }
            }
            catch(Exception ex)
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(ex.toString());
                a.showAndWait();
            }
        }
        
        //=============user.bin file reading========/
        
        ObjectInputStream ois2=null;
        try {
            ois2 = new ObjectInputStream(new FileInputStream("user.bin"));
            s = (User) ois2.readObject();
               
        } 
        catch (Exception ex) {

            try{
                if(ois2!=null)
                    ois2.close();
            } 
            catch (IOException ex1) {  }           
        }
        
       
    }    

    @FXML
    private void saveTemporaryButton(MouseEvent event) {
        exe=new Expences();
        
        try
        {

            if(expenceDate.getValue()==null)
            {
                unsucessfullLabelOnClick.setVisible(true);
                return ;
            }
            else{
                exe.setExpenceDate(expenceDate.getValue());
                unsucessfullLabelOnClick.setVisible(false);               
            }
            if(shoppingTextField.getText().equals(""))
            {
                exe.setShoppingCost(0);
            }
            else{
                exe.setShoppingCost(Double.parseDouble(shoppingTextField.getText()));
            }
            if(foodTextFiled.getText().equals(""))
            {
                exe.setFoodCost(0);
            }
            else{
                exe.setFoodCost(Double.parseDouble(foodTextFiled.getText()));
            }
            if(communicationTextField.getText().equals(""))
            {
                exe.setComunicationCost(0);
            }
            else{
                exe.setComunicationCost(Double.parseDouble(communicationTextField.getText()));
            }
            if(emergencyTextField.getText().equals(""))
            {
                exe.setEmergencyCost(0);
            }
            else{
                exe.setEmergencyCost(Double.parseDouble(emergencyTextField.getText()));
            }
            if(universityTextField.getText().equals(""))
            {
                exe.setUniversityAllCost(0);
            }
            else{
                exe.setUniversityAllCost(Double.parseDouble(universityTextField.getText()));
            }
            if(otherTextField.getText().equals(""))
            {
                exe.setOtherExpences(0);
            }
            else{
                exe.setOtherExpences(Double.parseDouble(otherTextField.getText()));
            }
            if(homeRentTextField.getText().equals(""))
            {
                exe.setHomeRent(0);
            }
            else{
                exe.setHomeRent(Double.parseDouble(homeRentTextField.getText()));
            }
            if(homeUtilityTextField.getText().equals(""))
            {
                exe.setHomeUtility(0);
            }
            else{
                exe.setHomeUtility(Double.parseDouble(homeUtilityTextField.getText()));
            }
            if(mealTextTextField.getText().equals(""))
            {
                exe.setHomeMealCost(0);
            }
            else{
                exe.setHomeMealCost(Double.parseDouble(mealTextTextField.getText())); 
            }
            if(incomeTextFiled.getText().equals(""))
            {
                if(s.getBalance()==0)
                {
                    s.setBalance(0);
                    balance=0;
                }
                else{
                    balance=s.getBalance();
                }
               
            }
            else{
                balance=Double.parseDouble(incomeTextFiled.getText());
            }
            if(lendCheckBox.isSelected())
            {    
                try{
                if(toLendDate.getValue()!=null && 
                  !givenLendToTextField.getText().equals("") && 
                  !toLendTextField.getText().equals(""))
                {
                   LendLoanHandler temp=new LendLoanHandler(Double.parseDouble(toLendTextField.getText()),givenLendToTextField.getText(),toLendDate.getValue());
                   exe.setLendLoanDate1(temp);
                }

                else{
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setContentText("To Lend information isn't attach properly"
                            + "\nWant to correct it ?");
                    Optional<ButtonType> result = a.showAndWait();
                    if(result.get() == ButtonType.OK){
                        return;
                    }

                }}
                catch(Exception ex)
                {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Lend input is wrong");
                    a.showAndWait();
                    return;
                }
                
            }
            
            if(loanCheckBox.isSelected())
            {
                try{
                    if(loanDate.getValue()!=null && 
                      !tookLoanTextField.getText().equals("") && 
                      !loanTextField.getText().equals(""))
                    {
                       LendLoanHandler temp=new LendLoanHandler(Double.parseDouble(loanTextField.getText()),tookLoanTextField.getText(),loanDate.getValue());
                       exe.setLendLoanDate2(temp);
                    }
                    else{
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                        a.setContentText("Loan information isn't attach properly"
                                + "\nWant to correct it ?");
                        Optional<ButtonType> result = a.showAndWait();
                        if(result.get() == ButtonType.OK){
                            return;
                        }

                    }
                }
                catch(Exception ex)
                {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Loan input is wrong");
                    a.showAndWait();
                    return;
                }
            }
            
            
            //======creating bin file exception handling=====/ 
            writingFile("expence",exe);            
            saveTemporaryLabel.setVisible(true);  
            successfullLabel.setVisible(false);
        }
        catch(Exception ex)
        {
            saveTemporaryLabel.setVisible(false);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please fill the form correctly"
                    + "\nblank space only contain currency value"
                    + "\nEx: 100.57 or 100");
            a.showAndWait();
            
        }
        
    }
    public void writingFile(String fileName,Object objectName)
    {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null; 
        try {
            f = new File(fileName+".bin"); 
                
            if(f.exists()){ 
                f.delete();
            }
                
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos); 
                          
            //======write at bin file exception handling=====/      
            try{
                oos.writeObject(objectName); 
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
        
    }
    @FXML
    private void addDatabasebuttonOnClick(MouseEvent event) {
            if(saveTemporaryLabel.isVisible()){
            Expences a=new Expences();
            ObjectInputStream ois=null;
            try {
                ois = new ObjectInputStream(new FileInputStream("expence.bin"));
                a = (Expences) ois.readObject();
               
            } 
            catch (Exception ex) {

                try{
                    if(ois!=null)
                        ois.close();
                } 
                catch (IOException ex1) {  }           
            } 
            ArrayList<Expences>temp=new ArrayList<Expences>();
            if(s.getEx()==null)
            {
               temp.add(a);
               s.setEx(temp); 
               s.setBalance(balance);
            }
            else{
               temp=s.getEx();
               temp.add(exe);
               s.setEx(temp);
               s.setBalance(balance);
            }
            exe=null;
            writingFile("expence",exe);
            writingFile("user",s);
            saveTemporaryLabel.setVisible(false); 
            successfullLabel.setVisible(true);
            expenceDate.setValue(null);
            shoppingTextField.setText("");
            foodTextFiled.setText("");
            communicationTextField.setText("");
            emergencyTextField.setText("");
            universityTextField.setText("");
            otherTextField.setText("");
            homeRentTextField.setText("");
            homeUtilityTextField.setText("");
            mealTextTextField.setText("");
            
            toLendTextField.setText("");
            toLendDate.setValue(null);
            givenLendToTextField.setText("");
            loanTextField.setText("");
            tookLoanTextField.setText("");
            loanDate.setValue(null);
            }
            else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("please save first");
                a.showAndWait();
            }
            
    }

    @FXML
    private void resetButtonOnClick(MouseEvent event) {
        
            exe=null;           
            writingFile("expence",exe);
            successfullLabel.setVisible(false);
            saveTemporaryLabel.setVisible(false);
            expenceDate.setValue(null);
            shoppingTextField.setText("");
            foodTextFiled.setText("");
            communicationTextField.setText("");
            emergencyTextField.setText("");
            universityTextField.setText("");
            otherTextField.setText("");
            homeRentTextField.setText("");
            homeUtilityTextField.setText("");
            mealTextTextField.setText("");
            
            toLendTextField.setText("");
            toLendDate.setValue(null);
            givenLendToTextField.setText("");
            loanTextField.setText("");
            tookLoanTextField.setText("");
            loanDate.setValue(null);
    }
    
}
