package org.naic.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "cui-login")
    @CacheLookup
    public WebElement linkLogin ;

    @FindBy(id = "INT_USERNAME")
    @CacheLookup
    public WebElement txtEmail;

    @FindBy(id = "INT_PASSWORD")
    @CacheLookup
    public WebElement txtPassword;

    @FindBy(xpath = "//*[@id='INT_LOGIN_BTN']")
    @CacheLookup
    public WebElement btnLogin;

    @FindBy(linkText = "Logout")
    @CacheLookup
    public WebElement lnkLogout;

    public void setUsername(String username) {
        txtEmail.clear();
        txtEmail.sendKeys(username);

    }

    public void setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void navigateToPage(WebElement page) {
        page = linkLogin;
        page.click();
    }

    public void clickLogout() {
        lnkLogout.click();
    }

}
