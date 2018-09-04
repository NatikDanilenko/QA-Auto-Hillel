package pageobjectHotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ComparisonListPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBys({
            @FindBy(xpath = "//div[@class='title-overflow']//a")
    })
    private List<WebElement> webElementList;

    @FindBy(xpath = "//a[@class = 'action-link']//i[@class = 'delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[text() = 'Да']")
    private WebElement confirmDelete;


    public ComparisonListPage (final WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 30);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getTextSelectedItems(String [] expectedItemsList) {
        final List<String> itemsText = new ArrayList<String>();
        for (final WebElement element : webElementList) {
            final String text = element.getText();
            itemsText.add(text);
        }
    }

    public FilterResultPage deleteSelectedItems() {
        deleteButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(confirmDelete)).click();
        return new FilterResultPage(driver);
        }

    }


