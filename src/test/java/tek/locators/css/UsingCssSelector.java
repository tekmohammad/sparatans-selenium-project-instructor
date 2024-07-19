package tek.locators.css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingCssSelector {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();

        Thread.sleep(10000);

        By titleLocator = By.cssSelector("div.home__categories-grid > div:nth-child(2) > h1");
        String text = driver.findElement(titleLocator).getText();

        System.out.println(text);

        driver.quit();
    }

    public By getButtonLocator(String buttonText) {
        return By.xpath("//button[text() ='"+buttonText+"']");
    }
}
