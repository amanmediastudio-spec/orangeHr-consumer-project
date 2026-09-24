package com.mycompany.tests.pages;

import com.automation.components.AgGridComponent;
import com.automation.components.ButtonComponent;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for PIM Employee Directory:
 * Demonstrates navigating to the PIM module, interacting with forms, and
 * inspecting table grids.
 */
public class ConsumerEmployeeListPage extends OrangeHrmBasePage {

    public ButtonComponent searchBtn;
    public ButtonComponent resetBtn;
    public AgGridComponent employeeTable;

    public ConsumerEmployeeListPage() {
        super("ConsumerEmployeeListPage");
    }

    @Override
    protected void initElements() {
        register("pimMenu", "PIM navigation menu item",
                By.xpath("//span[normalize-space()='PIM'] | //a[contains(@href, 'pim')]"));
        register("employeeListTitle", "Employee Information header title",
                By.xpath("//h5[contains(.,'Employee Information')]"));
        register("employeeNameInput", "Employee Name search input", By.xpath(
                "//label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input | //input[@placeholder='Type for hints...']"));
        register("searchBtn", "Search submit button", By.xpath("(//label[normalize-space()='Blood Type']/following::button)[1]"));
        register("resetBtn", "Reset button", By.xpath("//button[contains(normalize-space(),'Reset')]"));
        register("employeeTable", "Employee list table", By.cssSelector(".oxd-table, .orangehrm-container"));

        searchBtn = initComponent(ButtonComponent.class, getElement("searchBtn"));
        resetBtn = initComponent(ButtonComponent.class, getElement("resetBtn"));
        employeeTable = initComponent(AgGridComponent.class, getElement("employeeTable"));
    }

    public void navigateToPimModule() {
        ensureSidepanelExpanded();
        click(getElement("pimMenu"));
        waitForVisibility(getElement("employeeListTitle"), 15);
        ensureFilterPanelExpanded();
    }

    public void searchEmployeeByName(String name) {
        ensureFilterPanelExpanded();
        sendKeys(getElement("employeeNameInput"), name);
        searchBtn.click();
    }

    public boolean isTableDisplayed() {
        return employeeTable.getRowCount() >= 0;
    }
}
