package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//*[@id=\"first-name\"]")
    public WebElement fnameBox;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    public WebElement lnameBox;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    public WebElement zipcodeBox;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement cancelBtn;
    //Action Methods
    public void fillCheckOutForm(){
        fnameBox.sendKeys("testfname");
        lnameBox.sendKeys("testlname");
        zipcodeBox.sendKeys("66666");
    }
}
