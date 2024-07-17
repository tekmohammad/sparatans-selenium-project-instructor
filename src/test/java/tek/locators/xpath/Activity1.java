package tek.locators.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
    /*
    In retail App click on Videos Games then choose PS5 console
    then click on add to cart
    Only use relative xpath.
    Push to your GitHUB repository
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//img[@alt='Video Games']"))
                .click();

        Thread.sleep(1000);
        // you can use contain with Text as well on Xpath Example: `//p[contains(text(), 'Console')]`
        driver.findElement(By.xpath("//p[text()='PlayStation 5 Console']"))
                .click();

        Thread.sleep(1000);

        String text = driver.findElement(By.xpath("//h1[@class='product__name']")).getText();
        System.out.println(text);

        driver.findElement(By.xpath("//button[@id='addToCartBtn']")).click();


    }
}
