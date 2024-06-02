package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentVDSPage {
    private WebDriver driver;
    @FindBy(xpath = "(//button[contains(.,'Заказать')])[1]")
    private WebElement orderButton;

    @FindBy(xpath = "//div[text()='Регистрация']")
    private WebElement registrationWindow;

    public RentVDSPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOrder(){
        orderButton.click();
    }

    public WebElement getRegistrationWindow(){
        return registrationWindow;
    }

    public String registrationWindowTitle(){
        return registrationWindow.getText();
    }


}
