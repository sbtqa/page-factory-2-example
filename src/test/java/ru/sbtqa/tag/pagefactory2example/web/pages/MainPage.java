package ru.sbtqa.tag.pagefactory2example.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.api.environment.ApiEnvironment;
import ru.sbtqa.tag.api.junit.ApiSteps;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.actions.PageActions;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.web.environment.WebEnvironment;
import ru.sbtqa.tag.pagefactory.web.junit.WebSteps;
import ru.sbtqa.tag.pagefactory2example.rest.GetExampleRepoNameEntry;

@PageEntry(title = "Test Automation Gears")
public class MainPage extends WebPage {

    private static ApiSteps api;
    private static PageActions actions;

    @ElementTitle("Search repositories...")
    @FindBy(id = "your-repos-filter")
    public WebElement reposFilter;

    @ElementTitle("page-factory-2-example")
    @FindBy(xpath = "//a[@href='/sbtqa/page-factory-2-example']")
    public WebElement pageFactory2ExampleLink;

    @ElementTitle("docs")
    @FindBy(xpath = "//a[@href='/sbtqa/page-factory-2-site']")
    public WebElement docsLink;

    public MainPage() {
        api = ApiSteps.getInstance();
        actions = WebEnvironment.getPageActions();
    }

    @ActionTitle("open this example project")
    @ActionTitle("открывает этот проект")
    public void selectBranch() {
        api.send(GetExampleRepoNameEntry.class);
        String name = ApiEnvironment.getRepository().getLast().getResponse().extract().body().path("name");
        actions.fill(reposFilter, name);
        actions.click(pageFactory2ExampleLink);
    }

    @ActionTitle("select repository")
    public MainPage selectRepository(String repoName) throws PageException {
        WebSteps.getInstance()
                .fill("Search repositories...", repoName)
                .click(repoName);
        return this;
    }
}
