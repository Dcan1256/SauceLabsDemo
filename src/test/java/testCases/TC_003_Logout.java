package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import testBase.baseClass;

import java.util.ResourceBundle;

import static testBase.baseClass.driver;

public class TC_003_Logout extends baseClass {



    @Test
    public void logout() throws InterruptedException {
            try {
                logger.info("***** Strating TC_003_Logout test case *****");
                LoginPage lp=new LoginPage(driver);
                logger.info("Calling express login method referenced by TC_001_Login");
                lp.loginExp(); // Express login method for LoginPage referenced by TC_001_Login
                logger.info("We are in main page");
                MainPage mp=new MainPage(driver);
                logger.info("Clicking menu tab");
                mp.menu.click();
                logger.info("Clicking logout button");
                mp.logoutBtn.click();
                logger.info("Getting header text of login page");
                String actual=lp.headerTxt.getText();
                String expected="Swag Labs";
                logger.info("Comparing the actual and expected text of login page header");
                Assert.assertEquals(actual,expected);
                logger.info("***** Finishing TC_003_Logout test case *****");
            }catch (Exception e){
                logger.info("***** TC_002_Sorting test case FAILED !!! *****");
                Assert.fail();
            }

    }

 }

