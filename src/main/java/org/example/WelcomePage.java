package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WelcomePage {
    //@FindBy(xpath = "//button[contains(text(),'Попробовать бесплатно')]")
    @FindBy(xpath = "//button[@data-selenium='page-main-product-btn-virtual']/../../..")
    //@FindBy(xpath = "//*[@id=\"__layout\"]/div/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/a/span/button")
    private WebElement tryVirtualHostingBtn;
    @FindBy(xpath = "//button[@data-selenium='page-main-product-btn-vds']/../..")
    private WebElement getVDSBtn;
    @FindBy(xpath = "//button[@data-selenium='page-main-product-btn-dedic']/../..")
    private WebElement chooseServer;
    @FindBy(xpath = "//a[@href='https://timeweb.com/ru/services/constructor/turnkey-website/']")
    private WebElement orderSite;
    @FindBy(xpath = "//a[@href='https://timeweb.com/ru/services/constructor/']")
    private WebElement freeConstructor;
    private final WebDriver driver;
    public WelcomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickTryVirtualHostingBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(tryVirtualHostingBtn));
        Actions action = new Actions(driver);
        action.moveToElement(tryVirtualHostingBtn).click().perform();
        //tryVirtualHostingBtn.click();
    }

    public void clickGetVdsBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getVDSBtn));
        Actions action = new Actions(driver);
        action.moveToElement(getVDSBtn).click().perform();
    }

    public void clickChooseServerBtn(){
        chooseServer.click();
    }
    public void clickOrderSite(){
        orderSite.click();
    }

    public void clickFreeConstructor(){
        freeConstructor.click();
    }

    public void acceptCookies(){
        //WebElement acceptButton = driver.findElement(By.xpath("//button[contains(text(), \"Согласен\")]"));
        WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/a/button"));
        acceptButton.click();
    }

    public LoginPage openLoginPage(){
        acceptCookies();
        //WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(), 'Вход')]"));
        WebElement loginButton  = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/header/div[1]/nav/a[4]"));
        driver.get(Utils.LOGINPAGEURL);
        System.out.println(driver.getCurrentUrl());
        return new LoginPage(driver);
    }
}
