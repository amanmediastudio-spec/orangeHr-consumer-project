package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerLeavePage
 */
public class ConsumerLeavePage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement leaveMenu;
    public PlaywrightPageElement leaveListHeader;
    public PlaywrightPageElement applyLeaveTab;
    public PlaywrightPageElement myLeaveTab;
    public PlaywrightPageElement entitlementsMenu;
    public PlaywrightPageElement reportsMenu;
    public PlaywrightPageElement leaveSearchBtn;
    public PlaywrightPageElement leaveResetBtn;
    public PlaywrightPageElement leaveEmployeeNameInput;

    public ConsumerLeavePage() {
        super("ConsumerLeavePage");
    }

    @Override
    protected void initElements() {
        leaveMenu = register("leaveMenu", "Leave left navigation menu item", "//span[normalize-space()='Leave'] | //a[contains(@href, 'leave')]");
        leaveListHeader = register("leaveListHeader", "Leave List page title header", "//h5[contains(.,'Leave List')] | //h6[contains(.,'Leave')]");
        applyLeaveTab = register("applyLeaveTab", "Apply leave top navigation tab", "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Apply']");
        myLeaveTab = register("myLeaveTab", "My Leave top navigation tab", "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='My Leave']");
        entitlementsMenu = register("entitlementsMenu", "Entitlements top navigation menu", "//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Entitlements']");
        reportsMenu = register("reportsMenu", "Reports top navigation menu in Leave", "//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Reports']");
        leaveSearchBtn = register("leaveSearchBtn", "Search button on Leave list page", "//button[@type='submit' and contains(.,'Search')]");
        leaveResetBtn = register("leaveResetBtn", "Reset button on Leave list filter", "//button[@type='button' and contains(.,'Reset')]");
        leaveEmployeeNameInput = register("leaveEmployeeNameInput", "Employee Name text input field for leave filter", "//input[@placeholder='Type for hints...']");
    }

    public void navigateToLeaveModule() {
        ensureSidepanelExpanded();
        click(leaveMenu);
        ensureFilterPanelExpanded();
    }

    public void navigateToApplyLeaveTab() {
        click(applyLeaveTab);
        ElementActions.pause(1000);
    }

    public void navigateToMyLeaveTab() {
        click(myLeaveTab);
        ensureFilterPanelExpanded();
    }

    public void clickEntitlementsMenu() {
        click(entitlementsMenu);
        ElementActions.pause(500);
    }

    public void filterLeaveRecords(String employeeName) {
        ensureFilterPanelExpanded();
        if (employeeName != null && !employeeName.isEmpty()) {
            fill(leaveEmployeeNameInput, employeeName);
        }
        click(leaveSearchBtn);
        ElementActions.pause(1000);
    }

    public void resetLeaveFilters() {
        ensureFilterPanelExpanded();
        click(leaveResetBtn);
        ElementActions.pause(1000);
    }

}
