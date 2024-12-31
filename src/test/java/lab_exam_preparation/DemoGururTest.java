package lab_exam_preparation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class DemoGururTest {
    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        baseUrl = "https://demo.guru99.com/test/login.html";
    }

    @Test
    public void testLogIn(){
        driver.get(baseUrl);

        WebElement emailInputField = driver.findElement(By.id("email"));
        emailInputField.click();
        emailInputField.sendKeys("svvt@test.com");

        WebElement passwordInputField = driver.findElement(By.id("passwd"));
        passwordInputField.click();
        passwordInputField.sendKeys("testing");

        WebElement signInButton = driver.findElement(By.name("SubmitLogin"));
        signInButton.click();

        String newUrl = driver.getCurrentUrl();
        assertNotEquals(baseUrl, newUrl);

        assertEquals("https://demo.guru99.com/test/success.html",newUrl);

        WebElement errorBlock = driver.findElement(By.className("error-copy"));
        assertTrue(errorBlock.getText().contains("Successfully Logged in..."));

    }

    @AfterAll
    public static void TearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
