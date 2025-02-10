package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void testRemoveCheckbox() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);

        dynamicControlsPage.removeCheckbox();
        Assert.assertFalse(dynamicControlsPage.isCheckboxDisplayed(), "Checkbox powinien zostać usunięty.");
    }
}
