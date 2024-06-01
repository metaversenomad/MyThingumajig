import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class YouTubeAutomation {
    public static void main(String[] args) throws InterruptedException {
            // Set the path to your ChromeDriver executable
            WebDriverManager.edgedriver().setup();
            // Initialize the ChromeDriver
            WebDriver driver = new EdgeDriver();

        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Çerezleri kabul et
        WebElement cookies = driver.findElement(By.xpath("//button[@class='yt-spec-button-shape-next yt-spec-button-shape-next--filled yt-spec-button-shape-next--mono yt-spec-button-shape-next--size-m']"));
        cookies.click();

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBox.sendKeys("java");
    }

}


