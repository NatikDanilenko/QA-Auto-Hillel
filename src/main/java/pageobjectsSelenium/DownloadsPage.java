package pageobjectsSelenium;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DownloadsPage {


    @FindBys(
            @FindBy(xpath = "//*[@id=\"mainContent\"]/table[1]/tbody/tr/td[1]"
            ))

    private List<WebElement> langsDownload;

    public DownloadsPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void verifyLangsDownloadText(String langsTextExpected []) {

        final List<String> langsText = new ArrayList<String>();
        for (final WebElement langsItem : langsDownload) {
            final String text = langsItem.getText();
            langsText.add(text);
        }

       Assert.assertArrayEquals("Не работает!", langsTextExpected, langsText.toArray());

    }
}








