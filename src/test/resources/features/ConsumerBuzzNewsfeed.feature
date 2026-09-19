@ConsumerSuite @Buzz @SelfHealing
Feature: Buzz Social Newsfeed and Post Management

  Scenario: Create and submit a new status update on Buzz feed
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Buzz module
    And the AI pre-flight agent validates all elements on the Buzz page
    And I publish a buzz status update "Automated status update with AI Self Healing!"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Verify photo and video sharing controls on Buzz page
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When I navigate to the Buzz module
    And the AI pre-flight agent validates all elements on the Buzz page
    Then I should see the Buzz photo and video sharing options
    And the AI element healing JSON report should be generated in the consumer project
