#language:en
Feature: Example of using multiple plug-ins at the same time

  In this example, four plug-ins were used for one time: rest, web, html and jdi

  @cross
  Scenario: Example of using multiple plug-ins at the same time in the same scenario

    # This page uses the web-plugin
    * user is on the page "Test Automation Gears"

    # In this step, using the rest-plugin, a request is sent to find the name of the project by its id.
    # The found name is substituted into the filter and a click on the filtered project
    * user (open this example project)

    # This page uses the html-plugin
    * user is on the page "Page-factory-2 example HTML"
    * user in block "List of branches" (select testing branch)
    * user clicks the button "example.txt"

    # This page uses jdi-plugin
    * user is on the page "Example JDI"
    * user (check text on equality to) "Тестовый текст для примера"

