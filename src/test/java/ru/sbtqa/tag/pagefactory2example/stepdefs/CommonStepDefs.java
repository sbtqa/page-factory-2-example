package ru.sbtqa.tag.pagefactory2example.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.runtime.junit.ExecutionUnitRunner;
import cucumber.runtime.junit.JUnitReporter;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.CucumberScenario;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Locale;

public class CommonStepDefs {
    // Добавьте сюда необходимые Вам шаги

    @Before(order = 1)
    public void before(Scenario scenario) throws IllegalAccessException {
        System.out.println(FieldUtils.getAllFields(scenario.getClass()).length);

        for (Field field : FieldUtils.getAllFields(scenario.getClass())) {
            System.out.println("ASD = " + field.getName());
        }

        System.out.println(FieldUtils.getField(scenario.getClass(), "reporter", true).get(scenario));

        pullLocaleFromScenario(scenario);
    }

    private Locale pullLocaleFromScenario(Scenario scenario) {
        CucumberFeature cucumberFeature = null;
        try {
            System.out.println(FieldUtils.getField(scenario.getClass(), "reporter", true).get(scenario));
//            JUnitReporter reporter = (JUnitReporter) FieldUtils.getDeclaredField(scenario.getClass(), "reporter", true).get(scenario);
//            ExecutionUnitRunner executionUnitRunner = (ExecutionUnitRunner) FieldUtils.getDeclaredField(reporter.getClass(), "executionUnitRunner", true).get(reporter);
//            CucumberScenario cucumberScenario = (CucumberScenario) FieldUtils.getDeclaredField(executionUnitRunner.getClass(), "cucumberScenario", true).get(executionUnitRunner);
//            cucumberFeature = (CucumberFeature) FieldUtils.getField(cucumberScenario.getClass(), "cucumberFeature", true).get(cucumberScenario);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

//        return cucumberFeature.getI18n().getLocale();
        return null;
    }
}
