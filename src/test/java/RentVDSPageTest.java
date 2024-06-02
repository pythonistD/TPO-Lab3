import org.example.LoginPage;
import org.example.RentVDSPage;
import org.example.Utils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentVDSPageTest {

   @Test public void registrationWindowAppearAfterOrderBtnClicked() {
       Utils.getDrivers().parallelStream().forEach(driver  -> {
           driver.get(Utils.RENTVDSURL);
           RentVDSPage rentVDSPage = new RentVDSPage(driver);
           Utils.acceptCookies(driver);
           rentVDSPage.clickOrder();
           WebElement registrationWindow = rentVDSPage.getRegistrationWindow();
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(d -> registrationWindow.isDisplayed());

           driver.quit();
       });
   }
}
