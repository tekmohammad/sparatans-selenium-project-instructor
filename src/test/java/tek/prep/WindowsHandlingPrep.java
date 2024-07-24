package tek.prep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowsHandlingPrep {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String mainContextWindowId = driver.getWindowHandle();

        driver.findElement(By.linkText("Test Selenium")).click();

        Set<String> windows = driver.getWindowHandles();
        for(String window : windows) {
            if (!window.equals(mainContextWindowId)) {
                driver.switchTo().window(window);
                break;
            }
        }

        driver.findElement(By.linkText("Inputs")).click();
        Thread.sleep(3000);
        driver.close();

        driver.switchTo().window(mainContextWindowId);

        driver.findElement(By.linkText("Sign in")).click();
    }
}
