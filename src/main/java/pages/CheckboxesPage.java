package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckboxesPage {
    private WebDriver driver;
    private By checkboxes = By.cssSelector("input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void toggleCheckbox(int index) {
        List<WebElement> checkboxList = driver.findElements(checkboxes);
        if (index >= 0 && index < checkboxList.size()) {
            checkboxList.get(index).click();
        }
    }

    public boolean isCheckboxSelected(int index) {
        List<WebElement> checkboxList = driver.findElements(checkboxes);
        return index >= 0 && index < checkboxList.size() && checkboxList.get(index).isSelected();
    }
}
