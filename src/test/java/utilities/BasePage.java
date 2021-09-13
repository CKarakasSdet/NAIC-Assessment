package utilities;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class BasePage {

    private static final Logger logger = (Logger) LogManager.getLogger("");


    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
