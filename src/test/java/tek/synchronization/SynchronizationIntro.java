package tek.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationIntro {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();

        //Applying Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Applying Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.id("signinLink")));
        element.click();

        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        inputElement.sendKeys("WrongInput@gmail.com");

        WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        passwordElement.sendKeys("wrongpassword");

        //simple method chaining
        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn"))).click();

        WebElement errorElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
        System.out.println(errorElement.getText());

        driver.quit();

    }

}
