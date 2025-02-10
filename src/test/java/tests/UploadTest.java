package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadPage;

import java.nio.file.Paths;

public class UploadTest extends BaseTest {

    @Test
    public void testUploadKarateLogo() {
        driver.get("https://the-internet.herokuapp.com/upload");
        UploadPage uploadPage = new UploadPage(driver);


        String filePath = Paths.get("src/test/resources/karate-logo.png").toAbsolutePath().toString();

        uploadPage.uploadFile(filePath);

        Assert.assertEquals(uploadPage.getUploadedFileName(), "karate-logo.png",
                "Błąd: Plik nie został poprawnie przesłany.");
    }
}
