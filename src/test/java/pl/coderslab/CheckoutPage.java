package pl.coderslab;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;

    @FindBy(name="confirm-addresses")
    private WebElement confirmAddressBtn;

    @FindBy(name="confirmDeliveryOption")
    private WebElement confirmDelivery;

    @FindBy(id="payment-option-1")
    private WebElement checkPayment;

    @FindBy(id="conditions_to_approve[terms-and-conditions]")
    private WebElement agreementCheckbox;

    @FindBy(xpath = "//button[contains(text(),'Order')]")
    private WebElement submitOrder;



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void confirmAddress() {
        confirmAddressBtn.click();
    }


    public void choosePresta() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(confirmDelivery));
        confirmDelivery.click();
    }

    public void chooseCheckPayment() {
        checkPayment.click();
    }

    public void agreeToTheTerms(){
        agreementCheckbox.click();
    }

    public void orderProduct(){
        submitOrder.click();
    }


}

