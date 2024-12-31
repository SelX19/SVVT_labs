package lab_exam_preparation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PHPTravelsTest {
    private static WebDriver driver;
    private static String URL;

    @BeforeAll
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        URL = "https://www.phptravels.net/";
    }

    @Test
    public void travelInputFormTest() throws InterruptedException{
        driver.get(URL);
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement toursLink = driver.findElement(By.linkText("Tours"));
        toursLink.click();
        Thread.sleep(5000);

        WebElement ThailandTourLink = driver.findElement(By.xpath("//*[@class='featured_tours container py-5 pt-0']/div/div[2]/div/div/a[5]"));
        js.executeScript("arguments[0].scrollIntoView(true);", ThailandTourLink);
        Thread.sleep(500);
        ThailandTourLink.click();
        Thread.sleep(1000);

        WebElement adultsSelect = driver.findElement(By.id("adults"));
        Select selectAdultsNumber = new Select(adultsSelect);
        selectAdultsNumber.selectByValue("4");
        Thread.sleep(1000);

        WebElement childrenSelect = driver.findElement(By.id("childs"));
        Select selectChildrenNumber = new Select(childrenSelect);
        selectChildrenNumber.selectByValue("3");
        Thread.sleep(1000);

        WebElement selectDate = driver.findElement(By.name("date"));
        selectDate.click();
        Thread.sleep(2000);

        WebElement  monthAndYear = driver.findElement(By.className("next"));
        monthAndYear.click();
        Thread.sleep(2000);

        WebElement daysRow = driver.findElement(By.xpath("//*[@class='datepicker-days']/table/tbody/tr[4]/td[5]"));
        daysRow.click();
        Thread.sleep(1000);

        WebElement total = driver.findElement(By.className("total"));
        assertEquals("502", total.getText());
        Thread.sleep(1000);

        WebElement bookNowButton = driver.findElement(By.xpath("//*[@type='submit']"));
        bookNowButton.click();
        Thread.sleep(2000);

        WebElement firstName = driver.findElement(By.name("user[first_name]"));
        WebElement lastName = driver.findElement(By.name("user[last_name]"));
        WebElement email = driver.findElement(By.name("user[email]"));
        WebElement phone = driver.findElement(By.name("user[phone]"));
        WebElement address = driver.findElement(By.name("user[address]"));

        firstName.sendKeys("Selma");
        lastName.sendKeys("Djozic");
        email.sendKeys("selma.dozic@stu.ibu.edu.ba");
        phone.sendKeys("061361107");
        address.sendKeys("Vodopivec 17, Kranj 4000");
        Thread.sleep(1000);

        WebElement traveler1Title = driver.findElement(By.name("title_1"));
        Select title1 = new Select(traveler1Title);
        title1.selectByVisibleText("Mrs"); //selectByValue could be used as well
        Thread.sleep(1000);

        WebElement traveler1FirstName = driver.findElement(By.name("firstname_1"));
        traveler1FirstName.sendKeys("Annete");
        Thread.sleep(1000);

        WebElement traveler1LastName = driver.findElement(By.name("lastname_1"));
        traveler1LastName.sendKeys("Bradford");
        Thread.sleep(1000);

        String newURL = driver.getCurrentUrl();
        assertEquals("https://www.phptravels.net/tours/booking", newURL);
        Thread.sleep(1000);
    }

    @AfterAll
    public static void TearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
