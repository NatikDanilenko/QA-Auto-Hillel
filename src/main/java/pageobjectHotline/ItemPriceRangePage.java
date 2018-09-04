package pageobjectHotline;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ItemPriceRangePage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public ItemPriceRangePage (final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 30);
            }

    private static final String PRICE_RANGE_LOCATOR = "//div[@id=\"page-product\"]/div[2]/div/div/div[2]" +
            "/div/div[1]/div[1]/div[1]/span/span";


    public void findAndVerifyMinAndMaxPrices() {

        final WebElement priceRangePanel = driver.findElement(By.xpath(PRICE_RANGE_LOCATOR));
        String ss = priceRangePanel.getText();
        final String[] prices = ss.split("–");
        final String minPrice = prices[0].trim();
        final String maxPrice = prices[1].trim();

        List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 'offers-item')]"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(items));


        Boolean hasMin = false;
        Boolean hasMax = false;

        for (final WebElement item : items) {

            WebElement valueEl = item.findElement(By.className("value"));
            if (valueEl != null) {
                String value = valueEl.getText().trim();
                if (value.equals(minPrice)) {
                    hasMin = true;
                }

                if (value.equals(maxPrice)) {
                    hasMax = true;
                }

            }
        }
        Assert.assertTrue("The min price does not exist in the list", hasMin);
        Assert.assertTrue("The max price does not exist in the list", hasMax);

    }
}
