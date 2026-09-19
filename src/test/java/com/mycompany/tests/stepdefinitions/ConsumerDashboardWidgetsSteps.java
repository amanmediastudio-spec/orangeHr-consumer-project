package com.mycompany.tests.stepdefinitions;

import com.automation.utils.ElementActions;
import com.automation.utils.Log;
import com.automation.utils.ScreenshotUtils;
import com.mycompany.tests.pages.ConsumerDashboardWidgetsPage;
import io.cucumber.java.en.When;

public class ConsumerDashboardWidgetsSteps {

    private final ConsumerDashboardWidgetsPage dashboardWidgetsPage = new ConsumerDashboardWidgetsPage();

    @When("I click on Quick Launch {string}")
    public void clickQuickLaunchAction(String actionName) {
        dashboardWidgetsPage.validateAndHealPageElements();
        switch (actionName.toLowerCase().trim()) {
            case "assign leave" -> dashboardWidgetsPage.clickAssignLeaveQuickLaunch();
            case "leave list" -> dashboardWidgetsPage.clickLeaveListQuickLaunch();
            case "timesheets" -> dashboardWidgetsPage.clickTimesheetsQuickLaunch();
            case "apply leave" -> dashboardWidgetsPage.clickApplyLeaveQuickLaunch();
            default -> Log.warn("Unknown quick launch action: " + actionName);
        }
        ElementActions.pause(1000);
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Quick_Launch_" + actionName.replaceAll("\\s+", "_"));
        Log.info("Clicked Quick Launch action: " + actionName);
    }
}
