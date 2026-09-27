package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerClaimPage
 */
public class ConsumerClaimPage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement claimMenu;
    public PlaywrightPageElement claimHeader;
    public PlaywrightPageElement submitClaimTab;
    public PlaywrightPageElement myClaimsTab;
    public PlaywrightPageElement employeeClaimsTab;
    public PlaywrightPageElement searchClaimBtn;
    public PlaywrightPageElement resetClaimBtn;

    public ConsumerClaimPage() {
        super("ConsumerClaimPage");
    }

    public ConsumerClaimPage(String pageName) {
        super(pageName);
    }

    @Override
    protected void initElements() {
        claimMenu = register("claimMenu", "Claim left navigation menu item", "//span[normalize-space()='Claim'] | //a[contains(@href, 'claim')]");
        claimHeader = register("claimHeader", "Claim section header title", "//h5[contains(.,'Claim')] | //h6[contains(.,'Claim')]");
        submitClaimTab = register("submitClaimTab", "Submit Claim top navigation tab", "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Submit Claim']");
        myClaimsTab = register("myClaimsTab", "My Claims top navigation tab", "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='My Claims']");
        employeeClaimsTab = register("employeeClaimsTab", "Employee Claims top navigation tab", "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Employee Claims']");
        searchClaimBtn = register("searchClaimBtn", "Search button on Claim list filter", "//button[@type='submit' and contains(.,'Search')]");
        resetClaimBtn = register("resetClaimBtn", "Reset button on Claim list filter", "//button[@type='button' and contains(.,'Reset')]");
    }

    public void navigateToClaimModule() {
        ensureSidepanelExpanded();
        click(claimMenu);
        ensureFilterPanelExpanded();
    }

    public void navigateToSubmitClaimTab() {
        click(submitClaimTab);
        ElementActions.pause(1000);
    }

    public void navigateToMyClaimsTab() {
        click(myClaimsTab);
        ensureFilterPanelExpanded();
    }

    public void searchClaims() {
        ensureFilterPanelExpanded();
        click(searchClaimBtn);
        ElementActions.pause(1000);
    }

    public void resetClaimFilters() {
        ensureFilterPanelExpanded();
        click(resetClaimBtn);
        ElementActions.pause(1000);
    }

}
