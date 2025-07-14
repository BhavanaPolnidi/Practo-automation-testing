Feature: Display top cities from Diagnostics page

  Scenario: Pick all the top cities name and store in a List
    Given I am on the Diagnostics page
    When I pick all the top cities names
    Then I store the top cities names in a List
    And I display the List of top cities names
