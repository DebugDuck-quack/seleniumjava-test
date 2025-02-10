package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void testCheckboxSelection() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);

        checkboxesPage.toggleCheckbox(0);
        Assert.assertTrue(checkboxesPage.isCheckboxSelected(0), "Checkbox 1 nie został zaznaczony.");

        checkboxesPage.toggleCheckbox(1);
        Assert.assertFalse(checkboxesPage.isCheckboxSelected(1), "Checkbox 2 powinien być odznaczony.");
    }
}
