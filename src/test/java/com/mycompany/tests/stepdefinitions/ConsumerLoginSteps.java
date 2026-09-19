package com.mycompany.tests.stepdefinitions;

import com.automation.config.ConfigReader;
import com.automation.users.User;
import com.automation.users.UserManager;
import com.automation.utils.ElementActions;
import com.automation.utils.Log;
import com.automation.utils.ScreenshotUtils;
import com.mycompany.tests.pages.ConsumerDashboardPage;
import com.mycompany.tests.pages.ConsumerLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ConsumerLoginSteps {

    private final ConsumerLoginPage loginPage = new ConsumerLoginPage();
    private final ConsumerDashboardPage dashboardPage = new ConsumerDashboardPage();
    private User currentUser;

    @Given("I acquire a consumer user with role {string}")
    public void acquireConsumerUser(String role) {
        currentUser = UserManager.getUser(role);
        Log.info("Consumer test leased user: " + currentUser.username());
    }

    @When("I navigate to the application portal")
    public void navigateToPortal() {
        String baseUrl = ConfigReader.get("base.url");
        ElementActions.navigateToUrl(baseUrl);
    }

    @When("the AI pre-flight agent validates consumer page elements")
    public void validateConsumerPageElements() {
        loginPage.validateAndHealPageElements();
    }

    @When("I perform login using consumer credentials")
    public void performLogin() {
        loginPage.login(currentUser.username(), currentUser.password());
    }

    @Then("I should see the dashboard loaded successfully")
    public void verifyDashboard() {
        Assert.assertTrue(dashboardPage.isDashboardLoaded(), "Dashboard failed to load!");
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Dashboard_Success");
        Log.info("Consumer scenario successfully validated dashboard!");
    }

    @Then("the AI element healing JSON report should be generated in the consumer project")
    public void verifyConsumerJsonReport() {
        com.automation.ai.HealingAuditLogger.exportJsonReport();
        java.io.File reportFile = new java.io.File("target/element-healing-history.json");
        Assert.assertTrue(reportFile.exists(),
                "Healing JSON report was not generated at: " + reportFile.getAbsolutePath());
        Assert.assertTrue(reportFile.length() > 0, "Healing JSON report file is empty!");
        Log.info("Verified consumer healing JSON report at: " + reportFile.getAbsolutePath() + " (size: "
                + reportFile.length() + " bytes)");
    }
}
