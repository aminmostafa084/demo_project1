
import org.testng.annotations.Test;

public class RunWebApplicationTest extends BaseTest {

    @Test
    public void openGoogleAndSearch() {
        // تهيئة صفحة جوجل
        GooglePage googlePage = new GooglePage(driver);

        // فتح جوجل وانتظار ظهور مربع البحث
        driver.get("https://www.google.com");
        googlePage.waitForSearchBox();

        // البحث عن مصطلح معين
        googlePage.searchFor("Appium Android testing");

        // الانتظار حتى تظهر نتائج البحث
        googlePage.waitForSearchResults();
    }
}
