package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerDashboardPage
 */
public class ConsumerDashboardPage extends PlaywrightBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement dashboardHeader;

    public ConsumerDashboardPage() {
        super("ConsumerDashboardPage");
    }

    public ConsumerDashboardPage(String pageName) {
        super(pageName);
    }

    @Override
    protected void initElements() {
        dashboardHeader = register("dashboardHeader", "Dashboard main title header", "//h6[contains(normalize-space(),'Dashboard')] | //span[contains(@class,'oxd-topbar-header-breadcrumb')] | //header");
    }

    public boolean isDashboardLoaded() {
        try {
            waitForVisibility(getElement("dashboardHeader"), 15);
            return true;
        } catch (Exception e) {
            return isDisplayed(getElement("dashboardHeader")) || (getPage() != null && getCurrentUrl().contains("/dashboard"));
        }
    }

}
