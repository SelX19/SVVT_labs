package week7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tasks_week7 {

    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=* ");

        webDriver = new ChromeDriver(options);
        baseUrl = "https://www.ibu.edu.ba";

    }

    @Test
    public void assertDeanOfFaculty() throws InterruptedException{
        webDriver.get("https://www.ibu.edu.ba");
        Thread.sleep(1000);
        webDriver.navigate().to(baseUrl + "/faculty-of-engineering-natural-and-medical-sciences");
        WebElement deanFooter = webDriver.findElement(By.className("dean__footer"));
        assertTrue(deanFooter.getText().contains("Jasmin Kevrić"));

    }

    @Test
    public void testTask2() throws InterruptedException {

        webDriver.get("http://www.uitestingplayground.com/sampleapp");

        WebElement heading = webDriver.findElement(By.tagName("h3")); //or By.xpath("//h3") - using relative path to h3
        assertEquals("Sample App", heading.getText(), "heading mismatch!");

        WebElement paragraph = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/p")); //P.S.: for multiple div tags, the attribute has to be specified by its value/name
        assertEquals(101, paragraph.getText().length(), "paragraph mismatch!");

        WebElement userLoggedOut = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/div[@class='row'][1]/div/label[@id='loginstatus']"));
        assertEquals("User logged out.", userLoggedOut.getText(), "user mismatch!");

        WebElement username = webDriver.findElement(By.name("UserName"));
        WebElement password = webDriver.findElement(By.name("Password"));

        username.sendKeys("wrong");
        Thread.sleep(800);
        password.sendKeys("credentials");
        Thread.sleep(800);

        WebElement loginButton = webDriver.findElement(By.xpath("//button[@id='login']"));
        loginButton.click();
        Thread.sleep(2000);

        assertEquals("Invalid username/password", userLoggedOut.getText(), "user mismatch!");
    }

    @Test
    public void testSearch() throws InterruptedException {

        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement menuButton = webDriver.findElement(By.xpath("/html/body/div[@id='__next']/header/div[@class='menu__wrap']/div[@class='search__elem']"));
        menuButton.click();
        Thread.sleep(2000);

        WebElement searchBar = webDriver.findElement(By.xpath("//input[@placeholder='What are you looking for?']"));
        searchBar.sendKeys("engineering");
        Thread.sleep(1500);

        WebElement firstLink = webDriver.findElement(RelativeLocator.with(By.xpath("//a[1]")).below(searchBar)); //a[1] - first link - relative to (below) already located search bar
        firstLink.click();
        Thread.sleep(1000);
    }

    @AfterAll
    public static void tearDown(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
}
