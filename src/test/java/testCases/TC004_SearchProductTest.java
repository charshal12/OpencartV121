package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {
    @Test(groups={"Master"})
    public void verify_productSearch() {
        logger.info("Starting TC004_SearchProductTest");

        try {
            HomePage hm = new HomePage(driver);

            hm.enterProductName("mac");
            hm.clickSearch();
            Thread.sleep(3000);
            SearchPage sp = new SearchPage(driver);
            boolean res=sp.isProductExist("MacBook");
            System.out.println(res);

            Assert.assertEquals(res,true);
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("Finished TC004_SearchProductTest");
    }


}
