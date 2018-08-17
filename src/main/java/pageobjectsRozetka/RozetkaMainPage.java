package pageobjectsRozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RozetkaMainPage {

    private WebDriver driver;
    private static final String CLOSE_BUNNER_BUTTON = "//span[@class ='exponea-close-cross']";

    @FindBy(xpath = "//li[@id = '2416']")
    private WebElement laptopsAndComputers;

    @FindBy(xpath = "//a[text() = 'Планшеты']")
    private WebElement optionTablets;


    public RozetkaMainPage (final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaMainPage clickLaptopAndComputers() {

        final List<WebElement> closeBannerButton = driver.findElements(By.xpath(CLOSE_BUNNER_BUTTON));
        if (!closeBannerButton.isEmpty()) {
            closeBannerButton.get(0).click();
        }
        laptopsAndComputers.click();
        return new RozetkaMainPage(driver);
    }

    public SearchResultPageTablets clickOptionTablets() {
        optionTablets.click();
        return new SearchResultPageTablets(driver);
    }

}
