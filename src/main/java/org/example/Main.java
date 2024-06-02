package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Utils.URL);
        WelcomePage login = new WelcomePage(driver);
        LoginPage loginPage= login.openLoginPage();
        loginPage.login(Utils.USERNAME, Utils.PASSWORD);
    }
}