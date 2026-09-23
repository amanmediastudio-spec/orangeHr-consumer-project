package com.mycompany.tests.pages;

import com.automation.utils.ElementActions;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for Leave Management Module.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerLeavePage extends OrangeHrmBasePage {

    public ConsumerLeavePage() {
        super("ConsumerLeavePage");
    }

    @Override
    protected void initElements() {
        register("leaveMenu", "Leave left navigation menu item",
                By.xpath("//span[normalize-space()='Leave'] | //a[contains(@href, 'leave')]"));
        register("leaveListHeader", "Leave List page title header",
                By.xpath("//h5[contains(.,'Leave List')] | //h6[contains(.,'Leave')]"));
        register("applyLeaveTab", "Apply leave top navigation tab",
                By.xpath("//a[normalize-space()='Leave']"));
        register("myLeaveTab", "My Leave top navigation tab",
                By.xpath("//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='My Leave']"));
        register("entitlementsMenu", "Entitlements top navigation menu", By
                .xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Entitlements']"));
        register("reportsMenu", "Reports top navigation menu in Leave",
                By.xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Reports']"));
        register("leaveSearchBtn", "Search button on Leave list page",
                By.xpath("//button[@type='submit' and contains(.,'Search')]"));
        register("leaveResetBtn", "Reset button on Leave list filter",
                By.xpath("//button[@type='button' and contains(.,'Reset')]"));
        register("leaveEmployeeNameInput", "Employee Name text input field for leave filter",
                By.xpath("//input[@placeholder='Type for hints...']"));
    }

    public void navigateToLeaveModule() {
        ensureSidepanelExpanded();
        click(getElement("leaveMenu"));
        ensureFilterPanelExpanded();
    }

    public void navigateToApplyLeaveTab() {
        click(getElement("applyLeaveTab"));
        ElementActions.pause(1000);
    }

    public void navigateToMyLeaveTab() {
        click(getElement("myLeaveTab"));
        ensureFilterPanelExpanded();
    }

    public void clickEntitlementsMenu() {
        click(getElement("entitlementsMenu"));
        ElementActions.pause(500);
    }

    public void filterLeaveRecords(String employeeName) {
        ensureFilterPanelExpanded();
        if (employeeName != null && !employeeName.isEmpty()) {
            sendKeys(getElement("leaveEmployeeNameInput"), employeeName);
        }
        click(getElement("leaveSearchBtn"));
        ElementActions.pause(1000);
    }

    public void resetLeaveFilters() {
        ensureFilterPanelExpanded();
        click(getElement("leaveResetBtn"));
        ElementActions.pause(1000);
    }
}
