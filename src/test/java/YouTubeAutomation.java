import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class YouTubeAutomation {
    public static void main(String[] args) throws InterruptedException {
            // Set the path to your ChromeDriver executable
            WebDriverManager.chromedriver().setup();
            // Initialize the ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
            WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Çerezleri kabul et

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();

        WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.click();

        inputBox.sendKeys("Konusanlar");

        driver.findElement(By.id("search-icon-legacy")).click();

        Thread.sleep(3000);

        WebElement filters = driver.findElement(By.xpath("//*[@id=\"filter-button\"]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));

        filters.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[.='Over 20 minutes']")).click();
        Thread.sleep(1000);

        filters.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//*[.='Upload date'])[2]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//ytd-video-renderer)[1]")).click();

    }

}


