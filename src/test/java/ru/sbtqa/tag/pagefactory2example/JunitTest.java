package ru.sbtqa.tag.pagefactory2example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.qameta.allure.Step;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.exceptions.PageInitializationException;
import ru.sbtqa.tag.stepdefs.CoreSetupSteps;
import ru.sbtqa.tag.stepdefs.WebSteps;

public class JunitTest {

    private static WebSteps webSteps;

    @BeforeClass
    public static void before() {
        webSteps = WebSteps.getInstance();
    }

    @Test
    public void webTestTitles() throws PageException, NoSuchMethodException {
        openRepository("page-factory-2-example");
        webSteps.openPage("Page-factory-2 example");
        openBranch("for-example");
        checkFile("example.txt", "Тестовый текст для примера");
      

    }

    @Step("Open repository {name}")
    private void openRepository(String name) throws PageInitializationException, PageException {
        webSteps
            .openPage("Test Automation Gears")
            .fill("Search repositories...", name)
            .click(name);
    }

    @Step("Open branch {name}")
    private void openBranch(String name) throws PageInitializationException, NoSuchMethodException, PageException {
        webSteps
            .action("выбирает ветку", name);
    }

    @Step("Checks example file {name} with text {text}")
    private void checkFile(String name, String text) throws PageInitializationException, PageException {
        webSteps
            .click("example.txt")
            .openPage("Example")
            .checkValueIsEqual("Text", "Тестовый текст для примера");
    }

    @AfterClass
    public static void after() {
        CoreSetupSteps.tearDown();
    }
}
