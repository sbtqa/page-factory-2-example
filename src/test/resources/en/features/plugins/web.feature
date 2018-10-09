#language:en
@web-plugin
Feature: Example of using web-plugin

  @web
  Scenario: Example of using web-plugin
    * user is on the page "Test Automation Gears"
    * user fills the field "Search repositories..." with value "page-factory-2-example"
    * user clicks the link "page-factory-2-example"
    * user is on the page "Page-factory-2 example"
    * user (select branch) "for-example"
    * user clicks the link "example.txt"
    * user is on the page "Example"
    * user checks in the element "Text" value "Тестовый текст для примера"