package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutOverviewPage extends BasePage{

    //Elements
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")
    public WebElement preTaxTotal;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")
    public WebElement taxTotal;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")
    public WebElement afterTaxTotal;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    public WebElement finishBtn;

    @FindBy(xpath = "//*[@id=\"cancel\"]")
    public WebElement cancelBtn;

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }

    //Action Methods
    public double getPreTaxValue(){
        String preTax=preTaxTotal.getText();
        double preTaxValue= Double.parseDouble(preTaxTotal.getText().substring(preTaxTotal.getText().indexOf('$')+1));
        return preTaxValue;
    }

    public double getTaxValue(){
        String tax=taxTotal.getText();
        double taxValue= Double.parseDouble(taxTotal.getText().substring(taxTotal.getText().indexOf('$')+1));
        return taxValue;
    }

    public double getAfterTaxValue(){
        String afterTax=afterTaxTotal.getText();
        double afterTaxValue= Double.parseDouble(afterTaxTotal.getText().substring(afterTaxTotal.getText().indexOf('$')+1));
        return afterTaxValue;
    }
}
