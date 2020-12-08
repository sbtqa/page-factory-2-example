package ru.sbtqa.tag.pagefactory2example.rest;

import org.junit.Assert;
import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.api.annotation.Validation;
import ru.sbtqa.tag.pagefactory.Rest;
import ru.sbtqa.tag.pagefactory.annotations.rest.Endpoint;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;

@Endpoint(method = Rest.GET, path = "search/repositories", title = "search repo")
public class FillFromFeatureEntry extends EndpointEntry {

    @Validation(title = "validate")
    public void validate() {
        getResponse().body("total_count", greaterThan(4));
        List<String> repos = getResponse().extract().body().jsonPath().get("items.name");
        Assert.assertTrue(
                repos.containsAll(Arrays.asList(
                        "page-factory-2",
                        "page-factory",
                        "page-factory-2-example",
                        "page-factory-2-site",
                        "page-factory-example"
                )));

    }
}