package ru.sbtqa.tag.pagefactory2example.rest;

import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.pagefactory.Rest;
import ru.sbtqa.tag.pagefactory.annotations.rest.Endpoint;
import ru.sbtqa.tag.api.annotation.Validation;

import static org.hamcrest.Matchers.equalTo;

@Endpoint(method = Rest.GET, path = "repos/sbtqa/page-factory-2", title = "get description of repo")
public class UsualEntry extends EndpointEntry {

    @Validation(title = "description")
    public void validate() {
        getResponse().body("description", equalTo("Page factory framework for java test automation. Web/API/Mobile"));
    }
}
