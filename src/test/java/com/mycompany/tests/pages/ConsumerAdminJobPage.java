package com.mycompany.tests.pages;

import com.automation.utils.ElementActions;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for Admin Job, Organization, and Qualifications
 * Management.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerAdminJobPage extends OrangeHrmBasePage {

    public ConsumerAdminJobPage() {
        super("ConsumerAdminJobPage");
    }

    @Override
    protected void initElements() {
        register("jobTopMenu", "Job top navigation dropdown menu in Admin",
                By.xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Job']"));
        register("jobTitlesMenuLink", "Job Titles menu item in Admin Job dropdown",
                By.xpath("//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Job Titles']"));
        register("orgTopMenu", "Organization top navigation dropdown menu in Admin", By
                .xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Organization']"));
        register("generalInfoMenuLink", "General Information menu item in Admin Organization dropdown", By.xpath(
                "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='General Information']"));
        register("qualificationsTopMenu", "Qualifications top navigation dropdown menu in Admin", By.xpath(
                "//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Qualifications']"));
        register("addRecordBtn", "Add button in Admin section", By.xpath("//button[contains(.,'Add')]"));
    }

    public void navigateToJobTitles() {
        click(getElement("jobTopMenu"));
        ElementActions.pause(500);
        click(getElement("jobTitlesMenuLink"));
        ElementActions.pause(1000);
    }

    public void navigateToGeneralInfo() {
        click(getElement("orgTopMenu"));
        ElementActions.pause(500);
        click(getElement("generalInfoMenuLink"));
        ElementActions.pause(1000);
    }

    public void clickQualificationsMenu() {
        click(getElement("qualificationsTopMenu"));
        ElementActions.pause(500);
    }
}
