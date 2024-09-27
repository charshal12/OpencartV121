package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddToCartPageTest extends BaseClass {
    @Test(groups={"Master"})
    public void verify_productSearch() {
        logger.info("Starting TC005_AddToCartPageTest");

        try {
            HomePage hm = new HomePage(driver);

            hm.enterProductName("iPhone");
            hm.clickSearch();
            Thread.sleep(3000);

            SearchPage sp = new SearchPage(driver);
            if(sp.isProductExist("iPhone")){
                sp.selectProduct("iPhone");
                sp.setQuantity("2");
                sp.addToCart();
            }
            Assert.assertEquals(sp.checkConfMsg("searchProductName"),true);
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("Finished TC005_AddToCartPageTest");
    }


}
