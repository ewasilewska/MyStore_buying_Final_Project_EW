package pl.coderslab;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessBannerPage {

    private WebDriver driver;

    @FindBy(xpath="//a[text()='Proceed to checkout']")
    private WebElement checkoutBtn;



    public SuccessBannerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void goToCheckout() {
        checkoutBtn.click();
    }


}

