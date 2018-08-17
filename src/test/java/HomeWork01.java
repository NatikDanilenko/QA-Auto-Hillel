import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork01 {

    // 1 case
    @Test
    public void verifyLabelJava() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ru.wikipedia.org/wiki/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("Java");
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
        WebElement searchHeading = driver.findElement(By.id("firstHeading"));
        Assert.assertTrue("The label is incorrect", searchHeading.getText().contentEquals("Java"));
        Thread.sleep(2000);
        driver.close();

    }

    // 2 case
    @Test
    public void verifyLanguagesSeleniumDownload() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumhq.org/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement menuDownload = driver.findElement(By.id("menu_download"));
        menuDownload.click();
        driver.getCurrentUrl();
        Assert.assertEquals("https://www.seleniumhq.org/download/", driver.getCurrentUrl());


        String tableLocator = "//*[@id=\"mainContent\"]/table[1]/tbody/tr/td[1]";
        List<WebElement> languages = driver.findElements(By.xpath(tableLocator));
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("Java", "C#", "Ruby", "Python", "Javascript (Node)"));
        for (WebElement lang : languages) {
            Assert.assertTrue(list1.contains(lang.getText()));
        }
        Assert.assertTrue(list1.size() == languages.size());

        driver.close();

 }



}