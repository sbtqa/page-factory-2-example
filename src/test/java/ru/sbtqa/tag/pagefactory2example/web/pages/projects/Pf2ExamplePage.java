package ru.sbtqa.tag.pagefactory2example.web.pages.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.utils.ReflectionUtils;

@PageEntry(title = "Page-factory-2 example")
public class Pf2ExamplePage extends WebPage {

    @ElementTitle("Select branch")
    @FindBy(xpath = "//div[contains(@class, 'branch-select-menu')]/button")
    public WebElement selectMenuButton;

    @ElementTitle("for-example")
    @FindBy(xpath = "//span[normalize-space(text())='for-example']")
    public WebElement testBranch;

    @ElementTitle("example.txt")
    @FindBy(xpath = "//a[text()='example.txt']")
    public WebElement example;

    @ActionTitle("выбирает ветку")
    @ActionTitle("select branch")
    public void selectBranch(String name) throws PageException {
        Environment.getPageActions().click(selectMenuButton);
        WebElement branch = ReflectionUtils.getElementByTitle(this, name);
        Environment.getPageActions().click(branch);
    }
}
