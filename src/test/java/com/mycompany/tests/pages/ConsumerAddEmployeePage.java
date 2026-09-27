package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerAddEmployeePage
 */
public class ConsumerAddEmployeePage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement addEmployeeNavTab;
    public PlaywrightPageElement addEmployeeHeader;
    public PlaywrightPageElement firstNameInput;
    public PlaywrightPageElement middleNameInput;
    public PlaywrightPageElement lastNameInput;
    public PlaywrightPageElement employeeIdInput;
    public PlaywrightPageElement saveEmployeeBtn;
    public PlaywrightPageElement cancelEmployeeBtn;

    public ConsumerAddEmployeePage() {
        super("ConsumerAddEmployeePage");
    }

    public ConsumerAddEmployeePage(String pageName) {
        super(pageName);
    }

    @Override
    protected void initElements() {
        addEmployeeNavTab = register("addEmployeeNavTab", "Add Employee top navigation tab", "//li[normalize-space()='Add Employee']");
        addEmployeeHeader = register("addEmployeeHeader", "Add Employee section header title", "//h6[contains(.,'Add Employee')]");
        firstNameInput = register("firstNameInput", "Employee first name text input field", "[name='firstName']");
        middleNameInput = register("middleNameInput", "Employee middle name text input field", "[name='middleName']");
        lastNameInput = register("lastNameInput", "Employee last name text input field", "[name='lastName']");
        employeeIdInput = register("employeeIdInput", "Employee ID numeric input field", "//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
        saveEmployeeBtn = register("saveEmployeeBtn", "Save button to submit new employee profile", "//button[@type='submit' and contains(.,'Save')]");
        cancelEmployeeBtn = register("cancelEmployeeBtn", "Cancel button on add employee form", "//button[@type='button' and contains(.,'Cancel')]");
    }

    public void navigateToAddEmployeeTab() {
        ensureSidepanelExpanded();
        click(addEmployeeNavTab);
        ElementActions.pause(1000);
    }

    public void enterEmployeeDetails(String firstName, String middleName, String lastName, String empId) {
        fill(firstNameInput, firstName);
        fill(middleNameInput, middleName);
        fill(lastNameInput, lastName);
        if (empId != null && !empId.isEmpty()) {
            fill(employeeIdInput, empId);
        }
    }

    public void clickSave() {
        click(saveEmployeeBtn);
        waitForSpinnerToDisappear();
        try {
            // Playwright auto-waits for spinners and page load
            waitForSpinnerToDisappear();
        } catch (Exception ignored) {
        }
        ElementActions.pause(500);
    }

    public void clickCancel() {
        click(cancelEmployeeBtn);
        waitForSpinnerToDisappear();
        ElementActions.pause(500);
    }

}
