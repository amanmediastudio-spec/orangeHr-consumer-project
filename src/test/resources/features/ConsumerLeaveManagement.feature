@ConsumerSuite @Leave @SelfHealing
Feature: Leave Management and Request Processing

  Scenario: Filter leave records on Leave List page
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Leave Management module
    And the AI pre-flight agent validates all elements on the Leave page
    And I filter leave records for employee "a"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Reset leave search filter parameters
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Leave Management module
    And the AI pre-flight agent validates all elements on the Leave page
    And I reset the leave filters
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Apply Leave section
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Leave Management module
    And I navigate to the Apply Leave tab
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to My Leave section
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Leave Management module
    And I navigate to the My Leave tab
    Then the AI element healing JSON report should be generated in the consumer project
