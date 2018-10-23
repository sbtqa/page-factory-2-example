package ru.sbtqa.tag.pagefactory2example.html.pages;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory2example.html.blocks.SearchRepositoriesBlock;
import ru.yandex.qatools.htmlelements.element.Link;

@PageEntry(title = "Test Automation Gears HTML")
public class MainPage extends HTMLPage {

    @ElementTitle("List of repos")
    public SearchRepositoriesBlock searchRepositoriesBlock;

    @ElementTitle("page-factory-2-example")
    @FindBy(xpath = "//a[@href='/sbtqa/page-factory-2-example']")
    public Link pageFactory2ExampleLink;
}
