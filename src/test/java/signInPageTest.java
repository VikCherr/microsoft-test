import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class signInPageTest {
    private WebDriver driver;
    private signInPage signInPage;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&rver=7.3.6963.0&wp=MBI_SSL&wreply=https%3a%2f%2fwww.microsoft.com%2fen-us%2f&lc=1033&id=74335&aadredir=1");
        signInPage = new signInPage(driver);

    }

    @Test
//    @Ignore
    public void signIn () {
        signInPage newSignInPage = signInPage.enterLogin("logvinenkovika1@gmail.com");
        signInPage newSignInPage2 = newSignInPage.waitPassField();
        signInPage newSignInPage3 = newSignInPage2.enterPass("Temp2021/");
        signInPage newSignInPage4 = newSignInPage3.waitSignInButton();
        signInPage newSignInPage5 = newSignInPage4.clickNextButton();
        signInPage newSignInPage6 = newSignInPage5.waitLoginUser();
        String loginUserText = newSignInPage4.getloginUserText();
        Assert.assertEquals("Виктория", loginUserText);
    }

    @Test
//    @Ignore
    public void invalidLogin(){
    signInPage newSignInPage = signInPage.enterLogin("@");
    signInPage newSignInPage2 = newSignInPage.clickNextButton();
    signInPage newSignInPage3 = newSignInPage2.waitLoginErrorText();
    String loginErrorText = newSignInPage2.getLoginErrorText();
        Assert.assertEquals("Enter a valid email address, phone number, or Skype name.", loginErrorText);

    }
    @Test
//    @Ignore
    public void doesNotExistLogin (){
        signInPage newSignInPage = signInPage.enterLogin("sdlkjfsk");
        String loginErrorText = newSignInPage.getLoginErrorText();
        Assert.assertEquals("That Microsoft account doesn't exist. Enter a different account or get a new one.", loginErrorText);
    }
    @Test
//    @Ignore
    public void incorrectPass () {
        signInPage newSignInPage = signInPage.enterLogin("logvinenkovika1@gmail.com");
        signInPage newSignInPage2 = newSignInPage.waitPassField();
        signInPage newSignInPage3 = newSignInPage2.enterPass("12345678");
        signInPage newSignInPage4 = newSignInPage3.waitSignInButton();
        signInPage newSignInPage5 = newSignInPage4.clickNextButton();
        String passErrorText = newSignInPage4.getPassErrorText();
        Assert.assertEquals("Your account or password is incorrect. If you don't remember your password, reset it now.", passErrorText);
    }

    @Test
 //   @Ignore
    public void signUpLink () {
        signUpPage newSignUpPage = signInPage.clickSignUpLink();
        signUpPage newSignUpPage2 = newSignUpPage.waitForSignUpHeading();
        String signUpHeading = newSignUpPage2.getSignUpHeading();
        Assert.assertEquals("Create account", signUpHeading);
    }


 @After
    public void tearDown (){
        driver.quit();
    }
}
