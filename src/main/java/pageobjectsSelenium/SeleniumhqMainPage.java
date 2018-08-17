package pageobjectsSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumhqMainPage {

    @FindBy(xpath = "//li[@id = 'menu_download']")
    private WebElement menuDownload;

    private WebDriver driver;

    public SeleniumhqMainPage (final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DownloadsPage clickDownloadTab () {
        menuDownload.click();
        return new DownloadsPage(driver);
    }

}
