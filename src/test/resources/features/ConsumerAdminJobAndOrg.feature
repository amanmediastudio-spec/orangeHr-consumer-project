@ConsumerSuite @Admin @SelfHealing
Feature: Admin Job, Organization, and Qualifications Configuration

  Scenario: Navigate to Job Titles configuration section
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Admin User Management module
    And I navigate to the Job Titles management section
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Organization General Information section
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Admin User Management module
    And I navigate to the Organization General Information section
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Qualifications menu
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Admin User Management module
    And I click on the Admin Qualifications menu
    Then the AI element healing JSON report should be generated in the consumer project
