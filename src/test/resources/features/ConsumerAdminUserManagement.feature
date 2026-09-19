@ConsumerSuite @Admin @Smoke
Feature: Admin System Users Management

  Scenario: Filter and inspect system users using Select and AgGrid components
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Admin User Management module
    And the AI pre-flight agent validates all elements on the Admin page
    And I filter system users by role "Admin"
    Then I should see user records displayed in the system users table
    And the AI element healing JSON report should be generated in the consumer project
