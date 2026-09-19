package com.mycompany.tests.stepdefinitions;

import com.automation.utils.Log;
import com.automation.utils.ScreenshotUtils;
import com.mycompany.tests.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ConsumerHRModulesSteps {

    private final ConsumerAddEmployeePage addEmployeePage = new ConsumerAddEmployeePage();
    private final ConsumerLeavePage leavePage = new ConsumerLeavePage();
    private final ConsumerTimePage timePage = new ConsumerTimePage();
    private final ConsumerRecruitmentPage recruitmentPage = new ConsumerRecruitmentPage();
    private final ConsumerMyInfoPage myInfoPage = new ConsumerMyInfoPage();
    private final ConsumerDirectoryPage directoryPage = new ConsumerDirectoryPage();
    private final ConsumerBuzzPage buzzPage = new ConsumerBuzzPage();
    private final ConsumerClaimPage claimPage = new ConsumerClaimPage();
    private final ConsumerAdminJobPage adminJobPage = new ConsumerAdminJobPage();

    // ==========================================
    // 1. ADD EMPLOYEE STEPS
    // ==========================================
    @When("I navigate to the Add Employee tab")
    public void navigateToAddEmployeeTab() {
        addEmployeePage.navigateToAddEmployeeTab();
        Log.info("Navigated to Add Employee tab.");
    }

    @And("the AI pre-flight agent validates all elements on the Add Employee page")
    public void validateAddEmployeeElements() {
        addEmployeePage.validateAndHealPageElements();
    }

    @When("I enter employee details with first name {string}, middle name {string}, and last name {string}")
    public void enterEmployeeDetails(String first, String middle, String last) {
        addEmployeePage.enterEmployeeDetails(first, middle, last, null);
        Log.info("Entered employee details: " + first + " " + middle + " " + last);
    }

    @When("I save the new employee profile")
    public void saveEmployee() {
        addEmployeePage.clickSave();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Employee_Saved");
        Log.info("Saved new employee profile.");
    }

    @When("I cancel adding the employee")
    public void cancelEmployee() {
        addEmployeePage.clickCancel();
        Log.info("Cancelled adding employee.");
    }

    // ==========================================
    // 2. LEAVE MANAGEMENT STEPS
    // ==========================================
    @When("I navigate to the Leave Management module")
    public void navigateToLeave() {
        leavePage.navigateToLeaveModule();
        Log.info("Navigated to Leave Management module.");
    }

    @And("the AI pre-flight agent validates all elements on the Leave page")
    public void validateLeaveElements() {
        leavePage.validateAndHealPageElements();
    }

    @When("I navigate to the Apply Leave tab")
    public void navigateToApplyLeave() {
        leavePage.navigateToApplyLeaveTab();
        leavePage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Apply_Leave");
        Log.info("Navigated to Apply Leave tab.");
    }

    @When("I navigate to the My Leave tab")
    public void navigateToMyLeave() {
        leavePage.navigateToMyLeaveTab();
        leavePage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_My_Leave");
        Log.info("Navigated to My Leave tab.");
    }

    @When("I click on the Leave Entitlements top menu")
    public void clickLeaveEntitlements() {
        leavePage.clickEntitlementsMenu();
        Log.info("Clicked Leave Entitlements menu.");
    }

    @When("I filter leave records for employee {string}")
    public void filterLeaveRecords(String employee) {
        leavePage.filterLeaveRecords(employee);
        Log.info("Filtered leave records for employee: " + employee);
    }

    @When("I reset the leave filters")
    public void resetLeaveFilters() {
        leavePage.resetLeaveFilters();
        Log.info("Reset leave filters.");
    }

    // ==========================================
    // 3. TIME & ATTENDANCE STEPS
    // ==========================================
    @When("I navigate to the Time & Attendance module")
    public void navigateToTime() {
        timePage.navigateToTimeModule();
        Log.info("Navigated to Time & Attendance module.");
    }

    @And("the AI pre-flight agent validates all elements on the Time page")
    public void validateTimeElements() {
        timePage.validateAndHealPageElements();
    }

    @When("I navigate to the Punch In Out attendance option")
    public void navigateToPunchInOut() {
        timePage.navigateToPunchInOut();
        timePage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Punch_In_Out");
        Log.info("Navigated to Attendance Punch In Out.");
    }

    @When("I search timesheet for employee {string}")
    public void searchEmployeeTimesheet(String empName) {
        timePage.searchEmployeeTimesheet(empName);
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Timesheet_Search");
        Log.info("Searched timesheet for employee: " + empName);
    }

    // ==========================================
    // 4. RECRUITMENT STEPS
    // ==========================================
    @When("I navigate to the Recruitment module")
    public void navigateToRecruitment() {
        recruitmentPage.navigateToRecruitmentModule();
        Log.info("Navigated to Recruitment module.");
    }

    @And("the AI pre-flight agent validates all elements on the Recruitment page")
    public void validateRecruitmentElements() {
        recruitmentPage.validateAndHealPageElements();
    }

    @When("I click the Add Candidate button")
    public void clickAddCandidate() {
        recruitmentPage.clickAddCandidate();
        recruitmentPage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Add_Candidate");
        Log.info("Clicked Add Candidate button.");
    }

    @When("I filter candidates with name {string}")
    public void filterCandidates(String name) {
        recruitmentPage.filterCandidates(name);
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Candidates_Filtered");
        Log.info("Filtered candidates with name: " + name);
    }

    @When("I reset candidate filters")
    public void resetCandidateFilters() {
        recruitmentPage.resetCandidateFilters();
        Log.info("Reset candidate filters.");
    }

    @When("I navigate to the Vacancies tab")
    public void navigateToVacancies() {
        recruitmentPage.navigateToVacanciesTab();
        recruitmentPage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Vacancies_Tab");
        Log.info("Navigated to Vacancies tab.");
    }

    // ==========================================
    // 5. MY INFO STEPS
    // ==========================================
    @When("I navigate to the My Info module")
    public void navigateToMyInfo() {
        myInfoPage.navigateToMyInfo();
        Log.info("Navigated to My Info module.");
    }

    @And("the AI pre-flight agent validates all elements on the My Info page")
    public void validateMyInfoElements() {
        myInfoPage.validateAndHealPageElements();
    }

    @When("I navigate to the Contact Details section")
    public void navigateToContactDetails() {
        myInfoPage.navigateToContactDetails();
        myInfoPage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Contact_Details");
        Log.info("Navigated to Contact Details section.");
    }

    @When("I navigate to the Emergency Contacts section")
    public void navigateToEmergencyContacts() {
        myInfoPage.navigateToEmergencyContacts();
        myInfoPage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Emergency_Contacts");
        Log.info("Navigated to Emergency Contacts section.");
    }

    @When("I navigate to the Dependents section")
    public void navigateToDependents() {
        myInfoPage.navigateToDependents();
        myInfoPage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Dependents");
        Log.info("Navigated to Dependents section.");
    }

    @When("I update my nickname to {string}")
    public void updateNickname(String nickname) {
        myInfoPage.updateNickname(nickname);
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Nickname_Updated");
        Log.info("Updated nickname to: " + nickname);
    }

    // ==========================================
    // 6. DIRECTORY STEPS
    // ==========================================
    @When("I navigate to the Employee Directory module")
    public void navigateToDirectory() {
        directoryPage.navigateToDirectoryModule();
        Log.info("Navigated to Employee Directory module.");
    }

    @And("the AI pre-flight agent validates all elements on the Directory page")
    public void validateDirectoryElements() {
        directoryPage.validateAndHealPageElements();
    }

    @When("I search directory for employee {string}")
    public void searchDirectory(String name) {
        directoryPage.searchEmployeeInDirectory(name);
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Directory_Search");
        Log.info("Searched directory for employee: " + name);
    }

    @When("I reset directory filters")
    public void resetDirectoryFilters() {
        directoryPage.resetDirectoryFilters();
        Log.info("Reset directory filters.");
    }

    // ==========================================
    // 7. BUZZ SOCIAL FEED STEPS
    // ==========================================
    @When("I navigate to the Buzz module")
    public void navigateToBuzz() {
        buzzPage.navigateToBuzzModule();
        Log.info("Navigated to Buzz module.");
    }

    @And("the AI pre-flight agent validates all elements on the Buzz page")
    public void validateBuzzElements() {
        buzzPage.validateAndHealPageElements();
    }

    @When("I publish a buzz status update {string}")
    public void publishBuzzPost(String message) {
        buzzPage.createBuzzPost(message);
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Buzz_Post_Created");
        Log.info("Published buzz post: " + message);
    }

    @Then("I should see the Buzz photo and video sharing options")
    public void verifyBuzzShareOptions() {
        Assert.assertTrue(buzzPage.isSharePhotosButtonDisplayed() || buzzPage.isShareVideoButtonDisplayed(),
                "Buzz share options are not displayed!");
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Buzz_Share_Options");
        Log.info("Verified Buzz photo and video sharing options.");
    }

    // ==========================================
    // 8. CLAIM / EXPENSE STEPS
    // ==========================================
    @When("I navigate to the Claim module")
    public void navigateToClaim() {
        claimPage.navigateToClaimModule();
        Log.info("Navigated to Claim module.");
    }

    @And("the AI pre-flight agent validates all elements on the Claim page")
    public void validateClaimElements() {
        claimPage.validateAndHealPageElements();
    }

    @When("I navigate to the Submit Claim tab")
    public void navigateToSubmitClaim() {
        claimPage.navigateToSubmitClaimTab();
        claimPage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Submit_Claim");
        Log.info("Navigated to Submit Claim tab.");
    }

    @When("I navigate to the My Claims tab")
    public void navigateToMyClaims() {
        claimPage.navigateToMyClaimsTab();
        claimPage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_My_Claims");
        Log.info("Navigated to My Claims tab.");
    }

    @When("I search claims records")
    public void searchClaims() {
        claimPage.searchClaims();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Claims_Search");
        Log.info("Searched claims records.");
    }

    @When("I reset claim filters")
    public void resetClaimFilters() {
        claimPage.resetClaimFilters();
        Log.info("Reset claim filters.");
    }

    // ==========================================
    // 9. ADMIN JOB & CONFIGURATION STEPS
    // ==========================================
    @When("I navigate to the Job Titles management section")
    public void navigateToJobTitles() {
        adminJobPage.navigateToJobTitles();
        adminJobPage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Admin_Job_Titles");
        Log.info("Navigated to Job Titles section.");
    }

    @And("the AI pre-flight agent validates all elements on the Admin Job page")
    public void validateAdminJobElements() {
        adminJobPage.validateAndHealPageElements();
    }

    @When("I navigate to the Organization General Information section")
    public void navigateToGeneralInfo() {
        adminJobPage.navigateToGeneralInfo();
        adminJobPage.validateAndHealPageElements();
        ScreenshotUtils.captureAndSaveCustomScreenshot("Consumer_Admin_General_Info");
        Log.info("Navigated to Organization General Information section.");
    }

    @When("I click on the Admin Qualifications menu")
    public void clickQualificationsMenu() {
        adminJobPage.clickQualificationsMenu();
        Log.info("Clicked Qualifications menu.");
    }
}
