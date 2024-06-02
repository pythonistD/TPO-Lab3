import org.example.LoginPage;
import org.example.Utils;
import org.example.WelcomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoginPageTest {

    @Test
    public void loginPageCorrectDataTest(){
        String expectedNewPath = "https://hosting.timeweb.ru/";
        Utils.getDrivers().parallelStream().forEach(driver  -> {
            driver.get(Utils.LOGINPAGEURL);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(Utils.USERNAME, Utils.PASSWORD);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(webDriver -> webDriver.getCurrentUrl().contains(expectedNewPath));
            assertEquals(expectedNewPath, driver.getCurrentUrl());
            driver.quit();
        });
    }
    @Test
    public void loginPageIncorrectDataTest(){
        Utils.getDrivers().parallelStream().forEach(driver  -> {
            driver.get(Utils.LOGINPAGEURL);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("sdfafsaf","asdffafa");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorElement  = loginPage.getErrorElement();
            wait.until(webDriver   -> errorElement.isDisplayed());
            assertEquals("Неизвестная ошибка. Пожалуйста, обратитесь в службу поддержки", loginPage.getErrorMessage());

            driver.quit();
        });
    }
}
