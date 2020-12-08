package ru.sbtqa.tag.pagefactory2example.html.blocks;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//details[@id='branch-select-menu']")
public class BranchMenuBlock extends HtmlElement {

    @FindBy(xpath = "./summary")
    public Button openBranchMenu;

    @FindBy(xpath = ".//span[normalize-space(text())='for-example']")
    public Button branch;

    @ActionTitle("выбирает тестовую ветку")
    @ActionTitle("select testing branch")
    public void selectTestBranch() {
        openBranchMenu.click();
        branch.click();
    }
}
