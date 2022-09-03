package pageObjects;
import base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

import java.util.List;

public class DiscountCalculatorPage extends Driver {

    CommonMethods helper;
    public DiscountCalculatorPage(){
        PageFactory.initElements(driver, this);
        helper = new CommonMethods();
    }

    @FindBy (id = "format1")
    WebElement percenOffRadioButton;

    @FindBy (name = "pricebefore")
    WebElement priceBeforeTextbox;

    @FindBy (id = "discountinput")
    WebElement discountTextbox;

    @FindBy (xpath = "//input[@value = 'Calculate']")
    WebElement calculateButton;

    @FindBy (className = "clearbtn")
    WebElement clearButton;

    @FindBy(className = "h2result")
    WebElement resultBanner;

    @FindBy(xpath = "//font[@color = 'green']")
    List<WebElement> calculationResults;

    @FindBy(xpath = "//font[@color = 'red']")
    List<WebElement> errorMessages;

    //unused locators

    @FindBy (id = "format2")
    WebElement fixedAmountOff;

    @FindBy (id = "calcSearchTerm")
    WebElement searchBox;

    @FindBy (id = "bluebtn")
    WebElement searchButton;

    @FindBy (id = "calcSearchOut")
    WebElement searchRecommendation;

    @FindBy (xpath = "//a[@href = 'percent-off-calculator.html']")
    WebElement percentOffLink;


    // --- ACTIONS PERFORMED ON WEB ELEMENTS --- //
    public void enterValueForPriceBeforeDiscount(String value){
        priceBeforeTextbox.sendKeys(value);
    }

    public void enterValueForDiscount(String value){
        discountTextbox.sendKeys(value);
    }

    /*
       why use this helper method and not just .click() ? This allows us to handle exceptions and log messages we want
    */
    public void clickCalculate(){helper.clickElement(calculateButton); }

    public void clickClearButton(){
        helper.clickElement(clearButton);
    }

    public boolean resultBannerIsVisible(){
        return resultBanner.isDisplayed();
    }

    public void percentageOffRadioButton(){
       helper.selectRadioButton(percenOffRadioButton);
    }

    public String priceAfterDiscountValue(){
        return calculationResults.get(0).getText();
    }

    public String savedAmountValue(){
        return calculationResults.get(1).getText();
    }

    public String missingInputErrorMessage(){
        return errorMessages.get(0).getText();
    }

}
