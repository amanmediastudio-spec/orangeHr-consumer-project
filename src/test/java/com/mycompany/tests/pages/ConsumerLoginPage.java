package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.playwright.components.PlaywrightButtonComponent;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerLoginPage
 */
public class ConsumerLoginPage extends PlaywrightBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement username;
    public PlaywrightPageElement password;
    public PlaywrightPageElement loginBtn;
    public PlaywrightPageElement forgotPasswordLink;

    // SDK UI Components
    public PlaywrightButtonComponent loginBtn;

    public ConsumerLoginPage() {
        super("ConsumerLoginPage");
    }

    @Override
    protected void initElements() {
        username = register("username", "Username text input field", "[name='username']");
        password = register("password", "Password text input field", "[name='password']");
        loginBtn = register("loginBtn", "Login submit button", "button[type='submit']");
        forgotPasswordLink = register("forgotPasswordLink", "Forgot your password link on login page", "//p[contains(@class,'orangehrm-login-forgot-header')] | //p[contains(.,'Forgot your password?')]");

        // Component Initialization
        loginBtn = initComponent(PlaywrightButtonComponent.class, "loginBtn", ".loginbtn");
    }

    public void login(String username, String password) {
        fill(username, username);
        fill(password, password);
        click(loginBtn);
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

}
