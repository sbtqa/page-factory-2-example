#language:en
@web-plugin
Feature: Example of using web-plugin

  @web
  Scenario: Example of using web-plugin
    * user is on the page "Test Automation Gears"
    * user (fill the field) "Search repositories..." "page-factory-2-example"
    * user (click the link) "page-factory-2-example"
    * user is on the page "Page-factory-2 example"
    * user (select branch) "for-example"
    * user (click the link) "example.txt"
    * user is on the page "Example"
    * user (checks value) "Text" "Тестовый текст для примера"