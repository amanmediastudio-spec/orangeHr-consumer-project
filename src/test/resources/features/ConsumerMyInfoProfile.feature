@ConsumerSuite @MyInfo @SelfHealing
Feature: My Info Personal Profile Management

  Scenario: Update employee nickname in personal details
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the My Info module
    And the AI pre-flight agent validates all elements on the My Info page
    And I update my nickname to "SuperAdmin"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Contact Details sub-tab
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the My Info module
    And I navigate to the Contact Details section
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Emergency Contacts sub-tab
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the My Info module
    And I navigate to the Emergency Contacts section
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Dependents sub-tab
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the My Info module
    And I navigate to the Dependents section
    Then the AI element healing JSON report should be generated in the consumer project
