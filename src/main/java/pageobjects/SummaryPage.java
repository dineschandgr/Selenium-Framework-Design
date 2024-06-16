package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage extends AbstractComponent {

    WebDriver driver;

    public SummaryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //PageFactory

    @FindBy(css=".hero-primary")
    WebElement summaryText;


    public String verifySummaryText(){

        return summaryText.getText();
    }

}
