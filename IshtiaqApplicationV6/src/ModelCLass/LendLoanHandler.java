package ModelCLass;
import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author Ishti
 */
public class LendLoanHandler implements Serializable{
    protected double lendLoan;
    protected String lendLoanpeopleName;
    protected LocalDate lendLoanDate;
    
    //=====generated code starts============/
    
    public LendLoanHandler(double lendLoan, String lendLoanpeopleName, LocalDate lendLoanDate) {
        this.lendLoan = lendLoan;
        this.lendLoanpeopleName = lendLoanpeopleName;
        this.lendLoanDate = lendLoanDate;
    }

    public double getLendLoan() {
        return lendLoan;
    }

    public void setLendLoan(double lendLoan) {
        this.lendLoan = lendLoan;
    }

    public String getLendLoanpeopleName() {
        return lendLoanpeopleName;
    }

    public void setLendLoanpeopleName(String lendLoanpeopleName) {
        this.lendLoanpeopleName = lendLoanpeopleName;
    }

    public LocalDate getLendLoanDate() {
        return lendLoanDate;
    }

    public void setLendLoanDate(LocalDate lendLoanDate) {
        this.lendLoanDate = lendLoanDate;
    }
        
    @Override
    public String toString() {
        return "LendLoanHandler{" + "lendLoan=" + lendLoan + ", lendLoanpeopleName=" + lendLoanpeopleName + ", lendLoanDate=" + lendLoanDate + '}';
    }
    //======generated code ends==================/
}
