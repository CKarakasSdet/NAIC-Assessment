package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.naic.loginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NAICSteps {

    WebDriver driver ;
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

    @Given("user launched the browser")
    public void user_launched_the_browser() {
        System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
        // driver = new ChromeDriver();
    }


    @When("user opens homepage")
    public void user_opens_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @And("user navigates to login page")
    public void user_navigates_to_login_page() {
        loginPage.navigateToPage(loginPage.linkLogin);

    }

    @And("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }
    @Then("click on login")
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
        if(Driver.getDriver().getPageSource().contains("NAIC | Login"))
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

        String loginFailedWarning = Driver.getDriver().
                findElement(By.xpath("//*[contains(text(),'Login failed, please try again.')]")).getText();

        Assert.assertEquals(string,loginFailedWarning);
        Driver.closeDriver();
    }


}
