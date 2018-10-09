package ru.sbtqa.tag.pagefactory2example.html.pages.projects;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@PageEntry(title = "Example HTML")
public class FilePage extends HTMLPage {

    @ElementTitle("Text")
    @FindBy(id = "LC1")
    public TextBlock textArea;
}
