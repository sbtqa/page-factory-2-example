package ru.sbtqa.tag.pagefactory2example.web.pages.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.web.junit.WebSteps;

@PageEntry(title = "Example")
public class FilePage extends WebPage {

    @ElementTitle("Text")
    @FindBy(id = "LC1")
    public WebElement textArea;

    public FilePage validateText(String text) throws PageException {
        WebSteps.getInstance().checkValueIsEqual("Text", "Тестовый текст для примера");
        return this;
    }
}
