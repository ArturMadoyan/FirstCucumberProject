@Test
Feature: GlobalsQa registration

  Scenario: Creation and removal of a new customer
    Given I navigate to GlobalQa login page and assert I am on that page
    When I click on Bank Manager Login button and assert that I am redirected correctly
    And I click on Add Customer button and assert that I am on the expected page
    And I fill in the customer info, submit it and I assert that alert is displayed
    And I accept the alert popup and assert that customer creation is completed
    And I click Customers button and assert that I am on the expected page
    And I search the customer I added and assert that the customer is filtered
    And I click Delete button
    Then I assert that the newly added customer is removed
