package tek.locators.css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {

    /*
    In Retail app navigate to Sign in and login with valid credentials
    and after sign in go to account page and print profile email.

    only use CSS Selector.
    push to GitHub repository.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#signinLink")).click();

        driver.findElement(By.cssSelector("input[name='email']"))
                .sendKeys("mohammad2536@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']"))
                .sendKeys("Password@123");

        driver.findElement(By.cssSelector(".login__submit"))
                .click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#accountLink"))
                .click();

        String actualEmailText = driver.findElement(By.cssSelector("div.account__information-detail > h1:last-child"))
                .getText();

        System.out.println(actualEmailText);
        driver.quit();
    }
}
