package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerForgotPasswordPage
 */
public class ConsumerForgotPasswordPage extends PlaywrightBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement resetUsernameInput;
    public PlaywrightPageElement cancelResetBtn;
    public PlaywrightPageElement resetPasswordBtn;
    public PlaywrightPageElement resetPasswordHeader;

    public ConsumerForgotPasswordPage() {
        super("ConsumerForgotPasswordPage");
    }

    public ConsumerForgotPasswordPage(String pageName) {
        super(pageName);
    }

    @Override
    protected void initElements() {
        resetUsernameInput = register("resetUsernameInput", "Username input field for password reset", "[name='username']");
        cancelResetBtn = register("cancelResetBtn", "Cancel button on password reset page", "//button[@type='button' and contains(.,'Cancel')]");
        resetPasswordBtn = register("resetPasswordBtn", "Reset Password submit button", "//button[@type='submit']");
        resetPasswordHeader = register("resetPasswordHeader", "Reset Password page title header", "//h6[contains(@class,'orangehrm-forgot-password-title')] | //h6[contains(.,'Reset Password')]");
    }

    public boolean isResetPasswordPageDisplayed() {
        try {
            return (getPage() != null && getCurrentUrl().contains("requestPasswordResetCode")) || isDisplayed(getElement("resetPasswordHeader")) || isDisplayed(getElement("resetPasswordBtn")) || getPage().locator("//h6[contains(.,'Reset Password')] | //button[contains(.,'Reset Password')]").isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public void submitPasswordReset(String username) {
        fill(resetUsernameInput, username);
        click(resetPasswordBtn);
    }

    public void cancelPasswordReset() {
        click(cancelResetBtn);
    }

}
