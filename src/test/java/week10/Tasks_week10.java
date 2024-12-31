package week10;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Tasks_week10 {

    private static WebDriver webDriver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        webDriver = new ChromeDriver(options);

        //initializing WebDriverWait for explicit wait
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    //task1
    @Test
    public void CheckboxesTest(){
        webDriver.get("https://demoqa.com/checkbox");

        WebElement homeExpand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='check-box-tree-wrapper']/div/ol/li/span/button")));
        homeExpand.click();

        WebElement documentsSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='check-box-tree-wrapper']/div/ol/li/ol/li[2]/span/label")));
        if(documentsSelect.isSelected()){
            System.out.println("Already selected.");
        }
        else {
            documentsSelect.click(); //if not selected, select, by clicking on the checkbox
        }

        WebElement documentsExpand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='check-box-tree-wrapper']/div/ol/li/ol/li[2]/span/button")));
        if(documentsExpand.isSelected()){
            System.out.println("Already expanded.");
        }
        else {
            documentsExpand.click(); //if not expanded, expand by clicking on the checkbox
        }

        WebElement option1 = webDriver.findElement(By.xpath("//*[@class='check-box-tree-wrapper']/div/ol/li/ol/li[2]/ol/li[1]/span/label/input"));
        WebElement option2 = webDriver.findElement(By.xpath("//*[@class='check-box-tree-wrapper']/div/ol/li/ol/li[2]/ol/li[2]/span/label/input"));

        ArrayList<WebElement> documentOptions = new ArrayList<>();
        documentOptions.add(option1);
        documentOptions.add(option2);

        for(int i=0; i<documentOptions.size(); i++){
            assertTrue(documentOptions.get(i).isSelected());
        }

    }

    //task3
    @Test
    public void findBestToursTest() throws InterruptedException{

        webDriver.get("https://phptravels.net/tours");

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        WebElement stunningDubaiLink = webDriver.findElement(By.xpath("//*[@class='featured_tours container py-5 pt-0']/div/div[2]/div/div/a[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", stunningDubaiLink);
        Thread.sleep(1000);
        stunningDubaiLink.click();

        WebElement selectAdults = webDriver.findElement(By.name("adults"));
        Select adultSelector = new Select(selectAdults);
        adultSelector.selectByValue("3");
        Thread.sleep(1000);

        WebElement selectChildren = webDriver.findElement(By.name("childs"));
        Select childrenSelector = new Select(selectChildren);
        childrenSelector.selectByValue("2");
        Thread.sleep(1000);

        WebElement total = webDriver.findElement(By.className("total"));
        assertEquals("230", total.getText());

        WebElement bookNowBtn = webDriver.findElement(By.xpath("//button[@type='submit']"));
        bookNowBtn.click();
        Thread.sleep(1000);

    }


    @AfterAll
    public static void TearDown(){
        if(webDriver!=null){
            webDriver.quit();
        }
    }
}
