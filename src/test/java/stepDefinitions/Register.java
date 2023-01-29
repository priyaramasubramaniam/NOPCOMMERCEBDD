package stepDefinitions;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.RegisterPage;

import java.util.List;
import java.util.Map;


public class Register extends BaseClass{
    private WebDriver driver;
    RegisterPage rp;
    @Given("User launches chrome browser")
    public void user_launches_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("User enters URL {string}")
    public void user_enters_URL(String string) {
        driver.get("https://demo.nopcommerce.com/");
    }

    @Then("User clicks on Register link")
    public void user_clicks_on_Register_link() {
        rp = new RegisterPage(driver);
        rp.setLinkRegister();
    }

    @Then("User enters following details")
    public void user_enters_following_details(DataTable dataTable) {
        List<Map<String, String>>register_data = dataTable.asMaps();
        register_data.get(0).get("Gender");
        String fname = register_data.get(0).get("Firstname");
        String lname = register_data.get(0).get("Lastname");
        String day = register_data.get(0).get("Day");
        String month = register_data.get(0).get("Month");
        String year = register_data.get(0).get("Year");
        String email = register_data.get(0).get("Email");
        String company_name = register_data.get(0).get("Company name");
        String password = register_data.get(0).get("Password");
        String cpassword = register_data.get(0).get("Confirm Password");

        rp.setInputGenderFemale();
        rp.setInputFirstName(fname);
        rp.setInputLastName(lname);
//        rp.setSelectDateBirthDay(day);
//        rp.setSelectDateBirthMonth(month);
//        rp.setSelectDateBirthYear(year);
        rp.setInputEmail(randomEmail());
        rp.setInputCompany(company_name);
        rp.setInputPassword(password);
        rp.setInputConfirmPassword(cpassword);
    }

    @Then("User enters following mandatory details")
    public void user_enters_following_mandatory_details(DataTable dataTable) {
        List<Map<String, String>> register_data_mand = dataTable.asMaps();
        String fname = register_data_mand.get(0).get("Firstname");
        String lname = register_data_mand.get(0).get("Lastname");
        String email = register_data_mand.get(0).get("Email");
        String password = register_data_mand.get(0).get("Password");
        String cpassword = register_data_mand.get(0).get("Confirm Password");

        rp.setInputFirstName(fname);
        rp.setInputLastName(lname);
        rp.setInputEmail(randomEmail());
        rp.setInputPassword(password);
        rp.setInputConfirmPassword(cpassword);
    }

    @Then("User should verify the following messages")
    public void user_should_verify_the_following_messages(DataTable dataTable) {
        List<Map<String, String>> data_validations = dataTable.asMaps();
        String firstname_validation = data_validations.get(0).toString();
        String lastname_validation = data_validations.get(1).toString();
        String email_validation = data_validations.get(2).toString();
        String password_validation = data_validations.get(3).toString();

        Assert.assertEquals(driver.getPageSource().contains(firstname_validation), true);
        Assert.assertEquals(driver.getPageSource().contains(lastname_validation), true);
        Assert.assertEquals(driver.getPageSource().contains(email_validation), true);
        Assert.assertEquals(driver.getPageSource().contains(password_validation), true);

    }
    @Then("User Clicks on Submit button")
    public void user_Clicks_on_Submit_button() {
        rp.setButtonRegister();
    }

    @Then("User should verify the message {string}")
    public void user_should_verify_the_message(String text) {
        Assert.assertEquals(driver.getPageSource().contains(text), true);
    }
    @Then("User closes the browser")
    public void user_closes_the_browser() {
        driver.quit();
    }



}
