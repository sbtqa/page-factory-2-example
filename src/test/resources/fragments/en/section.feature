#language:en
Feature: Open doc section

  @fragment
  Scenario: Open doc section
    * user (click the link) "docs"
    * user is on the page "docs"
    * user (click the link) "Wiki"
    * user is on the page "Wiki"
    * user (click on section link) "<section>"


