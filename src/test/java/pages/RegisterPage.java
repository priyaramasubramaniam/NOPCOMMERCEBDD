package pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='ico-register']")
    public WebElement linkRegister;

    @FindBy(xpath = "//*[@id='gender-female']")
    public WebElement inputGenderFemale;

    @FindBy(xpath = "//*[@id='FirstName']")
    public WebElement inputFirstName;

    @FindBy(xpath = "//*[@id='LastName']")
    public WebElement inputLastName;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]")
    public WebElement selectDateBirthDay;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    public WebElement selectDateBirthMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    public WebElement selectDateBirthYear;

    @FindBy(xpath = "//*[@id='Email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//*[@id='Company']")
    public WebElement inputCompany;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[@id='ConfirmPassword']")
    public WebElement inputConfirmPassword;

    @FindBy(css = "button[id='register-button']")
    public WebElement buttonRegister;

    public void setLinkRegister(){linkRegister.click();}
    public void setInputGenderFemale(){inputGenderFemale.click();}
    public void setInputFirstName(String fname){inputFirstName.sendKeys(fname);}
    public void setInputLastName(String lname){inputLastName.sendKeys(lname);}
    public void setSelectDateBirthDay(String day){
        Select select = new Select(selectDateBirthDay);
        select.selectByVisibleText(day);
    }
    public void setSelectDateBirthMonth(String month){
        Select select = new Select(selectDateBirthMonth);
        select.selectByVisibleText(month);
    }
    public void setSelectDateBirthYear(String year){
        Select select = new Select(selectDateBirthYear);
        select.selectByVisibleText(year);
    }
    public void setInputEmail(String email){inputEmail.sendKeys(email);}
    public void setInputCompany(String company){inputCompany.sendKeys(company);}
    public void setInputPassword(String password){inputPassword.sendKeys(password);}
    public void setInputConfirmPassword(String cpassword){inputConfirmPassword.sendKeys(cpassword);}
    public void setButtonRegister(){buttonRegister.click();}
}
