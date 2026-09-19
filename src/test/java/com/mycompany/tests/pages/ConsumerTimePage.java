package com.mycompany.tests.pages;

import com.automation.utils.ElementActions;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for Time & Attendance Module.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerTimePage extends OrangeHrmBasePage {

    public ConsumerTimePage() {
        super("ConsumerTimePage");
    }

    @Override
    protected void initElements() {
        register("timeMenu", "Time left navigation menu item",
                By.xpath("//span[normalize-space()='Time'] | //a[contains(@href, 'time')]"));
        register("timeModuleHeader", "Time module section header title",
                By.xpath("//h5[contains(.,'Timesheet')] | //h6[contains(.,'Time')]"));
        register("timesheetsMenu", "Timesheets top navigation menu dropdown",
                By.xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Timesheets']"));
        register("attendanceMenu", "Attendance top navigation menu dropdown",
                By.xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Attendance']"));
        register("punchInOutLink", "Punch In Out attendance navigation link",
                By.xpath("//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Punch In/Out']"));
        register("employeeNameInput", "Employee Name input field on Timesheets page",
                By.xpath("//input[@placeholder='Type for hints...']"));
        register("viewTimesheetBtn", "View button on employee timesheets page",
                By.xpath("//button[@type='submit' and contains(.,'View')]"));
    }

    public void navigateToTimeModule() {
        ensureSidepanelExpanded();
        click(getElement("timeMenu"));
        ensureFilterPanelExpanded();
    }

    public void navigateToPunchInOut() {
        click(getElement("attendanceMenu"));
        ElementActions.pause(500);
        click(getElement("punchInOutLink"));
        ElementActions.pause(1000);
    }

    public void searchEmployeeTimesheet(String empName) {
        ensureFilterPanelExpanded();
        if (empName != null && !empName.isEmpty()) {
            sendKeys(getElement("employeeNameInput"), empName);
        }
        click(getElement("viewTimesheetBtn"));
        ElementActions.pause(1000);
    }
}
