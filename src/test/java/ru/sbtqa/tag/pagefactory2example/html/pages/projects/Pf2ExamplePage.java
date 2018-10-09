package ru.sbtqa.tag.pagefactory2example.html.pages.projects;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory2example.html.blocks.BranchMenuBlock;
import ru.yandex.qatools.htmlelements.element.Link;

@PageEntry(title = "Page-factory-2 example HTML")
public class Pf2ExamplePage extends HTMLPage {

    @ElementTitle("List of branches")
    public BranchMenuBlock branchMenuBlock;

    @ElementTitle("example.txt")
    @FindBy(xpath = "//a[text()='example.txt']")
    public Link example;
}
