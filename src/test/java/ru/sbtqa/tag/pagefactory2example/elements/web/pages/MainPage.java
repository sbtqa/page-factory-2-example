package ru.sbtqa.tag.pagefactory2example.elements.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.WebElementsPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Яндекс Маркет")
public class MainPage extends WebElementsPage {

    @ElementTitle("Строка поиска")
    @FindBy(xpath = "//div[@class='header2__main']//input[@id='header-search']")
    public WebElement searchString;

    public MainPage() {
        PageFactory.initElements(PageFactory.getDriver(), this);
    }
}
