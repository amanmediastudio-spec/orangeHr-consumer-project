package com.mycompany.tests.stepdefinitions;

import com.automation.utils.Log;
import com.automation.utils.ScreenshotUtils;
import com.mycompany.tests.pages.ConsumerEmployeeListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ConsumerEmployeeSteps {

    private final ConsumerEmployeeListPage employeePage = new ConsumerEmployeeListPage();

    @When("I navigate to the PIM Employee Directory module")
    public void navigateToPim() {
        employeePage.navigateToPimModule();
        employeePage.validateAndHealPageElements();
        Log.info("Navigated to PIM Employee Directory module.");
    }

    @And("the AI pre-flight agent validates all elements on the Employee Directory page")
    public void validateEmployeePageElements() {
        employeePage.validateAndHealPageElements();
    }

    @When("I search for an employee with name {string}")
    public void searchEmployee(String name) {
        employeePage.searchEmployeeByName(name);
        employeePage.validateAndHealPageElements();
        Log.info("Searched for employee: " + name);
    }

    @Then("I should see the employee information table populated")
    public void verifyEmployeeTable() {
        Assert.assertTrue(employeePage.isTableDisplayed(), "Employee table is not displayed!");
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Employee_Directory");
        Log.info("Employee directory table verified successfully.");
    }
}
