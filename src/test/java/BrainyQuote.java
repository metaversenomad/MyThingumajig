import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrainyQuote {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.brainyquote.com/quote_of_the_day");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@mode='secondary']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'REJECT')]"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=' css-47sehv']"));

        String dayOfQuote =
                driver.findElement(By.xpath("(//div[@style=\"display: flex;justify-content: space-between\"])[1]")).getText();

        System.out.println(dayOfQuote);

        driver.quit();

    }
}
