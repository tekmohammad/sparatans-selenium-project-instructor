package tek.review.week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {

    /*
    In Retail app, click on sign in then click on Create new Account
    then fill up the form and sign up. Expectation is to Create new Account.
    once account created make sure profile picture is displayed. (isDisplayed)
    And print result of isDisplayed method.
    Push to your repository
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://retail.tekschool-students.com/");

       By signInLocator = By.id("signinLink");
       WebElement signInElement = driver.findElement(signInLocator);
       signInElement.click();

       By newAccountLocator = By.id("newAccountBtn");
       WebElement newAccountElement = driver.findElement(newAccountLocator);
       newAccountElement.click();

       By nameLocator = By.id("nameInput");
       WebElement nameElement = driver.findElement(nameLocator);
       nameElement.sendKeys("Mohammad");

       String emailPrefix = "mohammad_spartans";
        int number = (int) (Math.random() * 100);
        String randomEmail = emailPrefix + number + "@gmail.com";

       By emailLocator = By.id("emailInput");
       WebElement emailElement = driver.findElement(emailLocator);
       emailElement.sendKeys(randomEmail);

       By passwordLocator =By.id("passwordInput");
       WebElement passwordElement =driver.findElement(passwordLocator);
       passwordElement.sendKeys("Password@123");

       By confirmPasswordLocator = By.id("confirmPasswordInput");
       WebElement confirmPasswordElement = driver.findElement(confirmPasswordLocator);
       confirmPasswordElement.sendKeys("Password@123");

       By signUpLocator = By.id("signupBtn");
       WebElement signUpElement = driver.findElement(signUpLocator);
       signUpElement.click();

       Thread.sleep(1000);

       By profileLocator = By.id("profileImage");
       WebElement profileElement = driver.findElement(profileLocator);

       boolean isProfileDisplayed = profileElement.isDisplayed();

       if (isProfileDisplayed){
           System.out.println("Test Passed");
       }else {
           System.out.println("Test Failed");
       }

       driver.quit();

    }

}
