import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CheckPageTitleTest {
    private String siteURL = "https://medium.com/";
    private String projectLocation = System.getProperty("user.dir");
    private WebDriver driver;

    public void setUp(){
        //configure WebDriver which will be used for test execution
        System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");

    }

    @Test
    public void checkrandomlyFiveTitlePages () throws InterruptedException{
        setUp();
        WebDriver driver = new FirefoxDriver();
        driver.get(siteURL);

       WebElement menuArea = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/div[3]"));
       List<WebElement> l1 = menuArea.findElements(By.tagName("a"));

       System.out.println("Number of links: "+l1.size());

       for (int i=0; i<l1.size()+2; i++){
           Random r = new Random();
           l1.get(r.nextInt(l1.size())).click();
           ArrayList<String> pagesTitle = new ArrayList<String>();
           System.out.println("Page title is: "+driver.getTitle());
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

           //Assert need to be implemented

           driver.get(siteURL);
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           menuArea = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/div[3]"));
           l1 = menuArea.findElements(By.tagName("a"));
       }
       driver.quit();
    }

}
