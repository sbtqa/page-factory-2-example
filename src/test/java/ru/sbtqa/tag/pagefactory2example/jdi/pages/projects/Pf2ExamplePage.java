package ru.sbtqa.tag.pagefactory2example.jdi.pages.projects;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.JDIPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Page-factory-2 example J")
public class Pf2ExamplePage extends JDIPage {

    @ElementTitle("Select branch")
    @FindBy(xpath = "//div[contains(@class, 'branch-select-menu')]/button")
    public Button selectMenuButton;

    @ElementTitle("for-example")
    @FindBy(xpath = "//span[normalize-space(text())='for-example']")
    public Button branch;

    @ElementTitle("example.txt")
    @FindBy(xpath = "//a[text()='example.txt']")
    public Button example;

    public Pf2ExamplePage(WebDriver driver) {
        super(driver);
    }

    @ActionTitle("выбирает ветку")
    public void selectBranch() {
        selectMenuButton.click();
        branch.click();
    }
}
