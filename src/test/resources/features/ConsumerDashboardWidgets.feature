@ConsumerSuite @Dashboard @SelfHealing
Feature: Dashboard Quick Launch Widgets and Navigation

  Scenario: Navigate to Assign Leave via Quick Launch widget
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When the AI pre-flight agent validates all elements on the Dashboard Widgets page
    And I click on Quick Launch "Assign Leave"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Leave List via Quick Launch widget
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When the AI pre-flight agent validates all elements on the Dashboard Widgets page
    And I click on Quick Launch "Leave List"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Timesheets via Quick Launch widget
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When the AI pre-flight agent validates all elements on the Dashboard Widgets page
    And I click on Quick Launch "Timesheets"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Apply Leave via Quick Launch widget
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When the AI pre-flight agent validates all elements on the Dashboard Widgets page
    And I click on Quick Launch "Apply Leave"
    Then the AI element healing JSON report should be generated in the consumer project
