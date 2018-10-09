package ru.sbtqa.tag.pagefactory2example.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "docs")
public class DocsPage extends WebPage {

    @ElementTitle("Wiki")
    @FindBy(xpath = "//a[@href='/sbtqa/docs/wiki']")
    public WebElement wiki;
}
