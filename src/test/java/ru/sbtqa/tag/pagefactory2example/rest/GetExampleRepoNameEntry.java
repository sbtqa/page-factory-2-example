package ru.sbtqa.tag.pagefactory2example.rest;

import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.api.annotation.Query;
import ru.sbtqa.tag.pagefactory.Rest;
import ru.sbtqa.tag.pagefactory.annotations.rest.Endpoint;

@Endpoint(method = Rest.GET, path = "repositories/${id}", title = "search repo by id")
public class GetExampleRepoNameEntry extends EndpointEntry {

    @Query(name = "id")
    private String id = "118105722";
}