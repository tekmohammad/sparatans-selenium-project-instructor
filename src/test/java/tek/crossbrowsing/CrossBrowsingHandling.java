package tek.crossbrowsing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class CrossBrowsingHandling {

    public static void main(String[] args) {
        //Activity is find a way to ask user where to run
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose browser chrome, firefox and edge");
        String browserType = scanner.next();

        WebDriver driver;

        if (browserType.equalsIgnoreCase("chrome")) {
             driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
             driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
             driver = new EdgeDriver();
        }else {
            throw new RuntimeException("Wrong driver");
        }

        driver.get("https://google.com");
    }
}
