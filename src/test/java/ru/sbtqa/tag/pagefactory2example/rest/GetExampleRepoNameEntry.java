package ru.sbtqa.tag.pagefactory2example.rest;

import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.api.Rest;
import ru.sbtqa.tag.api.annotation.Endpoint;
import ru.sbtqa.tag.api.annotation.Query;

@Endpoint(method = Rest.GET, path = "repositories/${id}", title = "search repo by id")
public class GetExampleRepoNameEntry extends EndpointEntry {

    @Query(name = "id")
    private String id = "118105722";
}