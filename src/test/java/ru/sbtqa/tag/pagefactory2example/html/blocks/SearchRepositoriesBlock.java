package ru.sbtqa.tag.pagefactory2example.html.blocks;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//form[@data-autosearch-results-container='org-repositories']")
public class SearchRepositoriesBlock extends HtmlElement {

    @FindBy(xpath = ".//input[@id='your-repos-filter']")
    public TextInput searchInput;

    @FindBy(xpath = ".//div[contains(@class, 'ml-2')]/button")
    public Button type;

    @FindBy(xpath = ".//div[contains(@class, 'ml-1')]/button")
    public Button language;

    @ActionTitle("ищет репозиторий")
    @ActionTitle("search repo")
    public void selectTestBranch(String name) {
        searchInput.sendKeys(name);
    }
}
