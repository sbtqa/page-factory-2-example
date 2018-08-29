package ru.sbtqa.tag.pagefactory2example.rest;

import cucumber.api.DataTable;
import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.api.Rest;
import ru.sbtqa.tag.api.annotation.Endpoint;
import ru.sbtqa.tag.api.annotation.Validation;

import static org.hamcrest.Matchers.equalTo;
import static ru.sbtqa.tag.api.utils.CastUtils.toMap;

// TODO схлопнуть все get после query applicator
@Endpoint(method = Rest.GET, path = "search/repositories", title = "найти этот проект на гитхаб через поиск")
public class FillFromFeatureSecondEntry extends EndpointEntry {

    @Validation(title = "validate")
    public void validate(DataTable dataTable) {
        String description = toMap(dataTable).get("description");

        getResponse().body("description", equalTo(description));
    }

    @Validation(title = "проект")
    public void validate() {
        getResponse().body("total_count", equalTo(2));
    }
}
