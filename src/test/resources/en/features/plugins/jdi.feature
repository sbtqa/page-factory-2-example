#language:en
@jdi-plugin
Feature: Example of using jdi-plugin

  @jdi
  Scenario: Example of using jdi-plugin
    * user is on the page "Test Automation Gears JDI"
    * user fills the field "Search repositories..." with value "page-factory-2-example"
    * user clicks the button "page-factory-2-example"
    * user is on the page "Page-factory-2 example JDI"
    * user (select branch)
    * user clicks the button "example.txt"
    * user is on the page "Example JDI"
    * user (check text on equality to) "Тестовый текст для примера"