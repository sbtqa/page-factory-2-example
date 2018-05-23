package ru.sbtqa.tag.pagefactory2example.elements.html.pages;

import org.openqa.selenium.WebDriver;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory2example.elements.html.blocks.HeaderBlock;

@PageEntry(title = "Яндекс Маркет H")
public class MainPage extends HTMLPage {

    @ElementTitle("Меню поиска")
    public HeaderBlock headerBlock;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}