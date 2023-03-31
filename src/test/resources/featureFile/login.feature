Feature: 
  Hitachi Solutions

  @one
  Scenario: 
    User trying to view search result page

    Given I navigate to Hitachi Homepage
    When I search for "Hitachi Solutions Launch Program"
    Then I view "Hitachi Solutions Launch Program" result page

@two
  Scenario:
    User trying to validate whether actual and expected page results are same

    Given I navigate to Hitachi Homepage
    When I search for "Hitachi Solutions Launch Program"
    Then I view "Hitachi Solutions Launch" result page
