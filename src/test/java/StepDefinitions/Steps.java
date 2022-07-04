package StepDefinitions;

import GlobalQAPages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Steps {
    WebDriver driver;

    @Given("I navigate to GlobalQa login page and assert I am on that page")
    public void i_navigate_to_global_qa_login_page() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(Constants.FIRST_PAGE_URL));
    }

    @When("I click on Bank Manager Login button and assert that I am redirected correctly")
    public void i_click_on_bank_manager_login_button() {
        LoginPage glp = new LoginPage(driver);
        glp.clickOnBankManagerLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(Constants.MANAGER_PAGE_URL_CONTAINS));
    }

    @When("I click on Add Customer button and assert that I am on the expected page")
    public void i_click_on_add_customer_button() {
        ManagerPage mp = new ManagerPage(driver);
        mp.clickOnAddCustomerButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(Constants.ADDCUST_PAGE_URL_CONTAINS));
    }

    @When("I fill in the customer info, submit it and I assert that alert is displayed")
    public void i_fill_in_the_customer_info_form_to_add_a_new_customer() {
        AddCustPage cp = new AddCustPage(driver);
        cp.addCustomer();
        Assert.assertTrue(driver.switchTo().alert().getText().contains(Constants.ALERT_TEXT_CONTAINS));
    }

    @When("I accept the alert popup and assert that customer creation is completed")
    public void i_accept_the_alert_popup() {
        AddCustPage cp = new AddCustPage(driver);
        cp.acceptAlert();
        Assert.assertTrue(cp.assertField.getText().isEmpty());
    }

    @When("I click Customers button and assert that I am on the expected page")
    public void i_click_customers_button() {
        AddCustPage cp = new AddCustPage(driver);
        cp.clickOnCustomersButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(Constants.LIST_PAGE_URL_CONTAINS));
    }

    @When("I search the customer I added and assert that the customer is filtered")
    public void i_search_the_customer_i_added() {
        CustomersListPage lp = new CustomersListPage(driver);
        lp.searchCustomer(Constants.firstName);
        Assert.assertTrue(lp.assertCustomerIsAdded.getText().contains(Constants.firstName));
    }

    @When("I click Delete button")
    public void i_click_delete_button() {
        CustomersListPage lp = new CustomersListPage(driver);
        lp.deleteCustomer();
    }

    @Then("I assert that the newly added customer is removed")
    public void i_assert_that_the_newly_added_customer_is_removed() {
        CustomersListPage lp = new CustomersListPage(driver);
        Assert.assertTrue(lp.assertCustomerIsRemoved.getText().isEmpty());
    }

    @Before
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}
