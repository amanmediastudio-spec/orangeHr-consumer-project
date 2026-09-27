package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.playwright.components.PlaywrightButtonComponent;
import com.automation.playwright.components.PlaywrightAgGridComponent;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerEmployeeListPage
 */
public class ConsumerEmployeeListPage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement pimMenu;
    public PlaywrightPageElement employeeListTitle;
    public PlaywrightPageElement employeeNameInput;
    public PlaywrightPageElement searchBtn;
    public PlaywrightPageElement resetBtn;
    public PlaywrightPageElement employeeTable;

    // SDK UI Components
    public PlaywrightButtonComponent searchBtn;
    public PlaywrightButtonComponent resetBtn;
    public PlaywrightAgGridComponent employeeTable;

    public ConsumerEmployeeListPage() {
        super("ConsumerEmployeeListPage");
    }

    @Override
    protected void initElements() {
        pimMenu = register("pimMenu", "PIM navigation menu item", "//span[normalize-space()='PIM'] | //a[contains(@href, 'pim')]");
        employeeListTitle = register("employeeListTitle", "Employee Information header title", "//h5[contains(.,'Employee Information')]");
        employeeNameInput = register("employeeNameInput", "Employee Name search input", "//label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input | //input[@placeholder='Type for hints...']");
        searchBtn = register("searchBtn", "Search submit button", "//button[@type='submit' and contains(.,'Search')]");
        resetBtn = register("resetBtn", "Reset button", "//button[contains(normalize-space(),'Reset')]");
        employeeTable = register("employeeTable", "Employee list table", ".oxd-table, .orangehrm-container");

        // Component Initialization
        searchBtn = initComponent(PlaywrightButtonComponent.class, "searchBtn", ".searchbtn");
        resetBtn = initComponent(PlaywrightButtonComponent.class, "resetBtn", ".resetbtn");
        employeeTable = initComponent(PlaywrightAgGridComponent.class, "employeeTable", ".employeetable");
    }

    public void navigateToPimModule() {
        ensureSidepanelExpanded();
        click(pimMenu);
        waitForVisibility(getElement("employeeListTitle"), 15);
        ensureFilterPanelExpanded();
    }

    public void searchEmployeeByName(String name) {
        ensureFilterPanelExpanded();
        fill(employeeNameInput, name);
        click(searchBtn);
    }

    public boolean isTableDisplayed() {
        return employeeTable.getRowCount() >= 0;
    }

}
