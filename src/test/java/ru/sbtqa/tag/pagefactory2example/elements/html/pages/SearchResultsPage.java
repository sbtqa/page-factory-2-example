package ru.sbtqa.tag.pagefactory2example.elements.html.pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory2example.elements.html.blocks.HeaderBlock;
import ru.sbtqa.tag.pagefactory2example.elements.html.blocks.ProductCard;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Результаты поиска товаров H")
public class SearchResultsPage extends HTMLPage {

    private HeaderBlock headerBlock;

    @ElementTitle("Список товаров")
    @FindBy(xpath = "//div[contains(@class,'n-snippet-card2 i-bem')]")
    private List<ProductCard> productCards;

    public SearchResultsPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

    @ActionTitle("проверяет присутствие продукта")
    public void compareProductCost(String productName) {
        for (ProductCard card : productCards) {
            if (productName.toLowerCase().equals(card.getProductName().toLowerCase())) {
                return;
            }
        }

        Assert.fail("Продукт " + productName + " не был найден");
    }
}
