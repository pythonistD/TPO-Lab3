package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement login;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath  = "//span[@class='messageText--QF1F-']")
    private WebElement errorSpan;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void inputLogin(String login){
        this.login.sendKeys(login);
    }
    public void inputPassword(String password){
        this.password.sendKeys(password);
    }
    public void clickLogin(){
        this.loginButton.click();
    }

    public void login(String email, String password) {
        inputLogin(email);
        inputPassword(password);
        clickLogin();
    }

    public String getErrorMessage(){
        return errorSpan.getText();
    }
    public WebElement getErrorElement(){
        return errorSpan;
    }
}
