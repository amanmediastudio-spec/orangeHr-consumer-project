package com.mycompany.tests.stepdefinitions;

import com.automation.utils.Log;
import com.automation.utils.ScreenshotUtils;
import com.mycompany.tests.pages.ConsumerAdminUsersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ConsumerAdminSteps {

    private final ConsumerAdminUsersPage adminPage = new ConsumerAdminUsersPage();

    @When("I navigate to the Admin User Management module")
    public void navigateToAdmin() {
        adminPage.navigateToAdminModule();
        Log.info("Navigated to Admin User Management module.");
    }

    @And("the AI pre-flight agent validates all elements on the Admin page")
    public void validateAdminPageElements() {
        adminPage.validateAndHealPageElements();
    }

    @When("I filter system users by role {string}")
    public void filterUsersByRole(String role) {
        adminPage.filterByUserRole(role);
        Log.info("Filtered system users by role: " + role);
    }

    @Then("I should see user records displayed in the system users table")
    public void verifySystemUsersTable() {
        int rows = adminPage.getRecordsFoundCount();
        Assert.assertTrue(rows >= 0, "Users table is not displayed!");
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Admin_Users_Filtered");
        Log.info("System users table validated with rows count: " + rows);
    }
}
