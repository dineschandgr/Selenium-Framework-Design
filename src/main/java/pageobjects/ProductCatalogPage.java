package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogPage extends AbstractComponent {

    WebDriver driver;

    public ProductCatalogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));


    //PageFactory

    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating-3")
    WebElement spinner;

    By productsBy = By.cssSelector(".mb-3");

    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector(".card-body button:last-of-type");

    public List<WebElement> getProductList(){
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName){
        return products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);

    }

    public void addProductToCart(String productName){
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);
    }





}
