#language:en
@fragments
Feature: Example of using fragments

  @fragment-datatable
  Scenario: Example of using fragments with params
    * user is on the page "Test Automation Gears"
    * user inserts fragment "Open doc section"
      | section   |
      | Fragments |
    * user checks in the element "Header" value "Fragments"

  @fragment-outline
  Scenario Outline: Example of using fragments with params in scenario outlines
    * user is on the page "Test Automation Gears"
    * user inserts fragment "Open doc section"
      | section   |
      | <section> |
    * user checks in the element "Header" value "<section>"

    Examples:
      | section   |
      | Fragments |
      | Pages     |

  @fragment-without-params
  Scenario: Example of using fragments without params
    * user is on the page "Test Automation Gears"
    * user inserts fragment "First level fragment"
    * user checks in the element "Search repositories..." value "Second level fragment text"