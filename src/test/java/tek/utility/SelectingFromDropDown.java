package tek.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectingFromDropDown {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/dropdown");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        //locate select element in web page.
        //then find it using driver
        WebElement element = driver.findElement(By.id("programmingLanguageSelect"));


        //Create an object from Select class and pass the element.
        Select programmingSelect = new Select(element);

        //Option 1) to select from drop down is using index number of option
        //programmingSelect.selectByIndex(2);

        //Option 2) to select from drop down using value attribute of Option
        //programmingSelect.selectByValue("cPlusPlus");

        //Option 3) to select from drop down using visible text of Options.
          programmingSelect.selectByVisibleText("C#");

    }
}
