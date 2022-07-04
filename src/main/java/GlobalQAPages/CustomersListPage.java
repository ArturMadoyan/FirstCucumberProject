package GlobalQAPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CustomersListPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

    @FindBy(css = "tbody>tr")
    public WebElement assertCustomerIsAdded;
    @FindBy(css = "tbody")
    public WebElement assertCustomerIsRemoved;
    @FindBy(css = "[ng-model='searchCustomer']")
    private WebElement searchField;
    @FindBy(css = "[ng-click='deleteCust(cust)']")
    private WebElement deleteButton;

    public CustomersListPage(WebDriver driver) {
        super(driver);
    }

    public void searchCustomer(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-model='searchCustomer']")));
        searchField.sendKeys(name);
    }

    public void deleteCustomer() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody>tr"), 1));
        deleteButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("tbody>tr")));
    }
}
