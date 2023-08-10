/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelCLass.Expences;
import ModelCLass.User;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishti
 */
public class DownloadController implements Initializable {

    @FXML private TableColumn<Expences, LocalDate> expenceDate;
    @FXML private TableColumn<Expences, Double> shoppingCost;
    @FXML private TableColumn<Expences, Double> communicationCost;
    @FXML private TableColumn<Expences, Double> universityCost;
    @FXML private TableColumn<Expences, Double> emergencyCost;
    @FXML private TableColumn<Expences, Double> homeRentCost;
    @FXML private TableColumn<Expences, Double> homeUtilityCost;
    @FXML private TableColumn<Expences, Double> homeMealCost;
    @FXML private TableColumn<Expences, Double> foodCost;
    @FXML private TableColumn<Expences, Double> OtherCost;
    @FXML private TableView<Expences> tableView;
    ObservableList<Expences> allExpenceList=FXCollections.observableArrayList(); 
    private User s;
    @FXML
    private TableColumn<Expences, Double> totalCost;
    @FXML
    private Label totalcost;
    private double tempTotal;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        expenceDate.setCellValueFactory(new PropertyValueFactory<Expences,LocalDate>("expenceDate"));
        shoppingCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("shoppingCost"));
        communicationCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("comunicationCost"));
        universityCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("universityAllCost"));
        emergencyCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("emergencyCost"));
        homeRentCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("homeRent"));
        homeUtilityCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("homeUtility"));
        homeMealCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("homeMealCost"));
        foodCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("foodCost"));
        OtherCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("otherExpences"));
        totalCost.setCellValueFactory(new PropertyValueFactory<Expences,Double>("totalCost"));
