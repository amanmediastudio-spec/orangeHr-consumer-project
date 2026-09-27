package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerTimePage
 */
public class ConsumerTimePage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement timeMenu;
    public PlaywrightPageElement timeModuleHeader;
    public PlaywrightPageElement timesheetsMenu;
    public PlaywrightPageElement attendanceMenu;
    public PlaywrightPageElement punchInOutLink;
    public PlaywrightPageElement employeeNameInput;
    public PlaywrightPageElement viewTimesheetBtn;

    public ConsumerTimePage() {
        super("ConsumerTimePage");
    }

    public ConsumerTimePage(String pageName) {
        super(pageName);
    }

    @Override
    protected void initElements() {
        timeMenu = register("timeMenu", "Time left navigation menu item", "//span[normalize-space()='Time'] | //a[contains(@href, 'time')]");
        timeModuleHeader = register("timeModuleHeader", "Time module section header title", "//h5[contains(.,'Timesheet')] | //h6[contains(.,'Time')]");
        timesheetsMenu = register("timesheetsMenu", "Timesheets top navigation menu dropdown", "//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Timesheets']");
        attendanceMenu = register("attendanceMenu", "Attendance top navigation menu dropdown", "//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Attendance']");
        punchInOutLink = register("punchInOutLink", "Punch In Out attendance navigation link", "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Punch In/Out']");
        employeeNameInput = register("employeeNameInput", "Employee Name input field on Timesheets page", "//input[@placeholder='Type for hints...']");
        viewTimesheetBtn = register("viewTimesheetBtn", "View button on employee timesheets page", "//button[@type='submit' and contains(.,'View')]");
    }

    public void navigateToTimeModule() {
        ensureSidepanelExpanded();
        click(timeMenu);
        ensureFilterPanelExpanded();
    }

    public void navigateToPunchInOut() {
        click(attendanceMenu);
        ElementActions.pause(500);
        click(punchInOutLink);
        ElementActions.pause(1000);
    }

    public void searchEmployeeTimesheet(String empName) {
        ensureFilterPanelExpanded();
        if (empName != null && !empName.isEmpty()) {
            fill(employeeNameInput, empName);
        }
        click(viewTimesheetBtn);
        ElementActions.pause(1000);
    }

}
