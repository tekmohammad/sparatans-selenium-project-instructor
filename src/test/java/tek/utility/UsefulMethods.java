package tek.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UsefulMethods {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        clickOnElement(driver, By.linkText("Sign in"));

        driver.findElement(By.name("email")).sendKeys("some@gmail.com");


        driver.findElement(By.name("password")).sendKeys("password123");

        //If true means it's enabled. if false means element is disabled.
       boolean isButtonEnabled = driver.findElement(By.id("loginBtn")).isEnabled();

        System.out.println(isButtonEnabled);
        clickOnElement(driver, By.id("loginBtn"));

        //getting attribute values
        WebElement newCompantyElement = driver.findElement(By.id("newCompanyAccount"));

        String hrefAttribute = newCompantyElement.getAttribute("href");
        System.out.println(hrefAttribute);

        String classAttribute = newCompantyElement.getAttribute("class");
        System.out.println(classAttribute);
        driver.quit();
    }

    public static void clickOnElement(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }
}