//        totalCost.setStyle("-fx-background-color: red ;");
        //========================================/
        tempTotal=0d;
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
        //=====================================/
        
        ArrayList<Expences>ex=new ArrayList<Expences>();
        ex=s.getEx();
        if(ex==null)
        {
            return;
        }
        else{
            for(Expences a:ex)
            {
                tempTotal+=a.getTotalCost();
            }
            totalcost.setText(Double.toString(tempTotal));
        }
        for(int i=0;i<ex.size();i++)
        {
            allExpenceList.add(ex.get(i));
        }
        try{
            tableView.setItems(allExpenceList);
            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);            
        }
        catch(Exception e)
        {
            
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
    @FXML private void backButtonOnMouseClick(MouseEvent event) throws IOException {
        
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("UserScene_01.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML private void resetButtonOnClick(MouseEvent event) {
        
        s.setEx(null);
        writingFile("user",s);
        tableView.getItems().clear();
        totalcost.setText(null);
        
    }

    @FXML
    private void deleteButtonOnClick(MouseEvent event) {
        tempTotal=0d;
        if(tableView.getSelectionModel().isEmpty())
        {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setContentText("No item is selected!");
            a1.showAndWait(); 
            return;
        }
        
        ObservableList<Expences> selectedRows, allPeople;
        allPeople = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Expences p: selectedRows){
            allPeople.remove(p);
        }
        
        ArrayList<Expences>temp=new ArrayList<Expences>();
        for(Expences tab : allPeople) {
             temp.add(tab);
             tempTotal+=tab.getTotalCost();
        }
        s.setEx(temp);
        totalcost.setText(Double.toString(tempTotal));
        writingFile("user",s);
               
        
    }

    @FXML
    private void downloadButtonOnClick(MouseEvent event) {
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = fc.showSaveDialog(null);
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
               
                //----------------------------------------------------
                
                //adding lineSpace to the pdf
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                /*
                String imagePath2 = s.getImageExtension();
                ImageData data2 = ImageDataFactory.create(imagePath2);
                Image image2 = new Image(data2);             
                image2.setAutoScale(true);*/
                    
                //======adding paragraph to the pdf======/
                String paraText1 
                        = "Name: "+s.getName()+"\n"
                        + "Date of birth: "+s.getDob()+"\n"
                        + "Phone: "+s.getPhone()+"\n"
                        + "Email: "+s.getEmail()+"\n";
                       
                Paragraph para1 = new Paragraph(paraText1);
                
                //======pdf title setting using paragraph=======/
                
                Text titleText = new Text("Total Cost of "+s.getUserName());
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();

                //=========pdf font set-up========/
                
                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
                
                //=========Cost summery list title setUp=====/
                Text title = new Text("Cost Summery").setFont(fontBold);
                title.setFontColor(Color.RED);
                Paragraph bookInfo = new Paragraph().add(title);
                
                
                
                
                //----------------------------------------------------
                
                //adding a list
               
                double food=0d,shop=0d,cm=0d,em=0d,uni=0d,hmR=0d,hmM=0d,hmU=0d,ot=0d,total=0d;
                String lendLoad1="",lendLoad2="";
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
                    if(temp.getLendLoanDate1()!=null){
                        lendLoad1+="At "+(temp.getLendLoanDate1().getLendLoanDate().toString())+" give "+temp.getLendLoanDate1().getLendLoanpeopleName()+" "+Double.toString(temp.getLendLoanDate1().getLendLoan())+"\n";
                    }
                    if(temp.getLendLoanDate2()!=null)
                    {
                        lendLoad2+="At "+(temp.getLendLoanDate2().getLendLoanDate().toString())+" took "+Double.toString(temp.getLendLoanDate2().getLendLoan())+" from "+temp.getLendLoanDate2().getLendLoanpeopleName()+"\n";
                    
                    }
                    total+=temp.getTotalCost();
                }
                
                List cost = new List();
                cost.setFont(font2);
                cost.add("Total Food Cost: "+Double.toString(food));
                cost.add("Total Shopping Cost: "+Double.toString(shop));
                cost.add("Total Communication Cost: "+Double.toString(cm));
                cost.add("Total Emergency Cost: "+Double.toString(em));
                cost.add("Total University Cost: "+Double.toString(uni)); 
                cost.add("Total Home rent: "+Double.toString(hmR)); 
                cost.add("Total Home meal Cost: "+Double.toString(hmM)); 
                cost.add("Total Home Utility Cost: "+Double.toString(hmU)); 
                cost.add("Other Cost Total: "+Double.toString(ot)); 
                cost.add("Total Cost: [[[[[[[["+Double.toString(total)+"]]]]]]]]");                
                cost.add("Lend info: \n"+lendLoad1); 
                cost.add("Loan info: \n"+lendLoad2); 
                
             
                
                //----------------------------------------------------
                
                
                //adding table in pdf
                
                float colWidthArr2[] = {70f, 42f, 42f,42f,42f,42f,42f,42f,42f,42f,42f};
                Table pdfTable = new Table(colWidthArr2); 
                pdfTable.setFontSize(10f);
                
                //=====adding header row========
                
                Cell cell_00 = new Cell(); 
                cell_00.add("Expence\nDate");
                cell_00.setBackgroundColor(Color.YELLOW);
                pdfTable.addCell(cell_00);
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Shopping"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Communication"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("University"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Emergency"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Home Rent"));              
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Home Utility"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Home Meal"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Food"));            
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Other"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Total Cost"));
                
                
                //======adding content row============/
                
                for(Expences temp: s.getEx())
                {
                    pdfTable.addCell(new Cell().add(temp.getExpenceDate().toString()));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getShoppingCost())));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getComunicationCost())));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getUniversityAllCost())));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getEmergencyCost())));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getHomeRent())));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getHomeUtility())));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getHomeMealCost())));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getFoodCost())));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getOtherExpences())));
                    pdfTable.addCell(new Cell().add(Double.toString(temp.getTotalCost())));
                }
                
                //======adding at doc=====/
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(pdfTable);
                doc.add(lineSpace);
                doc.add(bookInfo);
                doc.add(lineSpace);
                doc.add(cost);
                
                //adding an image
                
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Do you want to add an Image?");
                Optional<ButtonType> result = a.showAndWait();
                if(result.get() == ButtonType.OK){ 
                    File imageFile = fc.showOpenDialog(null);
                    String imagePath = imageFile.getAbsolutePath();
                    ImageData data = ImageDataFactory.create(imagePath);
                    Image image = new Image(data);  
                    image.setAutoScale(true);
                    doc.add(lineSpace);
                    doc.add(image);
                    
                    a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("The image is added successfully.");
                    a.showAndWait();
                }
                
                doc.close();
                
                a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The PDF is saved successfully.");
                a.showAndWait();    
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
            //System.out.println("Something went wrong...");
            //System.out.println(e);
        }
    }
    
}
