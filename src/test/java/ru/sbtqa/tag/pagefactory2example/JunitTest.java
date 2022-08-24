package ru.sbtqa.tag.pagefactory2example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.junit.CoreSetupSteps;
import ru.sbtqa.tag.pagefactory.web.junit.WebSteps;
import ru.sbtqa.tag.pagefactory2example.web.pages.MainPage;
import ru.sbtqa.tag.pagefactory2example.web.pages.projects.FilePage;
import ru.sbtqa.tag.pagefactory2example.web.pages.projects.Pf2ExamplePage;


public class JunitTest {

    @Before
    public void before() {
        CoreSetupSteps.preSetUp();
        CoreSetupSteps.setUp();
    }

    private WebSteps steps() {
        return WebSteps.getInstance();
    }

    @Test
    public void webTestTitles() throws PageException {
        steps().openPage(MainPage.class)
                .selectRepository("page-factory-2-example");
        steps().openPage(Pf2ExamplePage.class)
                .selectBranch("for-example")
                .openFile("example.txt");
        steps().openPage(FilePage.class)
                .validateText("Тестовый текст для примера");
    }
    @Test
    public void webTestTitles2() throws PageException {
        steps().openPage(MainPage.class)
                .selectRepository("page-factory-2-example");
        steps().openPage(Pf2ExamplePage.class)
                .selectBranch("for-example")
                .openFile("example.txt");
        steps().openPage(FilePage.class)
                .validateText("Тестовый текст для примера");
    }

    @Test
    public void webTestTitles3() throws PageException {
        steps().openPage(MainPage.class)
                .selectRepository("page-factory-2-example");
        steps().openPage(Pf2ExamplePage.class)
                .selectBranch("for-example")
                .openFile("example.txt");
        steps().openPage(FilePage.class)
                .validateText("Тестовый текст для примера");
    }

    @Test
    public void webTestTitles4() throws PageException {
        steps().openPage(MainPage.class)
                .selectRepository("page-factory-2-example");
        steps().openPage(Pf2ExamplePage.class)
                .selectBranch("for-example")
                .openFile("example.txt");
        steps().openPage(FilePage.class)
                .validateText("Тестовый текст для примера");
    }

    @After
    public void after() {
        CoreSetupSteps.tearDown();
    }
}
