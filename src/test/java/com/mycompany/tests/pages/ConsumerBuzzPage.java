package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerBuzzPage
 */
public class ConsumerBuzzPage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement buzzMenu;
    public PlaywrightPageElement buzzHeader;
    public PlaywrightPageElement buzzPostTextArea;
    public PlaywrightPageElement buzzPostSubmitBtn;
    public PlaywrightPageElement sharePhotosBtn;
    public PlaywrightPageElement shareVideoBtn;

    public ConsumerBuzzPage() {
        super("ConsumerBuzzPage");
    }

    @Override
    protected void initElements() {
        buzzMenu = register("buzzMenu", "Buzz left navigation menu item", "//span[normalize-space()='Buzz'] | //a[contains(@href, 'buzz')]");
        buzzHeader = register("buzzHeader", "Buzz section header title", "//h6[contains(.,'Buzz')] | //p[contains(.,'Buzz')]");
        buzzPostTextArea = register("buzzPostTextArea", "What's on your mind text area to write buzz post", "//textarea[contains(@class,'oxd-buzz-post-input') or @placeholder=\"What's on your mind?\"]");
        buzzPostSubmitBtn = register("buzzPostSubmitBtn", "Post button to publish newsfeed message", "//button[@type='submit' and contains(.,'Post')]");
        sharePhotosBtn = register("sharePhotosBtn", "Share Photos button on Buzz page", "//button[contains(.,'Share Photos')] | //button[contains(@class,'oxd-glass-button')]");
        shareVideoBtn = register("shareVideoBtn", "Share Video button on Buzz page", "//button[contains(.,'Share Video')] | //button[contains(@class,'oxd-glass-button')]");
    }

    public void navigateToBuzzModule() {
        ensureSidepanelExpanded();
        click(buzzMenu);
        ElementActions.pause(1000);
    }

    public void createBuzzPost(String message) {
        fill(buzzPostTextArea, message);
        click(buzzPostSubmitBtn);
        ElementActions.pause(1500);
    }

    public boolean isSharePhotosButtonDisplayed() {
        return isVisible(sharePhotosBtn);
    }

    public boolean isShareVideoButtonDisplayed() {
        return isVisible(shareVideoBtn);
    }

}
