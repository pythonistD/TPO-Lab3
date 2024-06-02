package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VirtHostingPage {
    private WebDriver driver;
    @FindBy(xpath = "//button[contains(.,'Начать бесплатно')]")
    private List<WebElement> startButtons;
    @FindBy(xpath = "//div[text()='Регистрация']")
    private WebElement registrationWindow;


    public VirtHostingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public List<WebElement> getAllStartButtons(){
        return startButtons;
    }
    public WebElement getRegistrationWindow(){
        return registrationWindow;
    }
}
