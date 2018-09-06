package ru.sbtqa.tag.pagefactory2example.jdi.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.JDIPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Test Automation Gears JDI")
public class MainPage extends JDIPage {

    @ElementTitle("Search repositories...")
    @FindBy(id = "your-repos-filter")
    public Input reposFilter;

    @ElementTitle("page-factory-2-example")
    @FindBy(xpath = "//a[@href='/sbtqa/page-factory-2-example']")
    public Button pageFactory2ExampleLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
