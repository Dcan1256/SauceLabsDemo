package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutCompletePage extends BasePage{
    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    public WebElement confirmationTxt;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    public WebElement backHomeBtn;


    //Action Methods
}
