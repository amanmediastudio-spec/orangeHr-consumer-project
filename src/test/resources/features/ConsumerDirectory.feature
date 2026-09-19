@ConsumerSuite @Directory @SelfHealing
Feature: Employee Directory Search and Inspection

  Scenario: Search employee directory by name using auto-healed inputs
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Employee Directory module
    And the AI pre-flight agent validates all elements on the Directory page
    And I search directory for employee "a"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Reset directory filter parameters
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Employee Directory module
    And the AI pre-flight agent validates all elements on the Directory page
    And I reset directory filters
    Then the AI element healing JSON report should be generated in the consumer project
