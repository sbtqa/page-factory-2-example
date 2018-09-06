package ru.sbtqa.tag.pagefactory2example.web.pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Example")
public class FilePage extends WebPage {

    @ElementTitle("Text")
    @FindBy(id = "LC1")
    public WebElement textArea;

    public FilePage(WebDriver driver) {
        super(driver);
    }
}
