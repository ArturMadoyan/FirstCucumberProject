package GlobalQAPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

    @FindBy(css = "[ng-class='btnClass1']")
    private WebElement addCustomer;

    public ManagerPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddCustomerButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[ng-class='btnClass1']")));
        addCustomer.click();
        wait.until(ExpectedConditions.urlContains("addCust"));
    }
}
