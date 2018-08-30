package ru.sbtqa.tag.pagefactory2example.elements.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Test Automation Gears")
public class TagPage extends WebPage {

    @ElementTitle("Search repositories...")
    @FindBy(id = "your-repos-filter")
    public WebElement reposFilter;

    @ElementTitle("page-factory-2-example")
    @FindBy(xpath = "//a[@href='/sbtqa/page-factory-2-example']")
    public WebElement projectLink;

    public TagPage(WebDriver driver) {
        super(driver);
    }
}
