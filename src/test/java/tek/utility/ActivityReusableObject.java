package tek.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ActivityReusableObject {

    /*
    in retail app, sign in with invalid username and password
    and get the error message.
    //Create SeleniumUtility on your own
     */

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        SeleniumUtility utility = new SeleniumUtility(driver);
        utility.clickOnElement(By.linkText("Sign in"));

        utility.sendTextToElement(By.name("email"), "wrong@gmail.com");
        utility.sendTextToElement(By.name("password"), "wrongPassword");

        utility.clickOnElement(By.id("loginBtn"));

        String errorMessage = utility.getElementText(By.className("error"));

        System.out.println(errorMessage);
        driver.quit();
    }

}
