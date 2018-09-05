#language:en
Feature: First level fragment

  @fragment
  Scenario: First level fragment
    * user (fill the field) "Search repositories..." "First level fragment text"
    * user (checks value) "Search repositories..." "First level fragment text"
    * user inserts fragment "Second level fragment"