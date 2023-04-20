package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import testBase.baseClass;


public class TC_002_Sorting extends baseClass {



    @Test
    public void sortingAZ() throws InterruptedException {
        try {
            logger.info("***** Starting TC_002_Sorting test case *****");
            LoginPage lp=new LoginPage(driver);
            logger.info("using express login referenced by TC_001_Login");
            lp.loginExp();
            logger.info("Now we are in the main page");
            MainPage mp=new MainPage(driver);
            logger.info("Selecting value from sort dropdown");
            Select select=new Select(mp.sortingDropDown);
            // sorting A to Z
            String actualSelection="az";
            logger.info("The value we selected for sorting is A-Z");
            select.selectByValue(actualSelection);
            String expectedSelection=select.getFirstSelectedOption().getAttribute("value");
            logger.info("Validating sort result");
            Assert.assertEquals(actualSelection,expectedSelection);
            logger.info("***** Finishing TC_002_Sorting test case *****");
        }catch (Exception e){
            logger.info("***** TC_002_Sorting test case FAILED !!! *****");
            Assert.fail();
        }
    }
}
