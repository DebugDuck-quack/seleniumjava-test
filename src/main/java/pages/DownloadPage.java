package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadPage {
    private WebDriver driver;
    private By downloadLink = By.linkText("Resume.pdf");

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void downloadFile() {
        WebElement link = driver.findElement(downloadLink);

        // klikamy w link za pomocą JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    public boolean isFileDownloaded(String downloadDir, String fileName) {
        Path filePath = Paths.get(downloadDir, fileName);
        return Files.exists(filePath);
    }
}
