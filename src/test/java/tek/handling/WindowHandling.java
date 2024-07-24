package tek.handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandling {

    /* To handle new tab with selenium
    Get current window id. before new tab open
    then open new tab.
    get all tabs id. (Make sure to have only 2 tab)
    Loop through all tabs and switch to new tab when the is not equals to current tab.
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Step 1) get current window id.
        String currentWindowId = driver.getWindowHandle();

        System.out.println(currentWindowId);

        driver.findElement(By.linkText("Test Selenium")).click();
        Thread.sleep(2000);

        //Step 2) find all the tabs ID
        Set<String> allTabs = driver.getWindowHandles();

        // Step 3) Switch to new tab
        for(String tab : allTabs) {
            //finding id for new tab
            if(!tab.equals(currentWindowId)) {
                driver.switchTo().window(tab);
                break;
            }
        }

        Thread.sleep(2000);

        driver.findElement(By.linkText("Inputs")).click();

        Thread.sleep(2000);

        driver.close();

        //it's important to switch back to main window once new tab closed.
        driver.switchTo().window(currentWindowId);

        Thread.sleep(2000);

        driver.findElement(By.linkText("Sign in")).click();

        driver.quit();
    }

}
