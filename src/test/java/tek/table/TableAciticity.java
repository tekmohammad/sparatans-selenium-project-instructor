package tek.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TableAciticity {
    /*
    on Insurance app "https://dev.insurance.tekschool-students.com/", login with
    supervisor / tek_supervisor credentials, and go to plans section
    then print all the price values from table.
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.insurance.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.name("username")).sendKeys("supervisor");
        driver.findElement(By.name("password")).sendKeys("tek_supervisor");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();


        driver.findElement(By.linkText("Plans")).click();

        List<WebElement> pricesElements = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));

        for(WebElement element  : pricesElements) {
            System.out.println(element.getText());
        }

        driver.quit();

    }
}
