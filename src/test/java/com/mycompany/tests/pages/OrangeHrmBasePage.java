package com.mycompany.tests.pages;

import com.automation.driver.DriverManager;
import com.automation.pages.BasePage;
import com.automation.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Shared base page for OrangeHRM consumer application modules,
 * containing common layout management routines (sidebar hamburger toggling,
 * filter accordion expansion).
 */
public abstract class OrangeHrmBasePage extends BasePage {

    protected OrangeHrmBasePage(String pageName) {
        super(pageName);
    }

    public void ensureSidepanelExpanded() {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver == null)
                return;
            List<WebElement> sidepanels = driver.findElements(By.cssSelector(".oxd-sidepanel"));
            if (sidepanels.isEmpty() || !sidepanels.get(0).isDisplayed()) {
                List<WebElement> hamburgers = driver.findElements(By.cssSelector(
                        ".oxd-topbar-header-hamburger, i.oxd-topbar-header-hamburger, button.oxd-icon-button"));
                for (WebElement h : hamburgers) {
                    if (h.isDisplayed()) {
                        com.automation.utils.ResilientActions.click(h);
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
            WebDriver driver = DriverManager.getDriver();
            if (driver == null)
                return;
            List<WebElement> searchBtns = driver.findElements(By.xpath("//button[normalize-space()='Search']"));
            if (!searchBtns.isEmpty() && searchBtns.get(0).isDisplayed()) {
                return;
            }
            List<WebElement> toggles = driver.findElements(By.xpath(
                    "//div[contains(@class,'oxd-table-filter')]//button | //div[contains(@class,'oxd-table-filter-header')]//button | //i[contains(@class,'bi-caret')]/ancestor::button"));
            for (WebElement toggle : toggles) {
                if (toggle.isDisplayed()) {
                    com.automation.utils.ResilientActions.click(toggle);
                    ElementActions.pause(500);
                    break;
                }
            }
        } catch (Exception ignored) {
        }
    }

    public void waitForSpinnerToDisappear() {
        try {
            com.automation.utils.WaitUtils.waitForSpinnersToDisappear(10);
            ElementActions.pause(300);
        } catch (Exception ignored) {
        }
    }

    public void waitForPageLoad() {
        try {
            com.automation.utils.WaitUtils.waitForPageLoad(10);
            waitForSpinnerToDisappear();
        } catch (Exception ignored) {
        }
    }

    @Override
    public void validateAndHealPageElements() {
        ensureFilterPanelExpanded();
        waitForSpinnerToDisappear();
        super.validateAndHealPageElements();
    }
}
