
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglePage {

    private AppiumDriver driver;

    public GooglePage(AppiumDriver driver) {
        this.driver = driver;
    }

    // البحث عن مربع النص
    public WebElement searchBox() {
        return driver.findElement(By.name("q"));
    }

    // الانتظار حتى يظهر مربع النص
    public void waitForSearchBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
    }

    // تنفيذ البحث
    public void searchFor(String searchQuery) {
        searchBox().sendKeys(searchQuery);
        searchBox().sendKeys(Keys.ENTER);
    }

    // الانتظار حتى تظهر نتائج البحث
    public void waitForSearchResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
    }
}
