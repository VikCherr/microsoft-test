import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class mainPageTest {
    private WebDriver driver;
    private mainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Виктория\\IdeaProjects\\microsoft\\driver\\chromedriver.exe");
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.microsoft.com/en-us/");
        mainPage = new mainPage(driver);
    }

    @Test
    public void signInTest(){
    signInPage newSignInPage = mainPage.clickSignInButton();
    signInPage newSignInPage2 = newSignInPage.waitSignInHeading();
    String headingSignIn = newSignInPage2.getHeading();
        Assert.assertEquals("Sign in", headingSignIn);
    }
   


//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}
