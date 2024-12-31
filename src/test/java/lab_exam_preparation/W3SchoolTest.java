package lab_exam_preparation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class W3SchoolTest {
    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        baseUrl = "https://www.w3schools.com/html/html_tables.asp";
    }

    @Test
    public void testTableElementTitle() throws InterruptedException{
        driver.get(baseUrl);
        Thread.sleep(1000);
        WebElement td = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[6]/td[2]"));
        assertEquals("Yoshi Tannamuri", td.getText());
    }

    @AfterAll
    public static void TearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
