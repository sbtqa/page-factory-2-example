#language:en
Feature: Open doc section

  @fragment
  Scenario: Open doc section
    * user clicks the link "docs"
    * user is on the page "docs"
    * user clicks the link "Wiki"
    * user is on the page "Wiki"
    * user (click on section link) "<section>"