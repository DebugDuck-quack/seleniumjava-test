package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        dragAndDropPage.dragAtoB();
        Assert.assertEquals(dragAndDropPage.getColumnAText(), "B", "Element A nie został przeniesiony do B.");
    }
}
