package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.baseClass;

public class TC_004_FullCheckOut extends baseClass {

    @Test
    public void addingToCartAndPriceCheck() throws InterruptedException {
        try {
            logger.info("***** Starting TC_004_FullCheckOut test case *****");
            LoginPage lp=new LoginPage(driver);
            lp.loginExp();

            logger.info("We are in the main page");
            MainPage mp=new MainPage(driver);
            logger.info("Adding all items available in to our cart");
            mp.addAllItemsToCart(); // this method will add all 6 item in to the cart
            logger.info("Cheking is total number of items in the cart matching with total number of available items");
            int numExpected=6; // currently we have 6 items shown on the web page
            int numActual= Integer.parseInt(mp.numOfAllItems.getText());
            Assert.assertEquals(numActual,numExpected);

            logger.info("Clicking cart button to go to cart");
            mp.cartBtn.click();
            CartPage cp=new CartPage(driver);
            logger.info("Cheking is total number of items in the cart matching with total number of available items");
            int actualNum= Integer.parseInt(cp.numOfItemsInCart.getText());
            int expectedNum=6;
            double totalCostOfCart=cp.totalCostOfCart();
            Assert.assertEquals(actualNum,expectedNum);

            logger.info("We are in the cart page");
            cp.checkOutBtn.click();

            logger.info("We are in the checkout page");
            CheckOutPage cop=new CheckOutPage(driver);
            logger.info("filling the information requested");
            cop.fillCheckOutForm();
            cop.continueBtn.click();

            logger.info("We are in the checkout overview page");
            CheckOutOverviewPage coop=new CheckOutOverviewPage(driver);
            double itemsTotalValue=coop.getPreTaxValue();
            logger.info("Validating pre tax actual and expected values are same");
            Assert.assertEquals(itemsTotalValue,totalCostOfCart);
            double expectedTotal=coop.getAfterTaxValue();
            double actualTotal=coop.getPreTaxValue()+coop.getTaxValue();
            logger.info("Validating after tax total actual and expected values are same");
            Assert.assertEquals(actualTotal,expectedTotal);
            coop.finishBtn.click();

            logger.info("We are in Checkout Completed Page");
            CheckOutCompletePage cocp=new CheckOutCompletePage(driver);
            logger.info("Validating our checkout is completed successfully via confirmation message");
            String actualConfirmationText=cocp.confirmationTxt.getText();
            String expectedConfirmationText="Thank you for your order!";
            Assert.assertEquals(actualConfirmationText,expectedConfirmationText);
            cocp.backHomeBtn.click();

            logger.info("We are in back in main page again");
            logger.info("calling express logout referenced by TC_003_Logout");
            mp.expLogOut();
            logger.info("Validating we logged out successfully");
            String actual=lp.headerTxt.getText();
            String expected="Swag Labs";
            Assert.assertEquals(actual,expected);
            logger.info("***** Finishing TC_004_FullCheckOut test case *****");
        }catch (Exception e){
            logger.info("***** TC_004_FullCheckOut test case FAILED !!!*****");
            Assert.fail();
        }
    }
}
