@ConsumerSuite @PIM @AddEmployee @SelfHealing
Feature: PIM Add New Employee Flow

  Scenario: Create and save a new employee record using auto-healed form fields
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the PIM Employee Directory module
    And I navigate to the Add Employee tab
    And the AI pre-flight agent validates all elements on the Add Employee page
    And I enter employee details with first name "AITestFirst", middle name "AITestMid", and last name "AITestLast"
    And I save the new employee profile
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Cancel adding a new employee and return
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the PIM Employee Directory module
    And I navigate to the Add Employee tab
    And the AI pre-flight agent validates all elements on the Add Employee page
    And I enter employee details with first name "DraftFirst", middle name "DraftMid", and last name "DraftLast"
    And I cancel adding the employee
    Then the AI element healing JSON report should be generated in the consumer project
