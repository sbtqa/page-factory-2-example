package ru.sbtqa.tag.pagefactory2example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.junit.CoreSetupSteps;
import ru.sbtqa.tag.pagefactory.web.junit.WebSteps;


public class JunitTest {

    private static WebSteps webSteps;

    @BeforeClass
    public static void before() {
        webSteps = WebSteps.getInstance();
    }

    @Test
    public void webTestTitles() throws PageException, NoSuchMethodException {
        webSteps.openPage("Test Automation Gears")
                .fill("Search repositories...", "page-factory-2-example")
                .click("page-factory-2-example")
                .openPage("Page-factory-2 example")
                .action("выбирает ветку", "for-example")
                .click("example.txt")
                .openPage("Example")
                .checkValueIsEqual("Text", "Тестовый текст для примера");
    }

    @AfterClass
    public static void after() {
        CoreSetupSteps.tearDown();
    }
}
