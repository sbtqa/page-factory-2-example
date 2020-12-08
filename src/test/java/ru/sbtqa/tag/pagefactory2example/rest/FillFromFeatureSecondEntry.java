package ru.sbtqa.tag.pagefactory2example.rest;

import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.pagefactory.Rest;
import ru.sbtqa.tag.pagefactory.annotations.rest.Endpoint;
import ru.sbtqa.tag.api.annotation.Validation;

import static org.hamcrest.Matchers.greaterThan;

@Endpoint(method = Rest.GET, path = "search/repositories", title = "search this repo on github через поиск")
public class FillFromFeatureSecondEntry extends EndpointEntry {

    @Validation(title = "total projects count")
    public void validate() {
        getResponse().body("total_count", greaterThan(3));
    }
}
