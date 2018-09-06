#language:en
@html-plugin
Feature: Example of using html-plugin

  @html
  Scenario: Example of using html-plugin
    * user is on the page "Test Automation Gears HTML"
    * user in block "List of repos" (search repo) with a parameter "page-factory-2-example"
    * user (click the button) "page-factory-2-example"
    * user is on the page "Page-factory-2 example HTML"
    * user in block "List of branches" (select testing branch)
    * user (click the button) "example.txt"
    * user is on the page "Example HTML"
    * user (checks value) "Text" "Тестовый текст для примера"