package tek.locators.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbsoluteXpath {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        By locator = By.xpath("/html/body/div/div[1]/div[1]/div[3]/div/div[2]/div[1]/div[2]/h1");
        String text =driver.findElement(locator).getText();

        System.out.println(text);

        driver.quit();
    }
}
