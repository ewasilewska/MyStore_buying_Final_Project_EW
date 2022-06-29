package pl.coderslab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;

    @FindBy(id="addresses-link")
    private WebElement addressBtn;

    @FindBy(xpath = "//a[@href='https://prod-kurs.coderslab.pl/index.php?id_category=3&controller=category']")
    private WebElement clothesBtn;



    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void goToAddress() {
        addressBtn.click();
    }

    public void goToClothes() {clothesBtn.click();}



}