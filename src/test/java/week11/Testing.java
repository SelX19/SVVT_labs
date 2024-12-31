package week11;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Testing {
    private static WebDriver driver;

    @BeforeAll
    public static void SetUp(){

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testKlikaHeadingWait(){
        driver.get("https://www.klika.us/");

        //explicit wait, waiting on certain condition

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        assertTrue(heading.getText().contains("Crafting Digital Experiences Worldwide"), "Heading does not contain the expected test");
    }

    @AfterAll
    public static void TearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
