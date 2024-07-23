package tek.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleDropDownWithoutSelect {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/dynamic-select");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Thread.sleep(3000);

        driver.findElement(By.xpath("//p[text()='From']/following-sibling::input"))
                .click();

        List<WebElement> fromOptions =driver
                .findElements(By.xpath("//p[text()='From']/following-sibling::ul/li"));

        //fromOptions.get(2).click();

        for(WebElement option : fromOptions) {
            String text = option.getText();

            if (text.equals("Bamyan")) {
                option.click();
                break;
            }
        }


        driver.findElement(By.xpath("//p[text()='Depart']/following-sibling::input"))
                .sendKeys("07/22/2024");
    }
}
