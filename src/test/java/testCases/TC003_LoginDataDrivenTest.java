package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {

    @Test(dataProvider= "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven") //getting data provider from different package
    public void verify_loginDDT(String email, String pwd, String exp){

        logger.info("******Starting TC003_LoginDataDrivenTest ************");
        try {
            //Homepage
            HomePage hmPage = new HomePage(driver);
            hmPage.clickMyAccount();
            hmPage.clickLogin();

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            lp.setEmailTxt(email);
            lp.setPwdTxt(pwd);
            lp.clickLogin();

            //MyAccount
            MyAccountPage mAcc = new MyAccountPage(driver);
            boolean targetPage = mAcc.isMyAccountPageExist();


/***
 * Data is valid ---login success --- test pass ---logout
 * Data is valid ---login failed --- test fail

 * Data is invalid --- login success --- test failed ---logout
 * Data is invalid --- login failed --- test pass
 ***/

            //Valid Data Conditions
            if(exp.equalsIgnoreCase("Valid")){
                if(targetPage==true){
                    mAcc.clickLogout();
                    Assert.assertTrue(true);
                }else{
                    Assert.assertTrue(false);
                }
            }

            //Invalid Data Conditions
            if(exp.equalsIgnoreCase("Invalid")){
                if (targetPage==true){
                    mAcc.clickLogout();
                    Assert.assertTrue(false);
                }else{
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
           Assert.fail();
        }
        logger.info("******Finished TC003_LoginDataDrivenTest ************");
    }
}
