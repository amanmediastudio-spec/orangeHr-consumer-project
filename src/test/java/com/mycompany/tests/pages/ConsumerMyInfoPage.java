package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerMyInfoPage
 */
public class ConsumerMyInfoPage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement myInfoMenu;
    public PlaywrightPageElement personalDetailsHeader;
    public PlaywrightPageElement personalFirstName;
    public PlaywrightPageElement personalMiddleName;
    public PlaywrightPageElement personalLastName;
    public PlaywrightPageElement nicknameInput;
    public PlaywrightPageElement otherIdInput;
    public PlaywrightPageElement contactDetailsTab;
    public PlaywrightPageElement emergencyContactsTab;
    public PlaywrightPageElement dependentsTab;
    public PlaywrightPageElement savePersonalDetailsBtn;

    public ConsumerMyInfoPage() {
        super("ConsumerMyInfoPage");
    }

    public ConsumerMyInfoPage(String pageName) {
        super(pageName);
    }

    @Override
    protected void initElements() {
        myInfoMenu = register("myInfoMenu", "My Info left navigation menu item", "//span[normalize-space()='My Info'] | //a[contains(@href, 'viewPersonalDetails')]");
        personalDetailsHeader = register("personalDetailsHeader", "Personal Details sub section header title", "//h6[contains(.,'Personal Details')]");
        personalFirstName = register("personalFirstName", "First Name text input field in Personal Details", "[name='firstName']");
        personalMiddleName = register("personalMiddleName", "Middle Name text input field in Personal Details", "[name='middleName']");
        personalLastName = register("personalLastName", "Last Name text input field in Personal Details", "[name='lastName']");
        nicknameInput = register("nicknameInput", "Nickname text input field", "//label[normalize-space()='Nickname']/ancestor::div[contains(@class,'oxd-input-group')]//input");
        otherIdInput = register("otherIdInput", "Other Id text input field", "//label[normalize-space()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
        contactDetailsTab = register("contactDetailsTab", "Contact Details navigation tab in My Info", "//a[contains(@href,'contactDetails') or normalize-space()='Contact Details']");
        emergencyContactsTab = register("emergencyContactsTab", "Emergency Contacts navigation tab in My Info", "//a[contains(@href,'emergencyContacts') or normalize-space()='Emergency Contacts']");
        dependentsTab = register("dependentsTab", "Dependents navigation tab in My Info", "//a[contains(@href,'dependents') or normalize-space()='Dependents']");
        savePersonalDetailsBtn = register("savePersonalDetailsBtn", "Save button for personal details form", "(//button[@type='submit' and contains(.,'Save')])[1]");
    }

    public void navigateToMyInfo() {
        ensureSidepanelExpanded();
        click(myInfoMenu);
        ElementActions.pause(1000);
    }

    public void navigateToContactDetails() {
        click(contactDetailsTab);
        ElementActions.pause(1000);
    }

    public void navigateToEmergencyContacts() {
        click(emergencyContactsTab);
        ElementActions.pause(1000);
    }

    public void navigateToDependents() {
        click(dependentsTab);
        ElementActions.pause(1000);
    }

    public void updateNickname(String nickname) {
        fill(nicknameInput, nickname);
        click(savePersonalDetailsBtn);
        ElementActions.pause(1500);
    }

}
