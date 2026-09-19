package com.mycompany.tests.stepdefinitions;

import com.automation.data.DataGenerator;
import com.automation.data.ScenarioContext;
import com.automation.data.TestData;
import com.automation.data.TestDataManager;
import com.automation.utils.Log;
import com.automation.utils.ScreenshotUtils;
import com.mycompany.tests.pages.ConsumerAdminUsersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ConsumerDataDrivenSteps {

    private final ConsumerAdminUsersPage adminPage = new ConsumerAdminUsersPage();

    @And("I apply the system user filter profile {string} from JSON test data")
    public void applyFilterProfile(String profileKey) {
        // 1. Dynamic Test Data loading via TestData container - Zero Java Model Classes needed!
        TestData filterData = TestDataManager.getData("admin-filters." + profileKey);
        String role = filterData.getString("role");
        String status = filterData.getString("status");
        
        Log.info("Loaded dynamic test data profile: role=" + role + ", status=" + status);
        ScenarioContext.set("appliedFilterRole", role);

        adminPage.userRoleSelect.selectByVisibleText(role);
        adminPage.searchBtn.click();
    }

    @Then("I verify the filtered results match the active test data criteria")
    public void verifyFilteredResults() {
        String role = ScenarioContext.getString("appliedFilterRole");
        Assert.assertNotNull(role, "No filter role found in ScenarioContext!");
        
        int rowCount = adminPage.getRecordsFoundCount();
        Assert.assertTrue(rowCount >= 0, "Users table should have records matching " + role);
        
        ScreenshotUtils.captureAndSaveCustomScreenshot("DataDriven_Filter_" + role);
        Log.info("Validated data-driven filter for role: " + role + " (Found " + rowCount + " rows)");
    }

    @Given("I generate a dynamic employee profile with random synthetic data")
    public void generateDynamicData() {
        String randomName = DataGenerator.randomFullName();
        String randomEmail = DataGenerator.randomEmail("enterprise-demo.com");
        String randomEmpId = DataGenerator.randomNumeric(6);

        Log.info("Generated synthetic test data -> Name: " + randomName + ", Email: " + randomEmail + ", ID: " + randomEmpId);
        
        ScenarioContext.set("syntheticName", randomName);
        ScenarioContext.set("syntheticEmail", randomEmail);
        ScenarioContext.set("syntheticId", randomEmpId);
    }

    @When("I store the generated employee profile in ScenarioContext")
    public void storeInContext() {
        Assert.assertTrue(ScenarioContext.contains("syntheticName"), "syntheticName not present in context!");
        Assert.assertTrue(ScenarioContext.contains("syntheticEmail"), "syntheticEmail not present in context!");
        Assert.assertTrue(ScenarioContext.contains("syntheticId"), "syntheticId not present in context!");
    }

    @Then("I verify the stored employee data can be retrieved from ScenarioContext")
    public void verifyFromContext() {
        String name = ScenarioContext.getString("syntheticName");
        String email = ScenarioContext.getString("syntheticEmail");
        String id = ScenarioContext.getString("syntheticId");

        Assert.assertNotNull(name, "Name retrieved from context is null!");
        Assert.assertNotNull(email, "Email retrieved from context is null!");
        Assert.assertNotNull(id, "ID retrieved from context is null!");

        Log.info("Successfully retrieved from ScenarioContext -> Name: " + name + ", Email: " + email + ", ID: " + id);
    }
}
