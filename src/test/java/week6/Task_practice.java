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

public class Task_practice {

    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        baseUrl = "http://www.uitestingplayground.com/sampleapp";
    }

    @Test
    public void testAutomationTestingTask() throws InterruptedException {
        webDriver.manage().window().maximize();
        Thread.sleep(2000);

        webDriver.get(baseUrl);

        WebElement username = webDriver.findElement(By.name("UserName"));
        WebElement password = webDriver.findElement(By.name("Password"));

        assertEquals("input", username.getTagName(), "Element with name attribute as 'username' is not an input element");
        assertEquals("input", password.getTagName(), "Element with name attribute as 'password' is not an input element");

        username.clear();
        password.clear();

        username.sendKeys("test");
        password.sendKeys("pwd");
        Thread.sleep(2000);

        WebElement loginButton = webDriver.findElement(By.id("login"));
        assertEquals("button", loginButton.getTagName(), "Element with id attribute as 'login' is not a button");
        Thread.sleep(2000);

        loginButton.click();

        Thread.sleep(2000);

        WebElement loginStatusLabel = webDriver.findElement(By.id("loginstatus"));
        assertTrue(loginStatusLabel.getText().contains("test"), "Login status doesn't contain 'test' string.");

    }

    @AfterAll
    public static void tearDown(){
        if(webDriver!=null){
            webDriver.quit();
        }
    }
}
