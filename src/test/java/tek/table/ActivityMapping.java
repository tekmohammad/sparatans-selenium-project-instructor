package tek.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tek.utility.SeleniumUtility;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityMapping {

    /*
     on Insurance app "https://dev.insurance.tekschool-students.com/", login with
    supervisor / tek_supervisor credentials, and go to plans section
    and Map Plan Type with Plan Base price.
    Use SeleniumUtility
    Auto=$140.00
    Renter=$xxx
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.insurance.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        SeleniumUtility utility = new SeleniumUtility(driver);

        utility.clickOnElement(By.linkText("Login"));

        utility.sendTextToElement(By.name("username"), "supervisor");
        utility.sendTextToElement(By.name("password"), "tek_supervisor");

        utility.clickOnElement(By.xpath("//button[text()='Sign In']"));

        utility.clickOnElement(By.linkText("Plans"));

        List<WebElement> tableRows = utility.getElements(By.xpath("//table/tbody/tr"));

        Map<String, String> plans = new HashMap<>();

        for(int row = 0; row < tableRows.size(); row++) {
            String xpathForPlanType = "//table/tbody/tr[" + (row + 1) + "]/td[2]";
            String xpathForPrice = "//table/tbody/tr[" + (row + 1) + "]/td[3]";

            String planTypeKey = utility.getElementText(By.xpath(xpathForPlanType));
            String planPriceValue = utility.getElementText(By.xpath(xpathForPrice));

            plans.put(planTypeKey, planPriceValue);
        }

        System.out.println(plans);

        driver.quit();
    }
}
