package starter.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class SamplePage extends PageObject {
    WebElement searchElement;
    WebElement textElement;
    List<WebElement> searchResults;
    WebDriverWait webDriverWait = null;
    AndroidDriver driver;

    public void createDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("Samsung Galaxy S23");
//        options.setApp("bs://17e6879eb165e10628f623f85d313c505051f18a");
//        options.setCapability("sdkDriverHandling", false);
//        driver = new AndroidDriver(new URL("https://sritejasugoor_y15tfc:usKZYJCP5arxQjNEW16b@hub-cloud.browserstack.com/wd/hub"), options);
//        driver = new AndroidDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), options);
        driver = new AndroidDriver(options);
    }

    public WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
        return webDriverWait;
    }

    public void selectSearchElement(String searchText) {
        searchElement = (WebElement) getWebDriverWait().until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(searchText)));
        searchElement.click();
    }

    public void insertText(String text) {
        textElement = (WebElement) getWebDriverWait().until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        textElement.sendKeys(text);
    }

    public List<WebElement> getSearchResults() {
        searchResults = driver.findElements(AppiumBy.className("android.widget.TextView"));
        return searchResults;
    }

    public void takeScreenshot() {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

    }
}
