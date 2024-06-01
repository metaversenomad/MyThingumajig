import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WhatsappBulkMessage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            driver.get("https://web.whatsapp.com/");
            Thread.sleep(20000); // Wait for QR Code scan

            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add("1234567890"); // Add phone numbers here

            List<String> messages = new ArrayList<>();
            messages.add("Hello This is a test message."); // Add messages here

            int i = 0;
            for (String phoneNumber : phoneNumbers) {
                driver.get("https://web.whatsapp.com/send?phone=" + phoneNumber);
                driver.findElement(By.name("sendContainer")).sendKeys(messages.get(i));
                driver.findElement(By.xpath("//span[@content='Send']")).click();
                System.out.println("Message sent to " + phoneNumber);
                i++;
            }

            System.out.println("All messages sent successfully!");

        } catch (InterruptedException | NoSuchElementException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
