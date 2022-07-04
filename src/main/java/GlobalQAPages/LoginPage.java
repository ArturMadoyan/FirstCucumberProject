package GlobalQAPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

    @FindBy(css = "[ng-click='manager()']")
    private WebElement bankManagerLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBankManagerLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[ng-click='manager()']")));
        bankManagerLogin.click();
        wait.until(ExpectedConditions.urlContains("manager"));
    }
}
