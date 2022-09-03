package tests;

import base.Driver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.DiscountCalculatorPage;
import resources.Constants;
import utilities.DataProvider;

public class DiscountCalculatorTests extends Driver{
    DiscountCalculatorPage discountCalculatorPage;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        initiateDriver(browser);
        discountCalculatorPage = new DiscountCalculatorPage();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }


    @Test(priority = 1,dataProvider = "TestData", dataProviderClass = DataProvider.class)
    public void calculateDiscountWithValidInputForPercentageOff(String testname,String originalPrice, String discount,String discountedPrice,String savedAmount) {
        //select percentage off radio button
        discountCalculatorPage.percentageOffRadioButton();
        //clear the default values first
        discountCalculatorPage.clickClearButton();
        //enter values to calculate discount
        discountCalculatorPage.enterValueForPriceBeforeDiscount(originalPrice);
        discountCalculatorPage.enterValueForDiscount(discount);
        discountCalculatorPage.clickCalculate();
        //verify result is calculated correctly
        Assert.assertTrue(discountCalculatorPage.resultBannerIsVisible());
        Assert.assertEquals(discountCalculatorPage.priceAfterDiscountValue(),discountedPrice);
        Assert.assertEquals(discountCalculatorPage.savedAmountValue(),savedAmount);
    }

    @Test(priority = 2,dataProvider = "TestData", dataProviderClass = DataProvider.class)
    public void ValidateMandatoryFieldsToCalculateDiscount(String testname,String originalPrice, String discount,String discountedPrice,String savedAmount){
        //select percentage off radio button
        discountCalculatorPage.percentageOffRadioButton();
        //clear the default values first
        discountCalculatorPage.clickClearButton();
        //enter values to calculate discount
        discountCalculatorPage.enterValueForPriceBeforeDiscount(originalPrice);
        discountCalculatorPage.enterValueForDiscount(discount);
        discountCalculatorPage.clickCalculate();
        //verify error messages are correctly displayed
        Assert.assertTrue(discountCalculatorPage.resultBannerIsVisible());
        Assert.assertEquals(discountCalculatorPage.missingInputErrorMessage(), Constants.errorMsgForMissingInputs);
    }
}
