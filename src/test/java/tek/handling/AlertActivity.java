package tek.handling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertActivity {

    /*
    in link here "https://retail.tekschool-students.com/selenium/javascript-alerts"
    click on prompt button and when alert opens.
    Enter your name in the alert input and click okay.
    then get the text below the alert button and print it
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/javascript-alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("promptBtn")).click();

       // Alert alert = driver.switchTo().alert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Option 2) using wait and ExpectedCondition as alertIsPresent.
       Alert alert = wait.until(ExpectedConditions.alertIsPresent());


        alert.sendKeys("Mohammad");

        Thread.sleep(2000);
        alert.accept();

        String text = driver.findElement(By.id("message")).getText();

        System.out.println(text);
    }
}
