package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerDirectoryPage
 */
public class ConsumerDirectoryPage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement directoryMenu;
    public PlaywrightPageElement directoryHeader;
    public PlaywrightPageElement directoryEmployeeName;
    public PlaywrightPageElement searchDirectoryBtn;
    public PlaywrightPageElement resetDirectoryBtn;

    public ConsumerDirectoryPage() {
        super("ConsumerDirectoryPage");
    }

    @Override
    protected void initElements() {
        directoryMenu = register("directoryMenu", "Directory left navigation menu item", "//span[normalize-space()='Directory'] | //a[contains(@href, 'directory')]");
        directoryHeader = register("directoryHeader", "Directory section header title", "//h5[contains(.,'Directory')] | //h6[contains(.,'Directory')]");
        directoryEmployeeName = register("directoryEmployeeName", "Employee Name text input field on Directory page", "//input[@placeholder='Type for hints...']");
        searchDirectoryBtn = register("searchDirectoryBtn", "Search button on directory filter form", "//button[@type='submit' and contains(.,'Search')]");
        resetDirectoryBtn = register("resetDirectoryBtn", "Reset button on directory filter form", "//button[@type='button' and contains(.,'Reset')]");
    }

    public void navigateToDirectoryModule() {
        ensureSidepanelExpanded();
        click(directoryMenu);
        ensureFilterPanelExpanded();
    }

    public void searchEmployeeInDirectory(String empName) {
        ensureFilterPanelExpanded();
        if (empName != null && !empName.isEmpty()) {
            fill(directoryEmployeeName, empName);
        }
        click(searchDirectoryBtn);
        ElementActions.pause(1000);
    }

    public void resetDirectoryFilters() {
        ensureFilterPanelExpanded();
        click(resetDirectoryBtn);
        ElementActions.pause(1000);
    }

}
