package com.mycompany.tests.stepdefinitions;

import com.automation.utils.ElementActions;
import com.automation.utils.Log;
import com.automation.utils.ScreenshotUtils;
import com.mycompany.tests.pages.ConsumerDashboardWidgetsPage;
import com.mycompany.tests.pages.ConsumerForgotPasswordPage;
import com.mycompany.tests.pages.ConsumerLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ConsumerAuthAndHeaderSteps {

    private final ConsumerForgotPasswordPage forgotPasswordPage = new ConsumerForgotPasswordPage();
    private final ConsumerDashboardWidgetsPage dashboardWidgetsPage = new ConsumerDashboardWidgetsPage();
    private final ConsumerLoginPage loginPage = new ConsumerLoginPage();

    @When("I click on the Forgot your password link")
    public void clickForgotPasswordLink() {
        loginPage.clickForgotPassword();
        Log.info("Clicked Forgot your password link.");
    }

    @Then("I should see the Reset Password page")
    public void verifyResetPasswordPage() {
        Assert.assertTrue(forgotPasswordPage.isResetPasswordPageDisplayed(), "Reset Password page not displayed!");
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Reset_Password_Page");
        Log.info("Reset Password page verified successfully.");
    }

    @And("the AI pre-flight agent validates all elements on the Reset Password page")
    public void validateResetPasswordElements() {
        forgotPasswordPage.validateAndHealPageElements();
    }

    @When("I request password reset for username {string}")
    public void requestPasswordReset(String username) {
        forgotPasswordPage.submitPasswordReset(username);
        Log.info("Submitted password reset request for: " + username);
    }

    @When("I cancel password reset")
    public void cancelPasswordReset() {
        forgotPasswordPage.cancelPasswordReset();
        Log.info("Cancelled password reset request.");
    }

    @And("the AI pre-flight agent validates all elements on the Dashboard Widgets page")
    public void validateDashboardWidgetsElements() {
        dashboardWidgetsPage.validateAndHealPageElements();
    }

    @When("I open the topbar user profile dropdown")
    public void openUserProfileDropdown() {
        dashboardWidgetsPage.openUserDropdown();
        Log.info("Opened topbar user profile dropdown.");
    }

    @When("I click on the About link in user dropdown")
    public void clickAboutLink() {
        dashboardWidgetsPage.openAboutModal();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_About_Modal");
        Log.info("Opened About dialog modal.");
    }

    @When("I close the About dialog modal")
    public void closeAboutModal() {
        dashboardWidgetsPage.closeAboutModal();
        Log.info("Closed About dialog modal.");
    }

    @When("I click on the Logout option")
    public void clickLogout() {
        dashboardWidgetsPage.clickLogout();
        ElementActions.pause(1000);
        Log.info("Clicked Logout option.");
    }

    @Then("I should see the login page displayed")
    public void verifyLoginPageDisplayed() {
        try {
            com.automation.utils.WaitUtils.waitForVisibility(By.name("username"), 10);
        } catch (Exception ignored) {
        }
        boolean displayed = ElementActions.isDisplayed(By.name("username"))
                || (com.automation.driver.DriverManager.getDriver() != null
                        && com.automation.driver.DriverManager.getDriver().getCurrentUrl().contains("login"));
        Assert.assertTrue(displayed, "Login page was not displayed after logout!");
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Logout_Success");
        Log.info("Verified redirect to login page after logout.");
    }
}
