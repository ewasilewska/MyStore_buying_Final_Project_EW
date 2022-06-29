package pl.coderslab;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;

    @FindBy(className = "form-control-select")
    private WebElement size;

    @FindBy(id="quantity_wanted")
    private WebElement quantity;

    @FindBy(xpath = "//div//button[@data-button-action='add-to-cart']")
    private WebElement addToCartBtn;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void choseSize(String X) {
        size.sendKeys(X);
    }

    public void choseQuantity(String qnt) {
        quantity.clear();
        quantity.sendKeys(qnt);
    }


    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();
    }


}
