package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //PageFactory

    @FindBy(css="[placeholder='Select Country']")
    WebElement country;

    By resultsBy = By.cssSelector(".ta-results");

    @FindBy(xpath="//div[@class='user__address']//div//section//button[2]")
    WebElement selectCountry;

    @FindBy(css=".action__submit")
    WebElement submit;

    public void selectCountry(String value){

        actions.sendKeys(country, value).build().perform();

        waitForElementToAppear(resultsBy);

        selectCountry.click();


    }
    public SummaryPage submitOrder(){
        submit.click();
        return new SummaryPage(driver);
    }

}
