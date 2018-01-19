package ru.sbtqa.tag.pagefactory2example.elements.jdi.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Input;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Яндекс Маркет J")
public class MainPage extends AbstractJDIPage {

    @ElementTitle("Строка поиска")
    @FindBy(xpath = "//div[@class='header2__main']//input[@id='header-search']")
    public Input searchString;

    @ElementTitle("Найти")
    @FindBy(xpath = "//div[@class='header2__main']//span[text()='Найти']")
    public Button searchButton;

    @ElementTitle("Первый пункт предложки")
    @FindBy(xpath = "//ul[@class='suggest2__items']/li[1]")
    public Button firstOffer;

}
