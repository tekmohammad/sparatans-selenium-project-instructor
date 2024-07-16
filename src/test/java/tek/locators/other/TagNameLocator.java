package tek.locators.other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TagNameLocator {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");

        By anchorsTagLocator = By.tagName("a");

        //method findElements return List<WebElement> contains all the elements find
        //with By strategy
        List<WebElement> anchorElements = driver.findElements(anchorsTagLocator);

        System.out.println(anchorElements.size());

        for(WebElement element : anchorElements) {
            System.out.println(element.getText());
        }

        //find how many image is in BBC Home page.
        By imageTag  = By.tagName("img");
        List<WebElement> imagesElements = driver.findElements(imageTag);
        System.out.println(imagesElements.size());

        //Activity Find how many buttons are in the bbc home pages.
        //and print the text of each button.

        List<WebElement> buttonElements = driver.findElements(By.tagName("button"));
        System.out.println(buttonElements.size());

        for(WebElement element : buttonElements){
            String text = element.getText();
            if (!text.isEmpty())
                System.out.println(text);
        }


        driver.quit();
    }
}
