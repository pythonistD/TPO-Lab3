import org.example.Utils;
import org.example.WelcomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class WelcomePageTest {
    @Test
    public void virtualHostingBtnRedirectNewTest(){
        String expectedNewPath = "https://timeweb.com/ru/services/hosting/";
        Utils.getDrivers().parallelStream().forEach(driver  -> {
            driver.get(Utils.URL);
            WelcomePage welcomePage = new WelcomePage(driver);
            welcomePage.acceptCookies();
            welcomePage.clickTryVirtualHostingBtn();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(webDriver -> webDriver.getCurrentUrl().contains(expectedNewPath));
            assertEquals(expectedNewPath, driver.getCurrentUrl());
            driver.quit();
        });
    }

    @Test
    public void chooseVdsBtnRedirectTest(){
        String expectedNewPath = "https://timeweb.com/ru/services/vds/";
        Utils.getDrivers().parallelStream().forEach(driver  -> {
            driver.get(Utils.URL);
            WelcomePage welcomePage = new WelcomePage(driver);
            welcomePage.acceptCookies();
            welcomePage.clickGetVdsBtn();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(webDriver -> webDriver.getCurrentUrl().contains(expectedNewPath));
            assertEquals(expectedNewPath, driver.getCurrentUrl());
            driver.quit();
        });
    }
    @Test
    public void chooseServerBtnRedirectTest(){
        String expectedNewPath = "https://timeweb.com/ru/services/dedicated-server/";
        Utils.getDrivers().parallelStream().forEach(driver  -> {
            driver.get(Utils.URL);
            WelcomePage welcomePage = new WelcomePage(driver);
            welcomePage.acceptCookies();
            welcomePage.clickChooseServerBtn();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(webDriver -> webDriver.getCurrentUrl().contains(expectedNewPath));
            assertEquals(expectedNewPath, driver.getCurrentUrl());
            driver.quit();
        });
    }

    @Test
    public void orderSiteRedirectTest(){
        String expectedNewPath = "https://timeweb.com/ru/services/constructor/turnkey-website/";
        Utils.getDrivers().parallelStream().forEach(driver  -> {
            driver.get(Utils.URL);
            WelcomePage welcomePage = new WelcomePage(driver);
            welcomePage.acceptCookies();
            welcomePage.clickOrderSite();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(webDriver -> webDriver.getCurrentUrl().contains(expectedNewPath));
            assertEquals(expectedNewPath, driver.getCurrentUrl());
            driver.quit();
        });
    }

    @Test
    public void freeConstructorRedirectTest(){
        String expectedNewPath = "https://timeweb.com/ru/services/constructor/";
        Utils.getDrivers().parallelStream().forEach(driver  -> {
            driver.get(Utils.URL);
            WelcomePage welcomePage = new WelcomePage(driver);
            welcomePage.acceptCookies();
            welcomePage.clickFreeConstructor();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(webDriver -> webDriver.getCurrentUrl().contains(expectedNewPath));
            assertEquals(expectedNewPath, driver.getCurrentUrl());
            driver.quit();
        });
    }

}
