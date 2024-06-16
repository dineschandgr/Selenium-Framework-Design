package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //PageFactory

    @FindBy(css=".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(css=".totalRow button")
    WebElement checkoutElement;


    public boolean verifyProductFound(String productName){
        boolean productFound = cartProducts.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
        return productFound;
    }

    public CheckoutPage goToCheckOut(){
        checkoutElement.click();
        return new CheckoutPage(driver);
    }


}
