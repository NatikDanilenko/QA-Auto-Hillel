package pageobjectHotline;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilterResultPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor javascriptExecutor;

    private static final String CHECKBOX_LOCATOR = "//a[contains(text(), '%s')]/ancestor::li[contains(@class," +
            " 'product-item')]//label";
    private static final String COMPARISON_LIST_BUTTON = "//div[@data-dropdown-target='compare']";

    private static final String MOBILE_TO_COMPARE_LINK = "//div[@data-lazy-content='compare']//" +
            "a[not(@data-clear-compare)]";

    @FindBy(xpath = "//div[@data-lazy-content='compare']//div[@class = 'text']")
    private WebElement comparisonPopup;

    public FilterResultPage(final WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 30);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        javascriptExecutor = ((JavascriptExecutor) driver);
    }

    public void addToComparisonList(final List<String> items) {
        for (final String item : items) {
            final String fullLocator = String.format(CHECKBOX_LOCATOR, item);
            final WebElement itemToCompare = driver.findElement(By.xpath(fullLocator));
            webDriverWait.until(ExpectedConditions.visibilityOf(itemToCompare));
            javascriptExecutor.executeScript("arguments[0].click()", itemToCompare);

        }
    }

    public ComparisonListPage goToComparisonList() {
        final WebElement comparisonListButton = driver.findElement(By.xpath(COMPARISON_LIST_BUTTON));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(comparisonListButton));
        comparisonListButton.click();
        final WebElement mobilesToCompareLink = driver.findElement(By.xpath(MOBILE_TO_COMPARE_LINK));
        webDriverWait.until(ExpectedConditions.visibilityOf(mobilesToCompareLink));
        mobilesToCompareLink.click();
        String winHandleBefore = driver.getWindowHandle();
        for (final String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        return new ComparisonListPage(driver);
    }

    public String getTextComparisonListEmpty() {
        final WebElement comparisonListButton = driver.findElement(By.xpath(COMPARISON_LIST_BUTTON));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(comparisonListButton));
        comparisonListButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(comparisonPopup));
        final String popupText = comparisonPopup.getText();
        return popupText;
    }


    }

