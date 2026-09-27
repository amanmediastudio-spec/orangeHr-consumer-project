package com.mycompany.tests.pages;

import com.automation.playwright.PlaywrightBasePage;
import com.automation.playwright.PlaywrightPageElement;
import com.automation.utils.ElementActions;

/**
 * Migrated Playwright Page Object strictly compliant with the Platform SDK.
 * Original Source: ConsumerRecruitmentPage
 */
public class ConsumerRecruitmentPage extends OrangeHrmBasePage {

    // Registered Playwright Elements
    public PlaywrightPageElement recruitmentMenu;
    public PlaywrightPageElement candidatesHeader;
    public PlaywrightPageElement addCandidateBtn;
    public PlaywrightPageElement candidateNameInput;
    public PlaywrightPageElement searchCandidatesBtn;
    public PlaywrightPageElement resetCandidatesBtn;
    public PlaywrightPageElement vacanciesTab;

    public ConsumerRecruitmentPage() {
        super("ConsumerRecruitmentPage");
    }

    @Override
    protected void initElements() {
        recruitmentMenu = register("recruitmentMenu", "Recruitment left navigation menu item", "//span[normalize-space()='Recruitment'] | //a[contains(@href, 'recruitment')]");
        candidatesHeader = register("candidatesHeader", "Candidates section header title", "//h5[contains(.,'Candidates')] | //h6[contains(.,'Recruitment')]");
        addCandidateBtn = register("addCandidateBtn", "Add candidate button in recruitment module", "//button[contains(.,'Add')]");
        candidateNameInput = register("candidateNameInput", "Candidate Name text input field", "//input[@placeholder='Type for hints...']");
        searchCandidatesBtn = register("searchCandidatesBtn", "Search button on candidates filter form", "//button[@type='submit' and contains(.,'Search')]");
        resetCandidatesBtn = register("resetCandidatesBtn", "Reset button on candidates filter form", "//button[@type='button' and contains(.,'Reset')]");
        vacanciesTab = register("vacanciesTab", "Vacancies top navigation tab", "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space()='Vacancies']");
    }

    public void navigateToRecruitmentModule() {
        ensureSidepanelExpanded();
        click(recruitmentMenu);
        ensureFilterPanelExpanded();
    }

    public void clickAddCandidate() {
        click(addCandidateBtn);
        ElementActions.pause(1000);
    }

    public void filterCandidates(String name) {
        ensureFilterPanelExpanded();
        if (name != null && !name.isEmpty()) {
            fill(candidateNameInput, name);
        }
        click(searchCandidatesBtn);
        ElementActions.pause(1000);
    }

    public void resetCandidateFilters() {
        ensureFilterPanelExpanded();
        click(resetCandidatesBtn);
        ElementActions.pause(1000);
    }

    public void navigateToVacanciesTab() {
        click(vacanciesTab);
        ensureFilterPanelExpanded();
    }

}
