import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class signInPage {

    private WebDriver driver;


    public signInPage(WebDriver driver){
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@id= \"loginHeader\"]");
    private By loginField = By.xpath ("//input[@type = \"email\"]");
    private By nextButton = By.xpath ("//input[@id=\"idSIButton9\"]");
    private By passField = By.xpath ("//input[@type = \"password\"]");
    private By loginUser = By.xpath ("//div[contains(@class, \"mectrl_header_text\")]");
    private By loginError = By.xpath ("//div[@id=\"usernameError\"]");
    private By passError = By.xpath ("//div[@id=\"passwordError\"]");
    private By signUpLink = By.xpath ("//a[@id=\"signup\"]");
    private By helpButton = By.xpath ("//span[@class=\"help-button\"]");
    private By dialogInner = By.xpath ("//div[@class =\"dialog-inner\"]");
    private By dialogInnerHeader = By.xpath ("//div[@class = \"dialog-inner\"]//span");
    private By closeDialogInnerButton = By.xpath("//input[@id=\"dialogCloseButton\"]");



    public signInPage enterLogin(String login) {
        driver.findElement (loginField).sendKeys(login);
        driver.findElement(nextButton).click();
        return this;
    }

    public signInPage enterPass (String pass){
        driver.findElement(passField).sendKeys(pass);
        return this;
}

    public signInPage clickNextButton(){
        driver.findElement(nextButton).click();
        return this;
    }
    public signUpPage clickSignUpLink (){
        driver.findElement(signUpLink).click();
        return new signUpPage(driver);
    }


    public String getloginUserText() {
        return driver.findElement(loginUser).getText();
    }

    public String getLoginErrorText (){
        return driver.findElement(loginError).getText();
    }
    public String getPassErrorText() {
        return driver.findElement(passError).getText();
    }
    public String getHeading (){
        return driver.findElement(heading).getText();
    }
    public String getDialogInnerHeader() {
        return driver.findElement(dialogInnerHeader).getText();
    }
    public signInPage waitPassField() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passField));
        return this;
    }
    public signInPage waitSignInButton() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        return this;
    }
    public signInPage waitSignInHeading() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(heading));
        return this;
    }

    public signInPage waitLoginUser() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginUser));
        return this;
    }

    public signInPage waitLoginErrorText() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginError));
        return this;
    }

    public signInPage clickHelpButton(){
        driver.findElement(helpButton).click();
        return this;
    }
    public signInPage clickCloseDialogInner(){
        driver.findElement(closeDialogInnerButton).click();
        return this;
    }

}
