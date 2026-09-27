package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;
import com.microsoft.playwright.Locator;
import java.util.List;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerDashboardWidgetsPage
 */
public class ConsumerDashboardWidgetsPage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement assignLeaveQuickLaunch;
    public PlaywrightPageElement leaveListQuickLaunch;
    public PlaywrightPageElement timesheetsQuickLaunch;
    public PlaywrightPageElement applyLeaveQuickLaunch;
    public PlaywrightPageElement myLeaveQuickLaunch;
    public PlaywrightPageElement myTimesheetQuickLaunch;
    public PlaywrightPageElement userDropdownMenu;
    public PlaywrightPageElement aboutMenuItem;
    public PlaywrightPageElement supportMenuItem;
    public PlaywrightPageElement changePasswordMenuItem;
    public PlaywrightPageElement logoutMenuItem;
    public PlaywrightPageElement aboutModalCloseBtn;

    public ConsumerDashboardWidgetsPage() {
        super("ConsumerDashboardWidgetsPage");
    }

    @Override
    protected void initElements() {
        assignLeaveQuickLaunch = register("assignLeaveQuickLaunch", "Assign Leave quick launch action button", "//button[@title='Assign Leave'] | //button[contains(.,'Assign Leave')]");
        leaveListQuickLaunch = register("leaveListQuickLaunch", "Leave List quick launch action button", "//button[@title='Leave List'] | //button[contains(.,'Leave List')]");
        timesheetsQuickLaunch = register("timesheetsQuickLaunch", "Timesheets quick launch action button", "//button[@title='Timesheets'] | //button[contains(.,'Timesheets')]");
        applyLeaveQuickLaunch = register("applyLeaveQuickLaunch", "Apply Leave quick launch action button", "//button[@title='Apply Leave'] | //button[contains(.,'Apply Leave')]");
        myLeaveQuickLaunch = register("myLeaveQuickLaunch", "My Leave quick launch action button", "//button[@title='My Leave'] | //button[contains(.,'My Leave')]");
        myTimesheetQuickLaunch = register("myTimesheetQuickLaunch", "My Timesheet quick launch action button", "//button[@title='My Timesheet'] | //button[contains(.,'My Timesheet')]");
        userDropdownMenu = register("userDropdownMenu", "User profile dropdown toggle menu in top header", "//span[contains(@class,'oxd-userdropdown-tab')] | //p[contains(@class,'oxd-userdropdown-name')]");
        aboutMenuItem = register("aboutMenuItem", "About link in user dropdown menu", "//a[contains(@class,'oxd-userdropdown-link') and normalize-space()='About'] | //a[contains(@href,'#') and text()='About']");
        supportMenuItem = register("supportMenuItem", "Support link in user dropdown menu", "//a[contains(@class,'oxd-userdropdown-link') and normalize-space()='Support'] | //a[contains(@href,'support')]");
        changePasswordMenuItem = register("changePasswordMenuItem", "Change Password link in user dropdown menu", "//a[contains(@class,'oxd-userdropdown-link') and normalize-space()='Change Password'] | //a[contains(@href,'updatePassword')]");
        logoutMenuItem = register("logoutMenuItem", "Logout link in user dropdown menu", "//a[contains(@class,'oxd-userdropdown-link') and normalize-space()='Logout'] | //a[contains(@href,'logout')]");
        aboutModalCloseBtn = register("aboutModalCloseBtn", "Close button on About dialog modal", ".oxd-userdropdown-tab, [data-testid='user-profile'], .user-dropdown, .user-profile");
    }

    public void clickAssignLeaveQuickLaunch() {
        click(assignLeaveQuickLaunch);
    }

    public void clickLeaveListQuickLaunch() {
        click(leaveListQuickLaunch);
    }

    public void clickTimesheetsQuickLaunch() {
        click(timesheetsQuickLaunch);
    }

    public void clickApplyLeaveQuickLaunch() {
        click(applyLeaveQuickLaunch);
    }

    public void openUserDropdown() {
        try {
            // WebDriver instance omitted in Playwright
            // driver null-check omitted in Playwright
        } catch (Exception ignored) {
        }
        click(userDropdownMenu);
        ElementActions.pause(500);
    }

    public void openAboutModal() {
        openUserDropdown();
        click(aboutMenuItem);
    }

    public void closeAboutModal() {
        try {
            click(aboutModalCloseBtn);
        } catch (Exception e) {
            getPage().locator("//button[contains(@class,'oxd-dialog-close-button') or text()='×']").click();
        }
        ElementActions.pause(500);
    }

    public void validateAndHealPageElements() {
        openUserDropdown();
        ElementActions.pause(400);
        super.validateAndHealPageElements();
    }

    public void clickLogout() {
        openUserDropdown();
        ElementActions.pause(400);
        try {
            getPage().locator("//a[contains(@href,'logout') or normalize-space()='Logout']").click();
        } catch (Exception e) {
            click(logoutMenuItem);
        }
        ElementActions.pause(2000);
    }

}
