@ConsumerSuite @Time @SelfHealing
Feature: Time Tracking and Attendance Management

  Scenario: Search employee timesheets using auto-healed form locators
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Time & Attendance module
    And the AI pre-flight agent validates all elements on the Time page
    And I search timesheet for employee "a"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Punch In and Out attendance section
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Time & Attendance module
    And I navigate to the Punch In Out attendance option
    Then the AI element healing JSON report should be generated in the consumer project
