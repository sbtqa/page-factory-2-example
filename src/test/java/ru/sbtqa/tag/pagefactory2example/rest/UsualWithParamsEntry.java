package ru.sbtqa.tag.pagefactory2example.rest;

import io.cucumber.datatable.DataTable;
import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.pagefactory.Rest;
import ru.sbtqa.tag.pagefactory.annotations.rest.Endpoint;
import ru.sbtqa.tag.api.annotation.Query;
import ru.sbtqa.tag.api.annotation.Validation;

import static org.hamcrest.Matchers.equalTo;
import static ru.sbtqa.tag.api.utils.CastUtils.toMap;

@Endpoint(method = Rest.GET, path = "repos/sbtqa/${repo}", title = "get description of repo with params")
public class UsualWithParamsEntry extends EndpointEntry {

    @Query(name = "repo")
    private String repo;

    @Validation(title = "description")
    public void validate(DataTable dataTable) {
        String description = toMap(dataTable).get("description");

        getResponse().body("description", equalTo(description));
    }
}
