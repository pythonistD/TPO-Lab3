import org.example.RentVDSPage;
import org.example.Utils;
import org.example.VirtHostingPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class VirtHostingPageTest {
    @Test
    public void registrationWindowAppearAfterOrderBtnClicked() {
        Utils.getDrivers().parallelStream().forEach(driver  -> {
            driver.get(Utils.VIRTHOSTINGURL);
            VirtHostingPage virtHostingPage = new VirtHostingPage(driver);
            Utils.acceptCookies(driver);
            List<WebElement> startFreeButtons = virtHostingPage.getAllStartButtons();
            startFreeButtons.forEach(
                    btn -> {
                        btn.click();
                        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
                        wait.until(d  -> virtHostingPage.getRegistrationWindow().isDisplayed());
                    }
            );
            driver.quit();
        });
    }
}
