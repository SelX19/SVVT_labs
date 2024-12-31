package lab_exam_preparation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HerokuAppTest {
    private static WebDriver driver;
    private static String URL;

    @BeforeAll
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        URL = "https://the-internet.herokuapp.com/";
    }

    @Test
    public void testLogIn() throws InterruptedException{
        driver.get(URL);
        Thread.sleep(1000);

        WebElement formAuthenticationLink = driver.findElement(By.linkText("Form Authentication"));
        formAuthenticationLink.click();
        Thread.sleep(1000);

        String newUrl = driver.getCurrentUrl();
        assertEquals("https://the-internet.herokuapp.com/login", newUrl);

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.click();
        Thread.sleep(1000);
        usernameInputField.sendKeys("tomsmith");
        Thread.sleep(1000);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.click();
        Thread.sleep(1000);
        passwordInputField.sendKeys("SuperSecretPassword!");
        Thread.sleep(1000);

        WebElement logInButton = driver.findElement(By.className("radius"));
        logInButton.click();
        Thread.sleep(1000);// 1 second for viewing the effect of automated testing actions

        String newPage = driver.getCurrentUrl();
        assertEquals("https://the-internet.herokuapp.com/secure", newPage);
        Thread.sleep(2000); //30 seconds for locating log out button

        WebElement referenceElement = driver.findElement(By.tagName("h4"));
        WebElement logOutButton = driver.findElement(RelativeLocator.with(By.linkText("Logout")).below(referenceElement));
        logOutButton.click();
        Thread.sleep(1000);
    }

    @Test
    public void testCheckboxes() throws InterruptedException{
        driver.get(URL);
        Thread.sleep(1000);

        WebElement checkboxesLink = driver.findElement(By.linkText("Checkboxes"));
        checkboxesLink.click();
        Thread.sleep(1000);

        String newUrl = driver.getCurrentUrl();
        assertEquals("https://the-internet.herokuapp.com/checkboxes", newUrl);

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        if(checkbox2.isSelected()){
            checkbox2.click(); //click on checkbox to deselect it
        }
        else{
            System.out.println("Checkbox already deselected");
        }
        Thread.sleep(1000);

        //then select the first checkbox:
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        checkbox1.click();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        assertEquals("https://the-internet.herokuapp.com/", URL);

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        dropdownLink.click();
        Thread.sleep(1000);

        WebElement dropDownMenu = driver.findElement(By.id("dropdown"));
        Select selectOption = new Select(dropDownMenu);
        selectOption.selectByVisibleText("Option 2");
        Thread.sleep(1000);
    }


    @AfterAll
    public static void TearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
