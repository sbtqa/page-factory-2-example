package ru.sbtqa.tag.pagefactory2example.web.pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;

@PageEntry(title = "Page-factory-2 example")
public class Pf2ExamplePage extends WebPage {

    @ElementTitle("Select branch")
    @FindBy(xpath = "//div[contains(@class, 'branch-select-menu')]/button")
    public WebElement selectMenuButton;

    @ElementTitle("for-example")
    @FindBy(xpath = "//span[normalize-space(text())='for-example']")
    public WebElement branch;

    @ElementTitle("example.txt")
    @FindBy(xpath = "//a[text()='example.txt']")
    public WebElement example;

    public Pf2ExamplePage(WebDriver driver) {
        super(driver);
    }

    @ActionTitle("select branch")
    public void selectBranch(String name) throws PageException {
        click("Select branch");
        click(name);
    }
}
