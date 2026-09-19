package com.mycompany.tests.pages;

import com.automation.utils.ElementActions;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for Employee Directory Module.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerDirectoryPage extends OrangeHrmBasePage {

    public ConsumerDirectoryPage() {
        super("ConsumerDirectoryPage");
    }

    @Override
    protected void initElements() {
        register("directoryMenu", "Directory left navigation menu item",
                By.xpath("//span[normalize-space()='Directory'] | //a[contains(@href, 'directory')]"));
        register("directoryHeader", "Directory section header title",
                By.xpath("//h5[contains(.,'Directory')] | //h6[contains(.,'Directory')]"));
        register("directoryEmployeeName", "Employee Name text input field on Directory page",
                By.xpath("//input[@placeholder='Type for hints...']"));
        register("searchDirectoryBtn", "Search button on directory filter form",
                By.xpath("//button[@type='submit' and contains(.,'Search')]"));
        register("resetDirectoryBtn", "Reset button on directory filter form",
                By.xpath("//button[@type='button' and contains(.,'Reset')]"));
    }

    public void navigateToDirectoryModule() {
        ensureSidepanelExpanded();
        click(getElement("directoryMenu"));
        ensureFilterPanelExpanded();
    }

    public void searchEmployeeInDirectory(String empName) {
        ensureFilterPanelExpanded();
        if (empName != null && !empName.isEmpty()) {
            sendKeys(getElement("directoryEmployeeName"), empName);
        }
        click(getElement("searchDirectoryBtn"));
        ElementActions.pause(1000);
    }

    public void resetDirectoryFilters() {
        ensureFilterPanelExpanded();
        click(getElement("resetDirectoryBtn"));
        ElementActions.pause(1000);
    }
}
