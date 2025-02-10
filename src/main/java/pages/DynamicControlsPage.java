package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage {
    private WebDriver driver;
    private By checkbox = By.id("checkbox");
    private By removeButton = By.cssSelector("#checkbox-example button");
    private By message = By.id("message");

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeCheckbox() {
        driver.findElement(removeButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
    }

    public boolean isCheckboxDisplayed() {
        try {
            return driver.findElement(checkbox).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getMessage() {
        return driver.findElement(message).getText();
    }
}
