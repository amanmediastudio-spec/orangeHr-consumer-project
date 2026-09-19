package com.mycompany.tests.pages;

import com.automation.utils.ElementActions;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for Buzz Social Feed Module.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerBuzzPage extends OrangeHrmBasePage {

    public ConsumerBuzzPage() {
        super("ConsumerBuzzPage");
    }

    @Override
    protected void initElements() {
        register("buzzMenu", "Buzz left navigation menu item",
                By.xpath("//span[normalize-space()='Buzz'] | //a[contains(@href, 'buzz')]"));
        register("buzzHeader", "Buzz section header title",
                By.xpath("//h6[contains(.,'Buzz')] | //p[contains(.,'Buzz')]"));
        register("buzzPostTextArea", "What's on your mind text area to write buzz post", By
                .xpath("//textarea[contains(@class,'oxd-buzz-post-input') or @placeholder=\"What's on your mind?\"]"));
        register("buzzPostSubmitBtn", "Post button to publish newsfeed message",
                By.xpath("//button[@type='submit' and contains(.,'Post')]"));
        register("sharePhotosBtn", "Share Photos button on Buzz page",
                By.xpath("//button[contains(.,'Share Photos')] | //button[contains(@class,'oxd-glass-button')]"));
        register("shareVideoBtn", "Share Video button on Buzz page",
                By.xpath("//button[contains(.,'Share Video')] | //button[contains(@class,'oxd-glass-button')]"));
    }

    public void navigateToBuzzModule() {
        ensureSidepanelExpanded();
        click(getElement("buzzMenu"));
        ElementActions.pause(1000);
    }

    public void createBuzzPost(String message) {
        sendKeys(getElement("buzzPostTextArea"), message);
        click(getElement("buzzPostSubmitBtn"));
        ElementActions.pause(1500);
    }

    public boolean isSharePhotosButtonDisplayed() {
        return isDisplayed(getElement("sharePhotosBtn"));
    }

    public boolean isShareVideoButtonDisplayed() {
        return isDisplayed(getElement("shareVideoBtn"));
    }
}
