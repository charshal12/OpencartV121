package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import testBase.BaseClass;

public class TC006_EndToEndTest extends BaseClass {
    @Test(groups={"Master"})
    public void endToendTest() throws InterruptedException {
        //Soft Assert
        SoftAssert myassert = new SoftAssert();

        //Account Registeration
        System.out.println("Account Registeration.........");
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickRegister();

        AccountRegisterationPage regPage = new AccountRegisterationPage(driver);
        regPage.setTxtFirstName(randomString().toUpperCase());
        regPage.setTxtLastName(randomString().toUpperCase());

        String email = randomString()+"@gmail.com";
        regPage.setTxtEmail(email);

        regPage.setTxtTelephone("1234567890");
        regPage.setTxtPassword("test123");
        regPage.setTxtConfirmPassword("test123");
        regPage.setPrivacyPolicy();
        regPage.clickContinue();
        Thread.sleep(3000);


        String confMsg = regPage.getConfirmationMsg();
        System.out.println(confMsg);

        myassert.assertEquals(confMsg,"Your Account Has Been Created!");//validation

        MyAccountPage macc= new MyAccountPage(driver);
        macc.clickLogout();
        Thread.sleep(3000);

        //Login
        System.out.println("Login To Application ...........");
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailTxt(email);
        loginPage.setPwdTxt("test123");
        loginPage.clickLogin();

        System.out.println("Going to My Account Page? "+macc.isMyAccountPageExist());
        myassert.assertEquals(macc.isMyAccountPageExist(),true);

        //search and add product to cart
        System.out.println("Search and add product to cart................");
        homePage.enterProductName(p.getProperty("searchProductName"));
        homePage.clickSearch();

        SearchPage sp = new SearchPage(driver);
        if (sp.isProductExist(p.getProperty("searchProductName"))){
            sp.selectProduct(p.getProperty("searchProductName"));
            sp.setQuantity("1");
            sp.addToCartSearchPage("searchProductName");
        }
        Thread.sleep(3000);
        System.out.println("Added product to the cart ? "+ sp.checkConfMsg());
        myassert.assertEquals(sp.checkConfMsg(),true);

        //Shopping cart
        System.out.println("Shopping cart .................");
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickItemsToNavigateToCart("searchProductName");
        shoppingCartPage.calculateTotalPrice();
        shoppingCartPage.clickViewCart();
        Thread.sleep(3000);
        String totPrice = shoppingCartPage.getTotalPrice();
        System.out.println("The Total Price of cart is: "+totPrice);
        myassert.assertEquals(totPrice,"$246.40");//validation
        shoppingCartPage.clickOnCheckout();
        Thread.sleep(3000);




    }
}
