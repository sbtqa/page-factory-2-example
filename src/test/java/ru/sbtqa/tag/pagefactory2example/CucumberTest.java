package ru.sbtqa.tag.pagefactory2example;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
//@CucumberOptions(monochrome = true, format = {"pretty"},
//        glue = {"ru.sbtqa.tag.pagefactory.stepdefs",
//            "ru.sbtqa.tag.pagefactory.htmlstepdefs",
//            "ru.sbtqa.tag.pagefactory2example.stepdefs",
//            "ru.sbtqa.tag.pagefactory2example.elements.jdi.stepdefs"},
//        features = {"src/test/resources/features/"}
////        ,tags = {"@web-elements"}
//)

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 1,
        runLevel = CourgetteRunLevel.FEATURE,
        rerunFailedScenarios = false,
        showTestOutput = true,
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features/",
                glue = {"ru.sbtqa.tag.pagefactory.stepdefs",
                        "ru.sbtqa.tag.pagefactory2example.stepdefs",
                        "ru.sbtqa.tag.pagefactory.htmlstepdefs",
                        "ru.sbtqa.tag.pagefactory2example.elements.jdi.stepdefs"},
                tags = {"@web-elements"},
                plugin = {
                        "pretty",
                        "json:target/cucumber-report/cucumber.json",
                        "html:target/cucumber-report/cucumber.html"},
                strict = true
        ))
public class CucumberTest {
}