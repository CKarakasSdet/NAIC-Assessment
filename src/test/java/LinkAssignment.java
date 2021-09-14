
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class LinkAssignment {

    public static void main(String[] args) {
        WebDriver driver ;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().fullscreen();

        driver.get("https://www.naic.org");

        List<WebElement> ids = driver.findElements(By.xpath("//*[@id]"));

        /**
         * THERE IS NO ANY ID NAMED super_menu, BUT FOLLOWING CODE PRINTS ALL IDs when failed.
         * if there were, then inside this element we collect the links using the xpath.
         * and if there is not any link starts with the string, then we print it out.
         */

        for (WebElement element: ids) {

            if(!element.getAttribute("id").equals("super_menu"))
            {
                System.out.println("id: " + element.getAttribute("id"));
            }
            else
            {
                List<WebElement> links = driver.findElements(By.xpath("//*[@id='super_menu']/a"));

                for(WebElement link : links){
                    if(!link.getAttribute("href").startsWith("https://www.naic.org"))
                    {
                        System.out.println("Failed link: " + link);
                    }
                }

            }

        }


        driver.quit();


    }

}
