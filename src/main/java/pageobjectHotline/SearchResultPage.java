package pageobjectHotline;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor javascriptExecutor;

    @FindBy(xpath = "(//a[contains(@data-eventlabel, 'Samsung')])[1]")
    private WebElement filterCheckBoxSamsung;

    private static final String COMPARE_PRICES_BUTTON = "//li[@class = 'product-item']//" +
            "div[contains(@class, 'stick-pull')]//a[contains(@title, '%s')]";


    public SearchResultPage (final WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 30);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        javascriptExecutor = ((JavascriptExecutor) driver);
    }

    public FilterResultPage clickFilterSamsung() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filterCheckBoxSamsung);
        filterCheckBoxSamsung.click();
        return new FilterResultPage(driver);
    }

    public ItemPriceRangePage clickComparePricesButton(final String item) {
        final String fullLocator = String.format(COMPARE_PRICES_BUTTON, item);
        final WebElement itemToCompare = driver.findElement(By.xpath(fullLocator));
        webDriverWait.until(ExpectedConditions.visibilityOf(itemToCompare));
        itemToCompare.click();
        return new ItemPriceRangePage(driver);
    }


}

// for (final String item : items) {
//final String fullLocator = String.format(CHECKBOX_LOCATOR, item);
//final WebElement itemToCompare = driver.findElement(By.xpath(fullLocator));
//        webDriverWait.until(ExpectedConditions.visibilityOf(itemToCompare));
//        javascriptExecutor.executeScript("arguments[0].click()", itemToCompare);