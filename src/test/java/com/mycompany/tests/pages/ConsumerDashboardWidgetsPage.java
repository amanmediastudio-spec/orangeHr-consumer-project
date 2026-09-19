package com.mycompany.tests.pages;

import com.automation.driver.DriverManager;
import com.automation.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Consumer Page Object for Dashboard Quick Launch widgets and Topbar User
 * Profile dropdown menu.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerDashboardWidgetsPage extends OrangeHrmBasePage {

    public ConsumerDashboardWidgetsPage() {
        super("ConsumerDashboardWidgetsPage");
    }

    @Override
    protected void initElements() {
        // Quick Launch Buttons
        register("assignLeaveQuickLaunch", "Assign Leave quick launch action button",
                By.xpath("//button[@title='Assign Leave'] | //button[contains(.,'Assign Leave')]"));
        register("leaveListQuickLaunch", "Leave List quick launch action button",
                By.xpath("//button[@title='Leave List'] | //button[contains(.,'Leave List')]"));
        register("timesheetsQuickLaunch", "Timesheets quick launch action button",
                By.xpath("//button[@title='Timesheets'] | //button[contains(.,'Timesheets')]"));
        register("applyLeaveQuickLaunch", "Apply Leave quick launch action button",
                By.xpath("//button[@title='Apply Leave'] | //button[contains(.,'Apply Leave')]"));
        register("myLeaveQuickLaunch", "My Leave quick launch action button",
                By.xpath("//button[@title='My Leave'] | //button[contains(.,'My Leave')]"));
        register("myTimesheetQuickLaunch", "My Timesheet quick launch action button",
                By.xpath("//button[@title='My Timesheet'] | //button[contains(.,'My Timesheet')]"));

        // User Profile Dropdown & Navigation Links
        register("userDropdownMenu", "User profile dropdown toggle menu in top header", By.xpath(
                "//span[contains(@class,'oxd-userdropdown-tab')] | //p[contains(@class,'oxd-userdropdown-name')]"));
        register("aboutMenuItem", "About link in user dropdown menu", By.xpath(
                "//a[contains(@class,'oxd-userdropdown-link') and normalize-space()='About'] | //a[contains(@href,'#') and text()='About']"));
        register("supportMenuItem", "Support link in user dropdown menu", By.xpath(
                "//a[contains(@class,'oxd-userdropdown-link') and normalize-space()='Support'] | //a[contains(@href,'support')]"));
        register("changePasswordMenuItem", "Change Password link in user dropdown menu", By.xpath(
                "//a[contains(@class,'oxd-userdropdown-link') and normalize-space()='Change Password'] | //a[contains(@href,'updatePassword')]"));
        register("logoutMenuItem", "Logout link in user dropdown menu", By.xpath(
                "//a[contains(@class,'oxd-userdropdown-link') and normalize-space()='Logout'] | //a[contains(@href,'logout')]"));
        register("aboutModalCloseBtn", "Close button on About dialog modal",
                By.cssSelector(".oxd-userdropdown-tab, [data-testid='user-profile'], .user-dropdown, .user-profile"));
    }

    public void clickAssignLeaveQuickLaunch() {
        click(getElement("assignLeaveQuickLaunch"));
    }

    public void clickLeaveListQuickLaunch() {
        click(getElement("leaveListQuickLaunch"));
    }

    public void clickTimesheetsQuickLaunch() {
        click(getElement("timesheetsQuickLaunch"));
    }

    public void clickApplyLeaveQuickLaunch() {
        click(getElement("applyLeaveQuickLaunch"));
    }

    public void openUserDropdown() {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                List<WebElement> menu = driver.findElements(By.cssSelector(".oxd-dropdown-menu, ul[role='menu']"));
                if (!menu.isEmpty() && menu.get(0).isDisplayed()) {
                    return; // Already open
                }
                List<WebElement> dropdowns = driver
                        .findElements(By.cssSelector(".oxd-userdropdown-tab, .oxd-userdropdown-name"));
                if (!dropdowns.isEmpty()) {
                    com.automation.utils.ResilientActions.click(dropdowns.get(0));
                    ElementActions.pause(500);
                    return;
                }
            }
        } catch (Exception ignored) {
        }
        click(getElement("userDropdownMenu"));
        ElementActions.pause(500);
    }

    public void openAboutModal() {
        openUserDropdown();
        click(getElement("aboutMenuItem"));
    }

    public void closeAboutModal() {
        try {
            click(getElement("aboutModalCloseBtn"));
        } catch (Exception e) {
            com.automation.utils.ResilientActions
                    .click(By.xpath("//button[contains(@class,'oxd-dialog-close-button') or text()='×']"));
        }
        ElementActions.pause(500);
    }

    @Override
    public void validateAndHealPageElements() {
        openUserDropdown();
        ElementActions.pause(400);
        super.validateAndHealPageElements();
    }

    public void clickLogout() {
        openUserDropdown();
        ElementActions.pause(400);
        try {
            com.automation.utils.ResilientActions
                    .click(By.xpath("//a[contains(@href,'logout') or normalize-space()='Logout']"));
        } catch (Exception e) {
            click(getElement("logoutMenuItem"));
        }
        ElementActions.pause(2000);
    }
}
