package ru.sbtqa.tag.pagefactory2example.rest;

import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.api.Rest;
import ru.sbtqa.tag.api.annotation.Endpoint;
import ru.sbtqa.tag.api.annotation.Validation;

import static org.hamcrest.Matchers.equalTo;

@Endpoint(method = Rest.GET, path = "search/repositories", title = "поиск репозиториев")
public class FillFromFeatureEntry extends EndpointEntry {

    @Validation(title = "validate")
    public void validate() {
        getResponse().body("total_count", equalTo(4));

        getResponse()
                .body("items[0].name", equalTo("page-factory-2-example"))
                .body("items[1].name", equalTo("page-factory-2"))
                .body("items[2].name", equalTo("page-factory-example"))
                .body("items[3].name", equalTo("page-factory"));
    }
}