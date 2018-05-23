package ru.sbtqa.tag.pagefactory2example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, format = {"pretty"},
        glue = {"ru.sbtqa.tag.stepdefs",
            "ru.sbtqa.tag.pagefactory2example.stepdefs",
            "ru.sbtqa.tag.pagefactory2example.elements.jdi.stepdefs"},
        features = {"src/test/resources/features/"}
)

public class CucumberTest {}