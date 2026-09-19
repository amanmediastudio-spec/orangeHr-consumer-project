@ConsumerSuite @DataDriven
Feature: Enterprise Test Data Management and Scenario Context

  Scenario: Filter system users using strongly-typed JSON test data profiles
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Admin User Management module
    And I apply the system user filter profile "activeAdmin" from JSON test data
    Then I verify the filtered results match the active test data criteria

  Scenario: Generate synthetic test data and pass across steps via ScenarioContext
    Given I generate a dynamic employee profile with random synthetic data
    When I store the generated employee profile in ScenarioContext
    Then I verify the stored employee data can be retrieved from ScenarioContext
