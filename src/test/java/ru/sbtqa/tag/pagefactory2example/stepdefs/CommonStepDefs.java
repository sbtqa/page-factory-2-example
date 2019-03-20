package ru.sbtqa.tag.pagefactory2example.stepdefs;

import cucumber.api.java.After;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import ru.sbtqa.tag.api.annotation.ParameterType;
import ru.sbtqa.tag.api.environment.ApiEnvironment;
import ru.sbtqa.tag.api.junit.ApiSteps;
import ru.sbtqa.tag.api.storage.BlankStorage;
import ru.sbtqa.tag.api.storage.EndpointBlank;

import java.util.List;
import java.util.Random;

public class CommonStepDefs {
    // add your stepdefs here

    @After
    public void tearDown() throws IllegalAccessException {
        String query = "" + new Random().ints().iterator().nextInt();
        BlankStorage blankStorage = ApiEnvironment.getBlankStorage();
        List<EndpointBlank> blanks = (List<EndpointBlank>) FieldUtils.readDeclaredField(blankStorage, "blanks", true);

        long qCount = blanks.stream().filter(endpointBlank -> endpointBlank.getQueries().containsKey("q")).count();

        Assert.assertEquals("No endpoint from previous scenario expected", 0, qCount);

        ApiSteps.getInstance().
                fill("search repo").add(ParameterType.QUERY, "q", query).
                send();

    }
}
