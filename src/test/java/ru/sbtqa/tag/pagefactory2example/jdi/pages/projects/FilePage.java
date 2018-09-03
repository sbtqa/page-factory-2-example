package ru.sbtqa.tag.pagefactory2example.jdi.pages.projects;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.JDIPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Example J")
public class FilePage extends JDIPage {

    @ElementTitle("Текст")
    @FindBy(id = "LC1")
    public Text textArea;

    public FilePage(WebDriver driver) {
        super(driver);
    }

    @ActionTitle("проверяет текст на соответствие")
    public void selectBranch(String text) {
        Assert.assertEquals("Текст не соответствует ожидаемому", text, textArea.getText());
    }
}
