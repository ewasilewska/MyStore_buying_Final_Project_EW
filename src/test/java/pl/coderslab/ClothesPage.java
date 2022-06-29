package pl.coderslab;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage {

    private WebDriver driver;

    @FindBy(xpath="//a[text()='Hummingbird printed sweater']")
    private WebElement sweater;


    public ClothesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void choseSweater() {
        sweater.click();
    }

}
