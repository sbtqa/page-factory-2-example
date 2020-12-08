package ru.sbtqa.tag.pagefactory2example.web.pages.wiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.utils.Wait;

import static java.lang.String.format;

@PageEntry(title = "Wiki")
public class WikiPage extends WebPage {

    private static final String XPATH_TEMPLATE = "//li[@class='Box-row']//a[text()='%s']";

    @ElementTitle("Header")
    @FindBy(xpath = "//h1[contains(@class, 'gh-header-title')]")
    public WebElement header;

    @ActionTitle("нажимает на ссылку раздела")
    @ActionTitle("click on section link")
    public void openSection(String name) {
        String xpath = format(XPATH_TEMPLATE, name);
        Wait.presence(xpath, "Could not get Fragments link on wiki menu");
        WebElement section = Environment.getDriverService().getDriver().findElement(By.xpath(xpath));
        Environment.getPageActions().click(section);
    }
}
