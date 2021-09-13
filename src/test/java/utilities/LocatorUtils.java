package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorUtils {

    WebDriver driver ;


    public static void clickById(WebElement elementId) {
        String xpath = "//*[@id='"+elementId+"]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        element.click();
    }

    public static void clickByLabel(WebElement elementLabel) {
        String xpathLabel = "//label[@for="+elementLabel+"]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpathLabel));

        element.click();
    }

    public static void clickByComplexXpath(String tagName, String function, String value) {

        String xpath = "//" + tagName + "[" + function + "(text(),'"+ value + "')]" ;
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        element.click();

    }


    public static void setInputTextByID(WebElement elementId, String textValue) {
        String xpath_id = "//*[@id='"+elementId+"]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath_id));
        element.clear();
        element.sendKeys(textValue);
    }
}
