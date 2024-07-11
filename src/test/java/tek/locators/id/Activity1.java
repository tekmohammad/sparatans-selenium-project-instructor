package tek.locators.id;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
    /*
    In Retail App click on Sign in then enter email and password
    then Click on Login
    Push to your github repository
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.get("https://retail.tekschool-students.com/");

        By signInLocator = By.id("signinLink");
        WebElement signInElement = driver.findElement(signInLocator);
        signInElement.click();

        By emailInputLocator = By.id("email");
        WebElement emailInputElement = driver.findElement(emailInputLocator);

        emailInputElement.sendKeys("mohammad@gmail.com");

        By passwordLocator = By.id("password");
        WebElement passwordElement = driver.findElement(passwordLocator);
        passwordElement.sendKeys("password123");

        By loginBtnLocator = By.id("loginBtn");
        WebElement loginBtnElement = driver.findElement(loginBtnLocator);
        loginBtnElement.click();
    }
}
