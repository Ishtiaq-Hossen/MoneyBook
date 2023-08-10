package ModelCLass;
import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author Ishti
 */
public class Expences implements Serializable{
    protected double shoppingCost,comunicationCost,
           emergencyCost,universityAllCost,
           otherExpences,homeRent,
           homeUtility,homeMealCost,
           foodCost;
    protected LocalDate expenceDate;
    protected LendLoanHandler lendLoanDate1;//for lend
    protected LendLoanHandler lendLoanDate2;// for loan
    protected double totalCost;
    
    
    //======generated code starts==================/
    
    public Expences()
    {
        
    }
    public Expences(double shoppingCost, double comunicationCost, double emergencyCost, double universityAllCost, double otherExpences, double homeRent, double homeUtility, double homeMealCost, double foodCost, LocalDate expenceDate, LendLoanHandler lendLoanDate1, LendLoanHandler lendLoanDate2) {
        this.shoppingCost = shoppingCost;
        this.comunicationCost = comunicationCost;
        this.emergencyCost = emergencyCost;
        this.universityAllCost = universityAllCost;
        this.otherExpences = otherExpences;
        this.homeRent = homeRent;
        this.homeUtility = homeUtility;
        this.homeMealCost = homeMealCost;
        this.foodCost = foodCost;
        this.expenceDate = expenceDate;
        this.lendLoanDate1 = lendLoanDate1;
        this.lendLoanDate2 = lendLoanDate2;
    }
    
    
    public double getShoppingCost() {
        return shoppingCost;
    }

    public void setShoppingCost(double shoppingCost) {
        this.shoppingCost = shoppingCost;
    }

    public double getComunicationCost() {
        return comunicationCost;
    }

    public void setComunicationCost(double comunicationCost) {
        this.comunicationCost = comunicationCost;
    }

    public double getEmergencyCost() {
        return emergencyCost;
    }

    public void setEmergencyCost(double emergencyCost) {
        this.emergencyCost = emergencyCost;
    }

    public double getUniversityAllCost() {
        return universityAllCost;
    }

    public void setUniversityAllCost(double universityAllCost) {
        this.universityAllCost = universityAllCost;
    }

    public double getOtherExpences() {
        return otherExpences;
    }

    public void setOtherExpences(double otherExpences) {
        this.otherExpences = otherExpences;
    }

    public double getHomeRent() {
        return homeRent;
    }

    public void setHomeRent(double homeRent) {
        this.homeRent = homeRent;
    }

    public double getHomeUtility() {
        return homeUtility;
    }

    public void setHomeUtility(double homeUtility) {
        this.homeUtility = homeUtility;
    }

    public double getHomeMealCost() {
        return homeMealCost;
    }

    public void setHomeMealCost(double homeMealCost) {
        this.homeMealCost = homeMealCost;
    }

    public double getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public LocalDate getExpenceDate() {
        return expenceDate;
    }

    public void setExpenceDate(LocalDate expenceDate) {
        this.expenceDate = expenceDate;
    }

    public LendLoanHandler getLendLoanDate1() {
        return lendLoanDate1;
    }

    public void setLendLoanDate1(LendLoanHandler lendLoanDate1) {
        this.lendLoanDate1 = lendLoanDate1;
    }

    public LendLoanHandler getLendLoanDate2() {
        return lendLoanDate2;
    }

    public void setLendLoanDate2(LendLoanHandler lendLoanDate2) {
        this.lendLoanDate2 = lendLoanDate2;
    }
    //======generated code ends==================/

    public double getTotalCost() {
        totalCost=shoppingCost+comunicationCost+
           emergencyCost+universityAllCost+
           otherExpences+homeRent+
           homeUtility+homeMealCost+
           foodCost;
        return totalCost;
    }
    
    @Override
    public String toString() {
        return "Expences{" + "shoppingCost=" + shoppingCost + ", comunicationCost=" + comunicationCost + ", emergencyCost=" + emergencyCost + ", universityAllCost=" + universityAllCost + ", otherExpences=" + otherExpences + ", homeRent=" + homeRent + ", homeUtility=" + homeUtility + ", homeMealCost=" + homeMealCost + ", foodCost=" + foodCost + ", expenceDate=" + expenceDate + ", lendLoanDate1=" + lendLoanDate1 + ", lendLoanDate2=" + lendLoanDate2 + '}';
    }
    
}
