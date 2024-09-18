package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

//1 Class 1 Test
public class TC001_AccountRegisterationTest extends BaseClass {
    @Test(groups = {"Regression","Master"})
    public void verify_account_registration() {
        logger.info("***** Starting TC001_AccountRegisterationTest *****");
        try {
            HomePage hmPage = new HomePage(driver);
            hmPage.clickMyAccount();

            logger.info("****** Clicked on MyAccount Link *******");
            hmPage.clickRegister();

            logger.info("****** Clicked on Register Link *******");
            AccountRegisterationPage accRegPage = new AccountRegisterationPage(driver);

            logger.info("****** Providing Customer Details *******");
            accRegPage.setTxtFirstName(randomString().toUpperCase());
            accRegPage.setTxtLastName(randomString().toUpperCase());
            accRegPage.setTxtEmail(randomString() + "@gmail.com");
            accRegPage.setTxtTelephone(randomHumber());

            String password = randomAlphanumeric();
            accRegPage.setTxtPassword(password);
            accRegPage.setTxtConfirmPassword(password);

            accRegPage.setPrivacyPolicy();
            accRegPage.clickContinue();

            logger.info("****** Validating Expected Message *******");
            String confirmMsg = accRegPage.getConfirmationMsg();
            if(confirmMsg.equals("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
            }else{
                logger.error("Test Failed");
                logger.debug("Debug Logs");
                Assert.assertTrue(false);
            }
        }
        catch(Exception e) {
            Assert.fail();
        }
        logger.info("******* Finished TC001_AccountRegisterationTest *******");
    }
}


