package ru.sbtqa.tag.pagefactory2example.web.pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.Environment;

import static java.lang.String.format;

@PageEntry(title = "Wiki")
// TODO перенести в свой package
public class WikiPage extends WebPage {

    private static final String XPATH_TEMPLATE = "//div[@class='gollum-markdown-content']//a[text()='%s']";

    @ElementTitle("Заголовок")
    @FindBy(xpath = "//h1[contains(@class, 'gh-header-title')]")
    public WebElement header;

    public WikiPage(WebDriver driver) {
        super(driver);
    }

    @ActionTitle("кликает по ссылке раздела")
    public void openSection(String name) {
        String xpath = format(XPATH_TEMPLATE, name);
        WebElement section = getDriver().findElement(By.xpath(xpath));
        Environment.getPageActions().click(section);
    }
}