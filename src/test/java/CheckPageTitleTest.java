import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CheckPageTitleTest {
    private String siteURL = "https://medium.com/";
    private String projectLocation = System.getProperty("user.dir");
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        //configure WebDriver which will be used for test execution
        System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
    }

    @Test
    public void checkrandomlyFiveTitlePages () throws InterruptedException {
        setUp();
        WebDriver driver = new FirefoxDriver();
        driver.get(siteURL);

        //List of page titles
        String expectedTitle [] = {
                "Medium – Get smarter about what matters to you.",
                "Upgrade and become a member of Medium",
                "Welcome to Medium, where words matter.",
                "The Boundaries of Artificial Emotional Intelligence",
                "Medium – Get smarter about what matters to you."
        };
        String currentTitle;

        //Compare Medium – Get smarter about what matters to you. title
        System.out.println("Home page assert");
        currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle, expectedTitle[0]);

        //compare Upgrade and become a member of Medium page title
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/div[3]/div[1]/h4/div/a")).click();
        System.out.println("Subscribe assert");
        currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle, expectedTitle[1]);

        //Compare Welcome to Medium, where words matter. page title
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/h3/a")).click();
        System.out.println("Our story assert");
        currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle, expectedTitle[2]);

        //Compare The Boundaries of Artificial Emotional Intelligence page title
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div[1]/a/div")).click();
        currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle, expectedTitle[3]);



        //Compare Medium – Get smarter about what matters to you. page title
        driver.findElement(By.xpath("/html/body/div/div/nav/div/div[1]/div/div/div/div[1]/a")).click();
        currentTitle = driver.getTitle();
        Assert.assertEquals(driver.getTitle(), expectedTitle[4]);


        driver.quit();

    }

}
