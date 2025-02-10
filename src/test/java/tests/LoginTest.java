package tests;

import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area!"),
                "Błąd: nie zalogowano poprawnie.");
    }
}
