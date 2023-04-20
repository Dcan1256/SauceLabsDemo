package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    public WebElement usernameBox;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"login_credentials\"]/h4")
    public WebElement acceptedUsernamesTxt;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    public WebElement headerTxt;

    //Action Methods

    /**
     * Express login method for LoginPage referenced by TC_001_Login
     * @throws InterruptedException
     */
    public void loginExp() throws InterruptedException {
        LoginPage lp=new LoginPage(driver);
        lp.usernameBox.sendKeys("standard_user");
        Thread.sleep(1000);
        lp.passwordBox.sendKeys("secret_sauce");
        Thread.sleep(1000);
        lp.loginBtn.click();
        Thread.sleep(1000);
    }
}
