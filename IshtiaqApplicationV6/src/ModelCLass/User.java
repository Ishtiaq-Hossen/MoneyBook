package ModelCLass;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.image.Image;
/**
 *
 * @author Ishti
 */
public class User implements Serializable{
    protected String userName,password,phone,email,Name,imageExtension;
    protected LocalDate dob;
    protected ArrayList<Expences>ex ;    
    protected Image im;
    protected double balance;
    protected double totalCost;
    
    //=======generated code==========/
    public User()
    {
        
    }
    //1st contructor (include all variables)

    public User(String userName, String password, String phone, String email, String Name, String imageExtension, LocalDate dob, ArrayList<Expences> ex, Image im, double balance, double totalCost) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.Name = Name;
        this.imageExtension = imageExtension;
        this.dob = dob;
        this.ex = ex;
        this.im = im;
        this.balance = balance;
        this.totalCost = totalCost;
    }
    
    /*2nd for profile*/
    public User(String userName, String password, String phone, String email, String Name, LocalDate dob, String imageExtension) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.Name = Name;
        this.dob = dob;
        this.imageExtension= imageExtension;
    }
    //===made for temporary
    public User(String userName, String password, String phone, String email, String Name, LocalDate dob, String imageExtension,ArrayList<Expences> ex,double balance,double totalCost) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.Name = Name;
        this.dob = dob;
        this.imageExtension= imageExtension;
        this.ex = ex;
        this.balance = balance;
        this.totalCost = totalCost;
    }
    
    /*===3rd contructor for expence.fxml==*/
    public User(ArrayList<Expences> ex, double balance, double totalCost) {
        this.ex = ex;
        this.balance = balance;
        this.totalCost = totalCost;
    }
    
    /*===4th contructor for expence.fxml==*/
    public User(ArrayList<Expences> ex, double totalCost) {
        this.ex = ex;
        this.totalCost = totalCost;
    }  
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public ArrayList<Expences> getEx() {
        return ex;
    }

    public void setEx(ArrayList<Expences> ex) {
        this.ex = ex;
    }

    public Image getIm() {
        return im;
    }

    public void setIm(Image im) {
        this.im = im;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTotalCost() {
        totalCost=0;
        for(Expences p: ex){
            totalCost+=p.getTotalCost();
        }
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImageExtension() {
        return imageExtension;
    }

    public void setImageExtension(String imageExtension) {
        this.imageExtension = imageExtension;
    }
    
    //======generated code ends==================/

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + ", phone=" + phone + ", email=" + email + ", Name=" + Name + ", dob=" + dob + ", ex=" + ex + ", im=" + im + ", balance=" + balance + ", totalCost=" + totalCost + '}';
    }
    
    
}
