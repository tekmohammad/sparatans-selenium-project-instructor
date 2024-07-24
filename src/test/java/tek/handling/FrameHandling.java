package tek.handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FrameHandling {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/iframe");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Option 1) Switching to frame using index number.
      //  driver.switchTo().frame(0);

        //option 2) switching to frame using WebElement
        WebElement frameElement  =driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
        driver.switchTo().frame(frameElement);



        String insideFrame = driver.findElement(By.xpath("//h1[contains(text(), 'This page')]"))
                .getText();

        System.out.println(insideFrame);

        driver.switchTo().defaultContent();

        String outSideFrame = driver.findElement(By.id("title"))
                .getText();

        System.out.println(outSideFrame);
    }
}
