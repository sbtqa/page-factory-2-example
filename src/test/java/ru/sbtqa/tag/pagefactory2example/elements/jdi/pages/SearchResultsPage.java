package ru.sbtqa.tag.pagefactory2example.elements.jdi.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.JDIPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Результаты поиска товаров J")
public class SearchResultsPage extends JDIPage {

    @ElementTitle("Список товаров")
    @FindBy(xpath = "//div[contains(@class,'n-snippet-card2 i-bem')]//div[@class='n-snippet-card2__title']//a")
    private List<Text> productCards;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @ActionTitle("проверяет присутствие продукта")
    public void compareProductCost(String productName) {
        for (Text name : productCards) {
            if (productName.toLowerCase().equals(name.getText().toLowerCase())) {
                return;
            }
        }

        Assert.fail("Продукт " + productName + " не был найден");

    }
}
