#language:en
Feature: First level fragment

  @fragment
  Scenario: First level fragment
    * user fills the field "Search repositories..." with value "First level fragment text"
    * user checks in the element "Search repositories..." value "First level fragment text"
    * user inserts fragment "Second level fragment"