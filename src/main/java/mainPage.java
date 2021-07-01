import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainPage {
    private WebDriver driver;
    public mainPage(WebDriver driver){
        this.driver = driver;
    }
    private By signInButton = By.xpath("//div[@id=\"mectrl_headerPicture\"]");

    public signInPage clickSignInButton (){
        driver.findElement(signInButton).click();
        return new signInPage(driver);

    }



}
