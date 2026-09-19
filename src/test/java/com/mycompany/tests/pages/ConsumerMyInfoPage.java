package com.mycompany.tests.pages;

import com.automation.utils.ElementActions;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for My Info / Personal Profile Module.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerMyInfoPage extends OrangeHrmBasePage {

    public ConsumerMyInfoPage() {
        super("ConsumerMyInfoPage");
    }

    @Override
    protected void initElements() {
        register("myInfoMenu", "My Info left navigation menu item",
                By.xpath("//span[normalize-space()='My Info'] | //a[contains(@href, 'viewPersonalDetails')]"));
        register("personalDetailsHeader", "Personal Details sub section header title",
                By.xpath("//h6[contains(.,'Personal Details')]"));
        register("personalFirstName", "First Name text input field in Personal Details", By.name("firstName"));
        register("personalMiddleName", "Middle Name text input field in Personal Details", By.name("middleName"));
        register("personalLastName", "Last Name text input field in Personal Details", By.name("lastName"));
        register("nicknameInput", "Nickname text input field", By.xpath(
                "//label[normalize-space()='Nickname']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        register("otherIdInput", "Other Id text input field", By.xpath(
                "//label[normalize-space()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        register("contactDetailsTab", "Contact Details navigation tab in My Info",
                By.xpath("//a[contains(@href,'contactDetails') or normalize-space()='Contact Details']"));
        register("emergencyContactsTab", "Emergency Contacts navigation tab in My Info",
                By.xpath("//a[contains(@href,'emergencyContacts') or normalize-space()='Emergency Contacts']"));
        register("dependentsTab", "Dependents navigation tab in My Info",
                By.xpath("//a[contains(@href,'dependents') or normalize-space()='Dependents']"));
        register("savePersonalDetailsBtn", "Save button for personal details form",
                By.xpath("(//button[@type='submit' and contains(.,'Save')])[1]"));
    }

    public void navigateToMyInfo() {
        ensureSidepanelExpanded();
        click(getElement("myInfoMenu"));
        ElementActions.pause(1000);
    }

    public void navigateToContactDetails() {
        click(getElement("contactDetailsTab"));
        ElementActions.pause(1000);
    }

    public void navigateToEmergencyContacts() {
        click(getElement("emergencyContactsTab"));
        ElementActions.pause(1000);
    }

    public void navigateToDependents() {
        click(getElement("dependentsTab"));
        ElementActions.pause(1000);
    }

    public void updateNickname(String nickname) {
        sendKeys(getElement("nicknameInput"), nickname);
        click(getElement("savePersonalDetailsBtn"));
        ElementActions.pause(1500);
    }
}
