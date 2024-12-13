

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        // إعداد القدرات المطلوبة للجهاز ونظام التشغيل
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("appium:deviceName", "pixel");
        capabilities.setCapability("appium:platformVersion", "15.0");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:disableWindowAnimation", true);

        // تهيئة الـ driver
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);

        // تعيين فترة الانتظار التلقائي
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        // إغلاق الـ driver بعد كل الاختبارات
        if (driver != null) {
            driver.quit();
        }
    }
}
