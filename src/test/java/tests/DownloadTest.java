package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DownloadPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class DownloadTest extends BaseTest {

    @Test
    public void testDownloadResumePDF() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        DownloadPage downloadPage = new DownloadPage(driver);


        downloadPage.downloadFile();


        String home = System.getProperty("user.home");
        String downloadDir = Paths.get(home, "Downloads").toString();
        String fileName = "Resume.pdf";
        Path filePath = Paths.get(downloadDir, fileName);


        boolean isDownloaded = false;
        int attempts = 0;
        while (attempts < 10) { // Max 10 prób (ok. 10 sekund)
            if (Files.exists(filePath)) {
                isDownloaded = true;
                break;
            }
            TimeUnit.SECONDS.sleep(1);
            attempts++;
        }

        Assert.assertTrue(isDownloaded, "Błąd: Plik Resume.pdf nie został pobrany.");

        // usunięcie pliku po teście
        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Błąd: Nie udało się usunąć pobranego pliku.");
        }
    }
}
