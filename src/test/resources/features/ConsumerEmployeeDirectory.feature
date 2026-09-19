@ConsumerSuite @PIM @Regression
Feature: PIM Employee Directory Management

  Scenario: Search and view employee records in the PIM module
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the PIM Employee Directory module
    And the AI pre-flight agent validates all elements on the Employee Directory page
    And I search for an employee with name "a"
    Then I should see the employee information table populated
    And the AI element healing JSON report should be generated in the consumer project
