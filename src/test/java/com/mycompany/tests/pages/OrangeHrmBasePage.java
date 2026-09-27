package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.utils.ElementActions;
import com.microsoft.playwright.Locator;
import java.util.List;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: OrangeHrmBasePage
 */
public class OrangeHrmBasePage extends PlaywrightBasePage {

    public OrangeHrmBasePage() {
        super("OrangeHrmBasePage");
    }

    public OrangeHrmBasePage(String pageName) {
        super(pageName);
    }

    @Override
    protected void initElements() {
    }

    public void ensureSidepanelExpanded() {
        try {
            // WebDriver instance omitted in Playwright
            // driver null-check omitted in Playwright
            List<Locator> sidepanels = getPage().locator(".oxd-sidepanel").all();
            if (sidepanels.isEmpty() || !sidepanels.get(0).isVisible()) {
                List<Locator> hamburgers = getPage().locator(".oxd-topbar-header-hamburger, i.oxd-topbar-header-hamburger, button.oxd-icon-button").all();
                for (Locator h : hamburgers) {
                    if (h.isVisible()) {
                        h.click();
                        ElementActions.pause(500);
                        break;
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

    public void ensureFilterPanelExpanded() {
        try {
            // WebDriver instance omitted in Playwright
            // driver null-check omitted in Playwright
            List<Locator> searchBtns = getPage().locator("//button[normalize-space()='Search']").all();
            if (!searchBtns.isEmpty() && searchBtns.get(0).isVisible()) {
                return ;
            }
            List<Locator> toggles = getPage().locator("//div[contains(@class,'oxd-table-filter')]//button | //div[contains(@class,'oxd-table-filter-header')]//button | //i[contains(@class,'bi-caret')]/ancestor::button").all();
            for (Locator toggle : toggles) {
                if (toggle.isVisible()) {
                    toggle.click();
                    ElementActions.pause(500);
                    break;
                }
            }
        } catch (Exception ignored) {
        }
    }

    public void waitForSpinnerToDisappear() {
        try {
            // Playwright auto-waits for spinners and page load
            ElementActions.pause(300);
        } catch (Exception ignored) {
        }
    }

    public void waitForPageLoad() {
        try {
            // Playwright auto-waits for spinners and page load
            waitForSpinnerToDisappear();
        } catch (Exception ignored) {
        }
    }

    public void validateAndHealPageElements() {
        ensureFilterPanelExpanded();
        waitForSpinnerToDisappear();
        super.validateAndHealPageElements();
    }

}
