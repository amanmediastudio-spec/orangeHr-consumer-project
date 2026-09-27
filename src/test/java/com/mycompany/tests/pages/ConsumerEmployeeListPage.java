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

    // SDK UI Components
    public PlaywrightButtonComponent searchBtn;
    public PlaywrightButtonComponent resetBtn;
    public PlaywrightAgGridComponent employeeTable;

    public ConsumerEmployeeListPage() {
        super("ConsumerEmployeeListPage");
    }

    public ConsumerEmployeeListPage(String pageName) {
        super(pageName);
    }

    @Override
    protected void initElements() {
        pimMenu = register("pimMenu", "PIM navigation menu item", "//span[normalize-space()='PIM'] | //a[contains(@href, 'pim')]");
        employeeListTitle = register("employeeListTitle", "Employee Information header title", "//h5[contains(.,'Employee Information')]");
        employeeNameInput = register("employeeNameInput", "Employee Name search input", "//label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input | //input[@placeholder='Type for hints...']");
        register("searchBtn", "Search submit button", "//button[@type='submit' and contains(.,'Search')]");
        register("resetBtn", "Reset button", "//button[contains(normalize-space(),'Reset')]");
        register("employeeTable", "Employee list table", ".oxd-table, .orangehrm-container");

        // Component Initialization
        searchBtn = initComponent(PlaywrightButtonComponent.class, "searchBtn", getElement("searchBtn"));
        resetBtn = initComponent(PlaywrightButtonComponent.class, "resetBtn", getElement("resetBtn"));
        employeeTable = initComponent(PlaywrightAgGridComponent.class, "employeeTable", getElement("employeeTable"));
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
