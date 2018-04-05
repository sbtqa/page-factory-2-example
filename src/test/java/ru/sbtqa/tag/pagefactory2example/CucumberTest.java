package ru.sbtqa.tag.pagefactory2example;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import ru.sbtqa.tag.cucumber.TagCucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, format = {"pretty"},
        glue = {"ru.sbtqa.tag.pagefactory.stepdefs",
            "ru.sbtqa.tag.pagefactory.htmlstepdefs",
            "ru.sbtqa.tag.pagefactory2example.stepdefs",
            "ru.sbtqa.tag.pagefactory2example.elements.jdi.stepdefs"},
        features = {"src/test/resources/features/"}
//        , tags = {"@web-elements"}
)

public class CucumberTest {}