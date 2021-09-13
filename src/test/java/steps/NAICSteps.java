package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.naic.loginPage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NAICSteps {

    WebDriver driver ;
    LoginPage loginPage = new LoginPage();

    @Given("user launched the browser")
    public void user_launched_the_browser() {
        System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver");
        driver = new ChromeDriver();
    }


    @When("user opens homepage")
    public void user_opens_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }
    @When("click on login")
    public void click_on_login() {
        loginPage.clickLogin();
        try
        {
           Thread.sleep(2000);
        }
        catch (Exception exc)
        {
           exc.printStackTrace();
        }

    }
    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        if(Driver.getDriver().getPageSource().contains("Login was unsuccessful."))
        {
            Driver.getDriver().quit();
        }
        else
        {
            Assert.assertEquals(title, Driver.getDriver().getTitle());
        }
    }
    @Then("user should see warning {string}")
    public void user_should_see_warning(String string) {
        Driver.closeDriver();
    }


}
