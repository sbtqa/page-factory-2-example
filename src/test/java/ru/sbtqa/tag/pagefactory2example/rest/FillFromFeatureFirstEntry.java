package ru.sbtqa.tag.pagefactory2example.rest;

import cucumber.api.DataTable;
import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.api.Rest;
import ru.sbtqa.tag.api.annotation.Endpoint;
import ru.sbtqa.tag.api.annotation.Validation;

import static org.hamcrest.Matchers.equalTo;
import static ru.sbtqa.tag.api.utils.CastUtils.toMap;

// TODO схлопнуть все get после query applicator
@Endpoint(method = Rest.GET, path = "repos/sbtqa/page-factory-2-example", title = "найти этот проект на гитхаб")
public class FillFromFeatureFirstEntry extends EndpointEntry {

    @Validation(title = "описание")
    public void validate(DataTable dataTable) {
        String description = toMap(dataTable).get("description");

        getResponse().body("description", equalTo(description));
    }
}
