package com.mycompany.tests.pages;

import com.automation.pages.BasePage;
import com.automation.utils.ElementActions;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for Forgot / Reset Password flow.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerForgotPasswordPage extends BasePage {

    public ConsumerForgotPasswordPage() {
        super("ConsumerForgotPasswordPage");
    }

    @Override
    protected void initElements() {
        register("resetUsernameInput", "Username input field for password reset", By.name("username"));
        register("cancelResetBtn", "Cancel button on password reset page",
                By.xpath("//button[@type='button' and contains(.,'Cancel')]"));
        register("resetPasswordBtn", "Reset Password submit button", By.xpath("//button[@type='submit']"));
        register("resetPasswordHeader", "Reset Password page title header", By.xpath(
                "//h6[contains(@class,'orangehrm-forgot-password-title')] | //h6[contains(.,'Reset Password')]"));
    }

    public boolean isResetPasswordPageDisplayed() {
        try {
            return (com.automation.driver.DriverManager.getDriver() != null
                    && com.automation.driver.DriverManager.getDriver().getCurrentUrl()
                            .contains("requestPasswordResetCode"))
                    || isDisplayed(getElement("resetPasswordHeader"))
                    || isDisplayed(getElement("resetPasswordBtn"))
                    || ElementActions.isDisplayed(
                            By.xpath("//h6[contains(.,'Reset Password')] | //button[contains(.,'Reset Password')]"));
        } catch (Exception e) {
            return false;
        }
    }

    public void submitPasswordReset(String username) {
        sendKeys(getElement("resetUsernameInput"), username);
        click(getElement("resetPasswordBtn"));
    }

    public void cancelPasswordReset() {
        click(getElement("cancelResetBtn"));
    }
}
