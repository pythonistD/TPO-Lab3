package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private WebDriver driver;
    public static final String URL = "https://timeweb.com/ru/";
    public static final String LOGINPAGEURL = "https://hosting.timeweb.ru/login";
    public static final String RENTVDSURL  =  "https://timeweb.com/ru/services/vds/";
    public static final String VIRTHOSTINGURL   =   "https://timeweb.com/ru/services/hosting/";
    public static final String USERNAME  =  "cu43524";
    public static final String PASSWORD  =  "dN8sY7!o!rz7";

    private static WebDriver setUpDriver(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public static List<WebDriver> getDrivers(){
        WebDriver chromeDriver = new ChromeDriver();
        WebDriver firefoxDriver = new FirefoxDriver();
        chromeDriver.manage().window().maximize();
        firefoxDriver.manage().window().maximize();
        return List.of(chromeDriver, firefoxDriver);
    }
    public static void waitUntilPageLoads(WebDriver driver, long timeout) {
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        waitDriver.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void acceptCookies(WebDriver driver){
        WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/a/button"));
        acceptButton.click();
    }
}
