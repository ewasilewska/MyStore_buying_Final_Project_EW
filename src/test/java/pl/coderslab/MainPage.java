package pl.coderslab;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    @FindBy(className = "user-info")
    private WebElement loggInBtn;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void goToLoggIn() {
        loggInBtn. click();
    }

}