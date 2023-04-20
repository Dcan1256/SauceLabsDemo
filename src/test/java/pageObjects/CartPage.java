package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    public WebElement numOfItemsInCart;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    public WebElement priceOfBackpack;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/div")
    public WebElement priceOfBikeLight;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[5]/div[2]/div[2]/div")
    public WebElement priceOfBlackShirt;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[6]/div[2]/div[2]/div")
    public WebElement priceOfJacket;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[7]/div[2]/div[2]/div")
    public WebElement priceOfOnesie;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[8]/div[2]/div[2]/div")
    public WebElement priceOfOrangeShirt;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    public WebElement checkOutBtn;

    @FindBy(xpath = "//*[@id=\"continue-shopping\"]")
    public WebElement continueShoppingBtn;


    //Action Methods

    public double totalCostOfCart(){
        double totalCost;
        totalCost= Double.parseDouble(priceOfBackpack.getText().substring(1))+
                Double.parseDouble(priceOfBlackShirt.getText().substring(1))+
                Double.parseDouble(priceOfBikeLight.getText().substring(1))+
                Double.parseDouble(priceOfJacket.getText().substring(1))+
                Double.parseDouble(priceOfOnesie.getText().substring(1))+
                Double.parseDouble(priceOfOrangeShirt.getText().substring(1));

        return totalCost;
    }
}
