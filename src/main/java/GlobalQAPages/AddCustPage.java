package GlobalQAPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static GlobalQAPages.Constants.*;

public class AddCustPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

    @FindBy(css = "[ng-model='fName']")
    private WebElement firstNameField;
    @FindBy(css = "[ng-model='lName']")
    private WebElement lastNameField;
    @FindBy(css = "[ng-model='postCd']")
    private WebElement postCodeField;
    @FindBy(css = "[type='submit']")
    private WebElement addCustomerButton;
    @FindBy(css = "[ng-model='fName']")
    public WebElement assertField;
    @FindBy(css = "[ng-class='btnClass3']")
    private WebElement customersButton;
    @FindBy(css = "[class='ng-pristine ng-valid']")
    public WebElement assertSearchField;

    public AddCustPage(WebDriver driver) {
        super(driver);
    }

    public void addCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postCodeField.sendKeys(postCode);
        addCustomerButton.click();
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void clickOnCustomersButton() {
        customersButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[class='ng-pristine ng-valid']")));
    }
}
