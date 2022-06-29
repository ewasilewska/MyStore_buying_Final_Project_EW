package pl.coderslab;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BuyingProductTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/");
    }


    @Test
    public void buyingProduct() throws IOException {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoggIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("ew.soroka@gmail.com", "!123!123");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToClothes();

        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.choseSweater();

        ProductPage productPage = new ProductPage(driver);
        productPage.choseSize("M");
        productPage.choseQuantity("5");
        productPage.addToCart();

        SuccessBannerPage successBannerPage = new SuccessBannerPage(driver);
        successBannerPage.goToCheckout();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.confirmAddress();


        checkoutPage.choosePresta();
        checkoutPage.chooseCheckPayment();
        checkoutPage.agreeToTheTerms();
        checkoutPage.orderProduct();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\ewsor\\Desktop\\screenshot.png"));


    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
