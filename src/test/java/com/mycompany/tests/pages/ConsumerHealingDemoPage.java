package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.playwright.components.PlaywrightButtonComponent;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerHealingDemoPage
 */
public class ConsumerHealingDemoPage extends PlaywrightBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement brokenUsername;
    public PlaywrightPageElement password;

    // SDK UI Components
    public PlaywrightButtonComponent submitBtn;

    public ConsumerHealingDemoPage() {
        super("ConsumerHealingDemoPage");
    }

    public ConsumerHealingDemoPage(String pageName) {
        super(pageName);
    }

    @Override
    protected void initElements() {
        brokenUsername = register("brokenUsername", "Username text input field", "#invalid_broken_consumer_user_input_99999");
        password = register("password", "Password text input field", "[name='password']");
        register("submitBtn", "Login submit button", "button[type='submit']");

        // Component Initialization
        submitBtn = initComponent(PlaywrightButtonComponent.class, "submitBtn", getElement("submitBtn"));
    }

    public void loginWithHealedElement(String user, String pass) {
        fill(brokenUsername, user);
        fill(password, pass);
        click(submitBtn);
    }

}
