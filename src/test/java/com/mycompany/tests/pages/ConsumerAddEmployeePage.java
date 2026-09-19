package com.mycompany.tests.pages;

import com.automation.utils.ElementActions;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for PIM Add Employee Form.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerAddEmployeePage extends OrangeHrmBasePage {

    public ConsumerAddEmployeePage() {
        super("ConsumerAddEmployeePage");
    }

    @Override
    protected void initElements() {
        register("addEmployeeNavTab", "Add Employee top navigation tab",
                By.xpath("//li[normalize-space()='Add Employee']"));
        register("addEmployeeHeader", "Add Employee section header title",
                By.xpath("//h6[contains(.,'Add Employee')]"));
        register("firstNameInput", "Employee first name text input field", By.name("firstName"));
        register("middleNameInput", "Employee middle name text input field", By.name("middleName"));
        register("lastNameInput", "Employee last name text input field", By.name("lastName"));
        register("employeeIdInput", "Employee ID numeric input field", By.xpath(
                "//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        register("saveEmployeeBtn", "Save button to submit new employee profile",
                By.xpath("//button[@type='submit' and contains(.,'Save')]"));
        register("cancelEmployeeBtn", "Cancel button on add employee form",
                By.xpath("//button[@type='button' and contains(.,'Cancel')]"));
    }

    public void navigateToAddEmployeeTab() {
        ensureSidepanelExpanded();
        click(getElement("addEmployeeNavTab"));
        ElementActions.pause(1000);
    }

    public void enterEmployeeDetails(String firstName, String middleName, String lastName, String empId) {
        sendKeys(getElement("firstNameInput"), firstName);
        sendKeys(getElement("middleNameInput"), middleName);
        sendKeys(getElement("lastNameInput"), lastName);
        if (empId != null && !empId.isEmpty()) {
            sendKeys(getElement("employeeIdInput"), empId);
        }
    }

    public void clickSave() {
        click(getElement("saveEmployeeBtn"));
        waitForSpinnerToDisappear();
        try {
            // After saving, OrangeHRM transitions to the employee details page; wait for form inputs to render
            WaitUtils.waitForVisibility(By.name("firstName"), 15);
            waitForSpinnerToDisappear();
        } catch (Exception ignored) {}
        ElementActions.pause(500);
    }

    public void clickCancel() {
        click(getElement("cancelEmployeeBtn"));
        waitForSpinnerToDisappear();
        ElementActions.pause(500);
    }
}
