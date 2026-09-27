package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.playwright.components.PlaywrightSelectComponent;
import com.automation.playwright.components.PlaywrightButtonComponent;
import com.automation.playwright.components.PlaywrightAgGridComponent;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerAdminUsersPage
 */
public class ConsumerAdminUsersPage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement adminMenu;
    public PlaywrightPageElement systemUsersTitle;
    public PlaywrightPageElement userRoleSelect;
    public PlaywrightPageElement statusSelect;
    public PlaywrightPageElement searchBtn;
    public PlaywrightPageElement resetBtn;
    public PlaywrightPageElement addBtn;
    public PlaywrightPageElement usersTable;

    // SDK UI Components
    public PlaywrightSelectComponent userRoleSelect;
    public PlaywrightSelectComponent statusSelect;
    public PlaywrightButtonComponent searchBtn;
    public PlaywrightButtonComponent resetBtn;
    public PlaywrightButtonComponent addBtn;
    public PlaywrightAgGridComponent usersTable;

    public ConsumerAdminUsersPage() {
        super("ConsumerAdminUsersPage");
    }

    @Override
    protected void initElements() {
        adminMenu = register("adminMenu", "Admin left navigation menu item", "//span[normalize-space()='Admin'] | //a[contains(@href, 'admin')]");
        systemUsersTitle = register("systemUsersTitle", "System Users title header", "//h5[contains(.,'System Users')] | //h6[contains(.,'User Management')]");
        userRoleSelect = register("userRoleSelect", "User Role dropdown", "//label[normalize-space()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-wrapper')]");
        statusSelect = register("statusSelect", "Status dropdown", "//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-wrapper')]");
        searchBtn = register("searchBtn", "Search button", "//button[@type='submit' and contains(.,'Search')]");
        resetBtn = register("resetBtn", "Reset button", "//button[@type='button' and contains(.,'Reset')]");
        addBtn = register("addBtn", "Add user button", "//button[contains(.,'Add')]");
        usersTable = register("usersTable", "Users list table", ".oxd-table, .orangehrm-container, .table");

        // Component Initialization
        userRoleSelect = initComponent(PlaywrightSelectComponent.class, "userRoleSelect", ".userroleselect");
        statusSelect = initComponent(PlaywrightSelectComponent.class, "statusSelect", ".statusselect");
        searchBtn = initComponent(PlaywrightButtonComponent.class, "searchBtn", ".searchbtn");
        resetBtn = initComponent(PlaywrightButtonComponent.class, "resetBtn", ".resetbtn");
        addBtn = initComponent(PlaywrightButtonComponent.class, "addBtn", ".addbtn");
        usersTable = initComponent(PlaywrightAgGridComponent.class, "usersTable", ".userstable");
    }

    public void navigateToAdminModule() {
        ensureSidepanelExpanded();
        click(adminMenu);
        waitForVisibility(getElement("systemUsersTitle"), 15);
        ensureFilterPanelExpanded();
    }

    public void filterByUserRole(String role) {
        ensureFilterPanelExpanded();
        selectOption(userRoleSelect, role);
        click(searchBtn);
    }

    public int getRecordsFoundCount() {
        return usersTable.getRowCount();
    }

}
