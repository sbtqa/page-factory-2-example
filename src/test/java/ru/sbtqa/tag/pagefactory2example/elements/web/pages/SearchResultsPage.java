package ru.sbtqa.tag.pagefactory2example.elements.web.pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Результаты поиска товаров")
public class SearchResultsPage extends WebPage {

    @ElementTitle("Список товаров")
    @FindBy(xpath = "//div[contains(@class,'n-snippet-card2 i-bem')]//div[@class='n-snippet-card2__title']//a")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[@class='layout layout_type_maya']")
    private WebElement container;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @ActionTitle("проверяет присутствие продукта")
    public void compareProductCost(String productName) {
        for (WebElement name : productCards) {
            if (productName.toLowerCase().equals(name.getText().toLowerCase())) {
                return;
            }
        }

        Assert.fail("Продукт " + productName + " не был найден");

    }
}
