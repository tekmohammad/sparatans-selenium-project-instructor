package tek.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Activity2 {

     /*
    From the page https://retail.tekschool-students.com/selenium/dropdown
    Select website's language drop down select last option
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/dropdown");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);

        WebElement languageElement = driver.findElement(By.id("languageSelect"));

        Select select = new Select(languageElement);
        List<WebElement> options =select.getOptions();
        int size = options.size();

        select.selectByIndex(size - 1);



    }
}
