import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class signUpPage {
    private WebDriver driver;
    public signUpPage(WebDriver driver){
        this.driver = driver;
    }

    private By mainPageHeading = By.xpath("//div[text()=\"Create account\"]");
    private By registerPageHeading = By.xpath("//div[@id=\"iPageTitle\"]");
    private By verifyHeading = By.xpath("//div[@id=\"verificationTitle\"]");
    private By passError = By.xpath("//div[@id=\"PasswordError\"]");
    private By birthdayAlert = By.xpath("//div[@id=\"BirthDateError\"]/div");
    private By verifyAlert = By.xpath("//div[@id=\"VerificationCodeError\"]");
    private By emailPhoneField = By.xpath("//input[@id=\"MemberName\"]");
    private By passField = By.xpath("//input[@id=\"PasswordInput\"]");
    private By nextButton = By.xpath("//input[@id=\"iSignupAction\"]");
    private By firstNameField = By.xpath("//input[@id=\"FirstName\"]");
    private By lastNameField = By.xpath("//input[@id=\"LastName\"]");
    private By enterCodeField = By.xpath("//input[@id=\"VerificationCode\"]");
    private By showPassCheckboxCheck = By.xpath("//input[@id=\"ShowHidePasswordCheckbox\"]");
    private By showPassCheckboxClick = By.xpath("//input[@id=\"ShowHidePasswordCheckbox\"]/following-sibling::span");
    private By optionEmailCheckboxCheck = By.xpath("//input[@id=\"iOptinEmail\"]");
    private By usePhoneLink = By.xpath("//a[@id=\"phoneSwitch\"]");
    private  By getNewEmailLink = By.xpath("//a[@id=\"liveSwitch\"]");
    private By useEmailLink = By.xpath("//a[@id=\"easiSwitch\"]");
//    private By selectCountyList = By.xpath("//select[@id=\"PhoneCountry\"]");
//    private By domainList = By.xpath("//select[@id=\"LiveDomainBoxList\"]");
//    private By countryList = By.xpath("//select[@id=\"Country\"]");
//    private By birthMonthList = By.xpath("//select[@id=\"BirthMonth\"]");
//    private By birthDayList = By.xpath("//select[@id=\"BirthDay\"]");
//    private By birthYearList = By.xpath("//select[@id=\"BirthYear\"]");


    public signUpPage enterEmail(String email){
        driver.findElement(emailPhoneField).sendKeys(email);
        return this;
    }
    public signUpPage enterPass (String pass){
        driver.findElement(passField).sendKeys(pass);
        return this;
    }
    public signUpPage enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }
    public signUpPage enterLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }
    public signUpPage enterVerifyCode(String verifyCode){
        driver.findElement(enterCodeField).sendKeys(verifyCode);
        return this;
    }


    public signUpPage clickNextButton(){
        driver.findElement(nextButton).click();
        return this;
    }
    public signUpPage clickUsePhoneLink(){
        driver.findElement(usePhoneLink).click();
        return this;
    }
    public signUpPage clickUseEmailLink(){
        driver.findElement(useEmailLink).click();
        return this;
    }
    public signUpPage clickGetNewEmailLink(){
        driver.findElement(getNewEmailLink).click();
        return this;
    }


    public signUpPage selectList(String listName, String option){
        String listXpath = String.format("//select[@id=\\\"%S\"]", listName);
        String optionXpath = String.format("//option[text()=\\\"%S\"]", option);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
        return this;
    }
    public signUpPage selectShowPassCB(){
        if(!driver.findElement(showPassCheckboxCheck).isSelected()) driver.findElement(showPassCheckboxClick).click();
        return this;
    }
    public signUpPage unSelectShowPassCB(){
        if(driver.findElement(showPassCheckboxCheck).isSelected()) driver.findElement(showPassCheckboxClick).click();
        return this;
    }
    public signUpPage selectOptionEmailCB(){
        if(driver.findElement(optionEmailCheckboxCheck).isSelected()) System.out.println("Pass");
        return this;
    }


    public String getPass(){
       return driver.findElement(passField).getText();
    }
    public String getVerifyHeading (){
        return driver.findElement(verifyHeading).getText();
    }
    public String getVerifyAlert(){
        return driver.findElement(verifyAlert).getText();
    }
    public String getSignUpHeading(){
        return driver.findElement(mainPageHeading).getText();
    }
    public String getRegisterPageHeading (){
        return driver.findElement(registerPageHeading).getText();
    }
    public String getPassError (){
        return driver.findElement(passError).getText();
    }
    public String getBirthdayAlert (){
        return driver.findElement(birthdayAlert).getText();
    }

    
    public signUpPage waitForSignUpHeading() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageHeading));
        return this;
    }
}
