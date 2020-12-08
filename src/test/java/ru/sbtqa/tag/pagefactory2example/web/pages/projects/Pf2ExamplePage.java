package ru.sbtqa.tag.pagefactory2example.web.pages.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.reflection.DefaultReflection;
import ru.sbtqa.tag.pagefactory.web.junit.WebSteps;

@PageEntry(title = "Page-factory-2 example")
public class Pf2ExamplePage extends WebPage {

    @ElementTitle("Select branch")
    @FindBy(xpath = "//details[contains(@id, 'branch-select-menu')]/summary")
    public WebElement selectMenuButton;

    @ElementTitle("for-example")
    @FindBy(xpath = "//span[normalize-space(text())='for-example']")
    public WebElement testBranch;

    @ElementTitle("example.txt")
    @FindBy(xpath = "//a[text()='example.txt']")
    public WebElement example;

    @ActionTitle("выбирает ветку")
    @ActionTitle("select branch")
    public Pf2ExamplePage selectBranch(String name) throws PageException {
        Environment.getPageActions().click(selectMenuButton);
        WebElement branch = new DefaultReflection().getElementByTitle(this, name);
        Environment.getPageActions().click(branch);
        return this;
    }

    @ActionTitle("открывает файл")
    public Pf2ExamplePage openFile(String fileName) throws PageException {
        WebSteps.getInstance().click("example.txt");
        return this;
    }
}
