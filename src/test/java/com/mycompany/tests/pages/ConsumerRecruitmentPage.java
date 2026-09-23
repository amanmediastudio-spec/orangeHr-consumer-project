package com.mycompany.tests.pages;

import com.automation.utils.ElementActions;
import org.openqa.selenium.By;

/**
 * Consumer Page Object for Recruitment Module.
 * All locators are intentionally broken to validate AI Self-Healing.
 */
public class ConsumerRecruitmentPage extends OrangeHrmBasePage {

    public ConsumerRecruitmentPage() {
        super("ConsumerRecruitmentPage");
    }

    @Override
    protected void initElements() {
        register("recruitmentMenu", "Recruitment left navigation menu item",
                By.xpath("//span[normalize-space()='Recruitment'] | //a[contains(@href, 'recruitment')]"));
        register("candidatesHeader", "Candidates section header title",
                By.xpath("//h5[contains(.,'Candidates')] | //h6[contains(.,'Recruitment')]"));
        register("addCandidateBtn", "Add candidate button in recruitment module",
                By.xpath("//button[contains(.,'Add')]"));
        register("candidateNameInput", "Candidate Name text input field",
                By.xpath("//input[@placeholder='Type for hints...']"));
        register("searchCandidatesBtn", "Search button on candidates filter form",
                By.xpath("//button[@type='submit' and contains(.,'Search')]"));
        register("resetCandidatesBtn", "Reset button on candidates filter form",
                By.xpath("//a[contains(normalize-space(),'Claim')]"));
        register("vacanciesTab", "Vacancies top navigation tab",
                By.xpath("//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Vacancies']"));
    }

    public void navigateToRecruitmentModule() {
        ensureSidepanelExpanded();
        click(getElement("recruitmentMenu"));
        ensureFilterPanelExpanded();
    }

    public void clickAddCandidate() {
        click(getElement("addCandidateBtn"));
        ElementActions.pause(1000);
    }

    public void filterCandidates(String name) {
        ensureFilterPanelExpanded();
        if (name != null && !name.isEmpty()) {
            sendKeys(getElement("candidateNameInput"), name);
        }
        click(getElement("searchCandidatesBtn"));
        ElementActions.pause(1000);
    }

    public void resetCandidateFilters() {
        ensureFilterPanelExpanded();
        click(getElement("resetCandidatesBtn"));
        ElementActions.pause(1000);
    }

    public void navigateToVacanciesTab() {
        click(getElement("vacanciesTab"));
        ensureFilterPanelExpanded();
    }
}
