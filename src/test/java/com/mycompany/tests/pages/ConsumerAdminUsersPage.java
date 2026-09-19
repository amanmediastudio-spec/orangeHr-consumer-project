package com.mycompany.tests.pages;

import com.automation.components.AgGridComponent;
import com.automation.components.ButtonComponent;
import com.automation.components.SelectComponent;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for Admin System Users Management:
 * Demonstrates SelectComponent, ButtonComponent, and AgGridComponent from the
 * Core SDK.
 */
public class ConsumerAdminUsersPage extends OrangeHrmBasePage {

    public SelectComponent userRoleSelect;
    public SelectComponent statusSelect;
    public ButtonComponent searchBtn;
    public ButtonComponent resetBtn;
    public ButtonComponent addBtn;
    public AgGridComponent usersTable;

    public ConsumerAdminUsersPage() {
        super("ConsumerAdminUsersPage");
    }

    @Override
    protected void initElements() {
        register("adminMenu", "Admin left navigation menu item",
                By.xpath("//span[normalize-space()='Admin'] | //a[contains(@href, 'admin')]"));
        register("systemUsersTitle", "System Users title header",
                By.xpath("//h5[contains(.,'System Users')] | //h6[contains(.,'User Management')]"));
        register("userRoleSelect", "User Role dropdown", By.xpath(
                "//label[normalize-space()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-wrapper')]"));
        register("statusSelect", "Status dropdown", By.xpath(
                "//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-wrapper')]"));
        register("searchBtn", "Search button", By.xpath("//button[@type='submit' and contains(.,'Search')]"));
        register("resetBtn", "Reset button", By.xpath("//button[@type='button' and contains(.,'Reset')]"));
        register("addBtn", "Add user button", By.xpath("//button[contains(.,'Add')]"));
        register("usersTable", "Users list table", By.cssSelector(".oxd-table, .orangehrm-container, .table"));

        userRoleSelect = initComponent(SelectComponent.class, getElement("userRoleSelect"));
        statusSelect = initComponent(SelectComponent.class, getElement("statusSelect"));
        searchBtn = initComponent(ButtonComponent.class, getElement("searchBtn"));
        resetBtn = initComponent(ButtonComponent.class, getElement("resetBtn"));
        addBtn = initComponent(ButtonComponent.class, getElement("addBtn"));
        usersTable = initComponent(AgGridComponent.class, getElement("usersTable"));
    }

    public void navigateToAdminModule() {
        ensureSidepanelExpanded();
        click(getElement("adminMenu"));
        waitForVisibility(getElement("systemUsersTitle"), 15);
        ensureFilterPanelExpanded();
    }

    public void filterByUserRole(String role) {
        ensureFilterPanelExpanded();
        userRoleSelect.selectByVisibleText(role);
        searchBtn.click();
    }

    public int getRecordsFoundCount() {
        return usersTable.getRowCount();
    }
}
