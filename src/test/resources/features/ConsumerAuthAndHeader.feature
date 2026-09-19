@ConsumerSuite @Auth @SelfHealing
Feature: Authentication, Password Reset, and Topbar Header Controls

  Scenario: Request password reset with auto-healed form locators
    When I navigate to the application portal
    And I click on the Forgot your password link
    Then I should see the Reset Password page
    When the AI pre-flight agent validates all elements on the Reset Password page
    And I request password reset for username "Admin"
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Cancel password reset and return to login page
    When I navigate to the application portal
    And I click on the Forgot your password link
    Then I should see the Reset Password page
    When the AI pre-flight agent validates all elements on the Reset Password page
    And I cancel password reset
    Then I should see the login page displayed

  Scenario: Inspect About dialog modal from user profile dropdown
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When the AI pre-flight agent validates all elements on the Dashboard Widgets page
    And I open the topbar user profile dropdown
    And I click on the About link in user dropdown
    And I close the About dialog modal
    Then the AI element healing JSON report should be generated in the consumer project

  Scenario: Successfully log out from user profile dropdown
    Given I acquire a consumer user with role "admin"
    When I navigate to the application portal
    And I perform login using consumer credentials
    Then I should see the dashboard loaded successfully
    When the AI pre-flight agent validates all elements on the Dashboard Widgets page
    And I open the topbar user profile dropdown
    And I click on the Logout option
    Then I should see the login page displayed
