package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test(groups={"Sanity","Master"})
    public void verify_login(){
        logger.info("********* Starting TC002_LoginTest ********");
        try {
            //Homepage
            HomePage hmPage = new HomePage(driver);
            hmPage.clickMyAccount();
            hmPage.clickLogin();

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            lp.setEmailTxt(p.getProperty("email"));
            lp.setPwdTxt(p.getProperty("password"));
            lp.clickLogin();

            //MyAccount
            MyAccountPage mAcc = new MyAccountPage(driver);
            boolean targetPage = mAcc.isMyAccountPageExist();

            Assert.assertTrue(targetPage);//OR //Assert.assertEquals(targetPage,true,"LoginFailed");
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("********* Finished TC002_LoginTest ********");
    }
}
