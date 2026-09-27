package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerAdminJobPage
 */
public class ConsumerAdminJobPage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement jobTopMenu;
    public PlaywrightPageElement jobTitlesMenuLink;
    public PlaywrightPageElement orgTopMenu;
    public PlaywrightPageElement generalInfoMenuLink;
    public PlaywrightPageElement qualificationsTopMenu;
    public PlaywrightPageElement addRecordBtn;

    public ConsumerAdminJobPage() {
        super("ConsumerAdminJobPage");
    }

    @Override
    protected void initElements() {
        jobTopMenu = register("jobTopMenu", "Job top navigation dropdown menu in Admin", "//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Job']");
        jobTitlesMenuLink = register("jobTitlesMenuLink", "Job Titles menu item in Admin Job dropdown", "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Job Titles']");
        orgTopMenu = register("orgTopMenu", "Organization top navigation dropdown menu in Admin", "//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Organization']");
        generalInfoMenuLink = register("generalInfoMenuLink", "General Information menu item in Admin Organization dropdown", "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='General Information']");
        qualificationsTopMenu = register("qualificationsTopMenu", "Qualifications top navigation dropdown menu in Admin", "//span[contains(@class,'oxd-topbar-body-nav-tab-item') and normalize-space()='Qualifications']");
        addRecordBtn = register("addRecordBtn", "Add button in Admin section", "//button[contains(.,'Add')]");
    }

    public void navigateToJobTitles() {
        click(jobTopMenu);
        ElementActions.pause(500);
        click(jobTitlesMenuLink);
        ElementActions.pause(1000);
    }

    public void navigateToGeneralInfo() {
        click(orgTopMenu);
        ElementActions.pause(500);
        click(generalInfoMenuLink);
        ElementActions.pause(1000);
    }

    public void clickQualificationsMenu() {
        click(qualificationsTopMenu);
        ElementActions.pause(500);
    }

}
