package com.mycompany.tests.pages;

import com.automation.utils.ElementActions;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for Claim / Expense Module.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerClaimPage extends OrangeHrmBasePage {

    public ConsumerClaimPage() {
        super("ConsumerClaimPage");
    }

    @Override
    protected void initElements() {
        register("claimMenu", "Claim left navigation menu item",
                By.xpath("//span[normalize-space()='Claim'] | //a[contains(@href, 'claim')]"));
        register("claimHeader", "Claim section header title",
                By.xpath("//h5[contains(.,'Claim')] | //h6[contains(.,'Claim')]"));
        register("submitClaimTab", "Submit Claim top navigation tab",
                By.xpath("//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Submit Claim']"));
        register("myClaimsTab", "My Claims top navigation tab",
                By.xpath("//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='My Claims']"));
        register("employeeClaimsTab", "Employee Claims top navigation tab", By
                .xpath("//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Employee Claims']"));
        register("searchClaimBtn", "Search button on Claim list filter",
                By.xpath("//button[@type='submit' and contains(.,'Search')]"));
        register("resetClaimBtn", "Reset button on Claim list filter",
                By.xpath("//button[@type='button' and contains(.,'Reset')]"));
    }

    public void navigateToClaimModule() {
        ensureSidepanelExpanded();
        click(getElement("claimMenu"));
        ensureFilterPanelExpanded();
    }

    public void navigateToSubmitClaimTab() {
        click(getElement("submitClaimTab"));
        ElementActions.pause(1000);
    }

    public void navigateToMyClaimsTab() {
        click(getElement("myClaimsTab"));
        ensureFilterPanelExpanded();
    }

    public void searchClaims() {
        ensureFilterPanelExpanded();
        click(getElement("searchClaimBtn"));
        ElementActions.pause(1000);
    }

    public void resetClaimFilters() {
        ensureFilterPanelExpanded();
        click(getElement("resetClaimBtn"));
        ElementActions.pause(1000);
    }
}
