@ConsumerSuite @Claim @SelfHealing
Feature: Claim and Expense Management

  Scenario: Search and filter claims records with auto-healed controls
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Claim module
    And the AI pre-flight agent validates all elements on the Claim page
    And I search claims records
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Reset claims filter search criteria
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Claim module
    And the AI pre-flight agent validates all elements on the Claim page
    And I reset claim filters
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to Submit Claim section
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Claim module
    And I navigate to the Submit Claim tab
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Navigate to My Claims section
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Claim module
    And I navigate to the My Claims tab
    Then the AI element healing JSON report should be generated in the consumer project
