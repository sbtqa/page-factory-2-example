#language:en
@rest-plugin
Feature: Testing api-services with rest-plugin

  @rest-usual
  Scenario: Normal sending of the request and verification of the answer
    * user sends request for "get description of repo"
    * system returns "description"

  @rest-usual-with-params
  Scenario: Normal sending of the request and checking the response with parameters
    * user sends request for "get description of repo with params" with parameters
      | repo | page-factory-2 |
    * system returns "description" with parameters
      | description | New version of the page-factory framework |

  @rest-fill-from-feature
  Scenario: Filling the request from the feature and sending, checking the answer
    * user fill the request "search repo"
    * user add a query parameter with name "q" and value "sbtqa/page-factory"
    * user add a query parameters
      | sort  | stars |
      | order | asc   |
    * user sends request
    * user validates response

  @rest-fill-from-feature-use-other-response
  Scenario: Filling a request from the feature, when you need to take values from previous requests, sending, checking the answer
    * user sends request for "search this repo on github"
    * user fill the request "search this repo on github через поиск"
    * user add query parameter "q" from response on "search this repo on github" body "full_name" mask "(.*)-example"
    * user sends request
    * user validates response