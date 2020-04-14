import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest {
    private String siteURL = "https://medium.com/";
    private String projectLocation = System.getProperty("user.dir");
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", projectLocation + "\\lib\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void loadPage(){
        driver.get(siteURL);
        String actualTitle = "Medium – Get smarter about what matters to you.";
        Assert.assertEquals(driver.getTitle(),actualTitle);
        driver.quit();
    }

}
