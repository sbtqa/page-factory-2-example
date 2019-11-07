package ru.sbtqa.tag.pagefactory2example.rest;

import io.cucumber.datatable.DataTable;
import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.pagefactory.Rest;
import ru.sbtqa.tag.pagefactory.annotations.rest.Endpoint;
import ru.sbtqa.tag.api.annotation.Validation;

import static org.hamcrest.Matchers.equalTo;
import static ru.sbtqa.tag.api.utils.CastUtils.toMap;

@Endpoint(method = Rest.GET, path = "repos/sbtqa/page-factory-2-example", title = "search this repo on github")
public class FillFromFeatureFirstEntry extends EndpointEntry {

    @Validation(title = "description")
    public void validate(DataTable dataTable) {
        String description = toMap(dataTable).get("description");

        getResponse().body("description", equalTo(description));
    }
}
