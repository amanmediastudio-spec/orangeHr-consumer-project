@ConsumerSuite @Recruitment @SelfHealing
Feature: Recruitment and Candidate Pipeline Management

  Scenario: Filter candidates by name using auto-healed search fields
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Recruitment module
    And the AI pre-flight agent validates all elements on the Recruitment page
    And I filter candidates with name "a"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Reset candidate filter criteria
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Recruitment module
    And the AI pre-flight agent validates all elements on the Recruitment page
    And I reset candidate filters
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Add Candidate form
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Recruitment module
    And I click the Add Candidate button
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Job Vacancies section
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Recruitment module
    And I navigate to the Vacancies tab
    Then the AI element healing JSON report should be generated in the consumer project
