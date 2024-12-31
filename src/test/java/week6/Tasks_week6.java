package week6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tasks_week6 {

    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=* ");
        webDriver = new ChromeDriver(options);
        baseUrl = "https://www.ibu.edu.ba";
    }

    @Test
    public void testTitleAndPageSource() throws InterruptedException{
        webDriver.get("https://www.ibu.edu.ba/department-of-information-technologies");
        Thread.sleep(1000);
        assertEquals("Department of Information Technology | IBU", webDriver.getTitle(), "Titles do not match");

        assertTrue(webDriver.getPageSource().contains("_next"), "Web page does not contain '_next'");
    }

    @Test
    public void testIBUNavigation() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(3000);
        webDriver.navigate().to(baseUrl + "/about");
        Thread.sleep(3000);
        assertEquals("About | IBU", webDriver.getTitle(), "Titles do not match");
        webDriver.navigate().back();
        Thread.sleep(1000);
        assertEquals("https://www.ibu.edu.ba/", webDriver.getCurrentUrl());
    }

    @Test
    public void testContactForm() throws InterruptedException {
        webDriver.get(baseUrl + "/contact-us");
        webDriver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement name = webDriver.findElement(By.name("fullName"));
        name.sendKeys("Jane Doe");

        WebElement email = webDriver.findElement(By.name("email"));
        email.sendKeys("janedoe@ibu.edu.ba");

        WebElement subject = webDriver.findElement(By.name("subject"));
        subject.sendKeys("Hello from SVVT");

        WebElement message = webDriver.findElement(By.name("message"));
        message.sendKeys("Hi, this is automated test.");

        Thread.sleep(3000);

    }

    @AfterAll
    public static void tearDown(){
        if(webDriver!=null){
            webDriver.quit();
        }

    }

}
