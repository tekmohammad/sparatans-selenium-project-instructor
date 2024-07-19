package tek.review.week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Activity1 {
    /*
    in retail sign in with valid credentials and go to account page.
    update phone number. and validate Success toast is displayed.
    your test should work without changing multiple time.
    Apply implicit and explicit wait.
    use any locators available and you like.
    push to repository.
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")))
                .sendKeys("mohammad2536@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("Password@123");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Account")))
                .click();

        WebElement phoneElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.name("phoneNumber")));

        phoneElement.clear();
        String number = getRandomPhoneNumber();
        System.out.println("random number " + number);
        phoneElement.sendKeys(number);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("personalUpdateBtn")))
                .click();

        boolean isToastDisplayed = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("Toastify"))).isDisplayed();

        String toastText = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(
                                By.cssSelector(".Toastify div.Toastify__toast-body > div:last-child")))
                .getText();
        System.out.println(toastText);
        if (isToastDisplayed)
            System.out.println("Test Passed Toast Displayed");
        else
            System.out.println("Test Failed");

        driver.quit();
    }

    private static String getRandomPhoneNumber() {
        Random random = new Random();
        // Generate 10 random digits and concatenate them to form a 10-digit number
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            // Generate a random digit between 0 and 9
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        // Convert StringBuilder to String
        return sb.toString();
    }
}
