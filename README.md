# 🏢 OrangeHRM Enterprise Test Automation Project (Standalone SDK Consumer)

A production-ready, standalone Behavior-Driven Development (BDD) test automation suite automating the **OrangeHRM Enterprise Portal**. This project is powered by the **AI-Powered Test Automation Framework Core SDK** (`com.automation:ai-automation-core:1.0.0`).

> **Zero Infrastructure Boilerplate**: This consumer project contains **zero** browser initialization or driver setup code, **zero** custom wait logic, and **zero** brittle locator try-catches. All infrastructure capabilities (parallel ThreadLocal drivers, multi-provider AI self-healing, 17 UI components, test data management, user leasing, and telemetry) are inherited directly from the Core SDK dependency.

---

## 📋 Table of Contents
1. [Architecture & Decoupled SDK Model](#1-architecture--decoupled-sdk-model)
2. [Prerequisites & GitHub Packages Authentication](#2-prerequisites--github-packages-authentication)
3. [Project Directory Layout](#3-project-directory-layout)
4. [Included 16 Enterprise Module Feature Suites](#4-included-16-enterprise-module-feature-suites)
5. [How to Author Tests with the Core SDK](#5-how-to-author-tests-with-the-core-sdk)
   - [5.1 Creating Page Objects Extending `BasePage`](#51-creating-page-objects-extending-basepage)
   - [5.2 Using Pre-Built Enterprise UI Components](#52-using-pre-built-enterprise-ui-components)
   - [5.3 Writing Gherkin Feature Files](#53-writing-gherkin-feature-files)
   - [5.4 Writing Cucumber Step Definitions with `TestContext`](#54-writing-cucumber-step-definitions-with-testcontext)
   - [5.5 TestNG Runner Configuration](#55-testng-runner-configuration)
6. [Test Data Management (TDM) Engine](#6-test-data-management-tdm-engine)
   - [6.1 Zero-Model Dynamic JSON Dot-Path Queries](#61-zero-model-dynamic-json-dot-path-queries)
   - [6.2 Synthetic Dynamic Data Generation](#62-synthetic-dynamic-data-generation)
   - [6.3 Thread-Safe Cross-Step Scenario Context](#63-thread-safe-cross-step-scenario-context)
7. [Comprehensive Configuration Properties Reference](#7-comprehensive-configuration-properties-reference)
8. [Multi-Provider AI Self-Healing Configuration](#8-multi-provider-ai-self-healing-configuration)
9. [Running Tests Locally & Parallel Execution](#9-running-tests-locally--parallel-execution)
10. [Running on Selenium Grid, Docker & Cloud Platforms](#10-running-on-selenium-grid-docker--cloud-platforms)
11. [Observability, Reports & Telemetry Server](#11-observability-reports--telemetry-server)
12. [AST Git Auto-Patcher & Pull Request Generator](#12-ast-git-auto-patcher--pull-request-generator)
13. [Troubleshooting & Frequently Asked Questions (FAQ)](#13-troubleshooting--frequently-asked-questions-faq)

---

## 1. Architecture & Decoupled SDK Model

This project is an independent consumer application. It resolves the framework engine directly from **GitHub Packages**:

```xml
<repositories>
    <repository>
        <id>github</id>
        <name>GitHub Packages</name>
        <url>https://maven.pkg.github.com/Parvez414/ai-powered-test-automation-platform</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>

<dependencies>
    <!-- AI-Powered Test Automation Framework Core SDK -->
    <dependency>
        <groupId>com.automation</groupId>
        <artifactId>ai-automation-core</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### What the Core SDK Automatically Manages for This Project:
* **ThreadLocal WebDriver Isolation**: Handles Chrome, Firefox, Edge, Safari, Grid 4, and Cloud instances with anti-bot evasion flags and automatic lifecycle teardown.
* **Universal DOM Crawler (`DOMAnalyzer`)**: Single-batch in-browser JavaScript evaluation extracting interactive candidates and shadow DOM trees in $< 50\text{ms}$.
* **Multi-Tier AI Self-Healing Engine**: Offline heuristic scoring combined with dynamic escalation to Google Gemini, Anthropic Claude, OpenAI, Azure OpenAI, or Local Ollama.
* **17 Enterprise UI Components**: Drop-in wrappers for AntDesign, Web Components (Shadow DOM), AG-Grid, Select, Modals, DatePickers, and Tabs.
* **Zero-Boilerplate Test Data Management**: Dynamic JSON querying via dot-notation, synthetic data generators, and thread-safe scenario state stores.
* **Role-Based User Session Pool (`UserManager`)**: Leases unique user credentials to parallel threads, eliminating concurrency lockouts.
* **Automatic Retry Analyzer (`RetryAnalyzer`)**: Re-runs flaky tests up to configured retry limits.
* **Observability & Telemetry Hub**: Generates standalone HTML dashboards, writes JSON healing histories, and streams metrics to the platform server on port `8080`.

---

## 2. Prerequisites & GitHub Packages Authentication

### System Requirements
| Requirement | Recommended Version | Verification Command |
| :--- | :--- | :--- |
| **Java JDK** | JDK 17 LTS or 21 LTS | `java -version` |
| **Apache Maven** | Maven 3.8.0+ | `mvn -version` |
| **Web Browsers** | Google Chrome / Mozilla Firefox / Microsoft Edge | Installed on machine / CI |

### 🔑 Zero Manual JAR Installation via GitHub Packages
The Core Engine SDK is hosted on **GitHub Packages**. No manual JAR download or `mvn install:install-file` is needed!

Configure your `~/.m2/settings.xml` (Windows: `C:\Users\<user>\.m2\settings.xml`):

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                              http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <servers>
    <server>
      <id>github</id>
      <username>YOUR_GITHUB_USERNAME</username>
      <!-- Set GITHUB_TOKEN environment variable or paste PAT directly -->
      <password>${env.GITHUB_TOKEN}</password>
    </server>
  </servers>
</settings>
```

> **Personal Access Token Scope**: Generate your token at GitHub → Settings → Developer Settings → Personal Access Tokens with `read:packages` checked. In GitHub Actions, `${{ secrets.GITHUB_TOKEN }}` is pre-authenticated automatically.

---

## 3. Project Directory Layout

```text
orangeHr-consumer-project/
├── pom.xml                                      # Consumer POM declaring the Core SDK dependency
├── README.md                                    # (This file) Complete standalone consumer manual
│
└── src/test/
    ├── java/com/mycompany/tests/
    │   ├── pages/                               # Page Objects (Extending BasePage)
    │   │   ├── OrangeHrmBasePage.java           # Base layout (navigation bar, common elements)
    │   │   ├── ConsumerLoginPage.java           # Authentication page
    │   │   ├── ConsumerDashboardPage.java       # Post-login portal landing
    │   │   ├── ConsumerDashboardWidgetsPage.java# Canvas charts, buzz feed, quick tiles
    │   │   ├── ConsumerAdminUsersPage.java      # System users filtering & management
    │   │   ├── ConsumerAdminJobPage.java        # Job titles, pay grades, employment status
    │   │   ├── ConsumerAddEmployeePage.java     # Multi-step PIM employee creation
    │   │   ├── ConsumerEmployeeListPage.java    # PIM employee directory & filters
    │   │   ├── ConsumerLeavePage.java           # Apply leave, balances, entitlements
    │   │   ├── ConsumerTimePage.java            # Timesheets, punch in/out attendance
    │   │   ├── ConsumerRecruitmentPage.java     # Candidate pipelines & vacancy filters
    │   │   ├── ConsumerMyInfoPage.java          # Personal details & attachment uploads
    │   │   ├── ConsumerDirectoryPage.java       # Directory card search & profile modals
    │   │   ├── ConsumerClaimPage.java           # Medical/travel expense claim records
    │   │   ├── ConsumerBuzzPage.java            # Social newsfeed posts, likes, comments
    │   │   ├── ConsumerForgotPasswordPage.java  # Reset password request form
    │   │   └── ConsumerHealingDemoPage.java     # Deliberately broken locator demonstration
    │   │
    │   ├── stepdefinitions/                     # Cucumber Step Definitions
    │   │   ├── ConsumerLoginSteps.java
    │   │   ├── ConsumerAuthAndHeaderSteps.java
    │   │   ├── ConsumerDashboardWidgetsSteps.java
    │   │   ├── ConsumerAdminSteps.java
    │   │   ├── ConsumerEmployeeSteps.java
    │   │   ├── ConsumerHRModulesSteps.java
    │   │   ├── ConsumerHealingSteps.java
    │   │   └── ConsumerDataDrivenSteps.java
    │   │
    │   └── runners/
    │       └── ConsumerTestRunner.java          # TestNG Cucumber Runner with parallel execution
    │
    └── resources/
        ├── config/                              # Configuration Profiles
        │   ├── config.properties                # Base configuration (execution, AI, timeouts)
        │   └── qa.properties                    # QA environment URLs and credentials
        │
        ├── data/                                # Test Data Management JSON Files
        │   ├── admin-filters.json               # Filter queries for Admin module
        │   └── users.json                       # Thread-safe user session leasing pool
        │
        └── features/                            # 16 Enterprise Gherkin Feature Files
            ├── ConsumerLogin.feature
            ├── ConsumerAuthAndHeader.feature
            ├── ConsumerDashboardWidgets.feature
            ├── ConsumerAdminUserManagement.feature
            ├── ConsumerAdminJobAndOrg.feature
            ├── ConsumerAddEmployee.feature
            ├── ConsumerEmployeeDirectory.feature
            ├── ConsumerLeaveManagement.feature
            ├── ConsumerTimeTracking.feature
            ├── ConsumerRecruitmentManagement.feature
            ├── ConsumerMyInfoProfile.feature
            ├── ConsumerDirectory.feature
            ├── ConsumerClaimManagement.feature
            ├── ConsumerBuzzNewsfeed.feature
            ├── ConsumerAISelfHealing.feature
            └── ConsumerDataDriven.feature
```

---

## 4. Included 16 Enterprise Module Feature Suites

| # | Feature File | Module | Page Objects Used | Scenario Scope & Capabilities |
| :- | :--- | :--- | :--- | :--- |
| 1 | **`ConsumerLogin.feature`** | Authentication | `ConsumerLoginPage`<br>`ConsumerDashboardPage` | Valid login, invalid credentials rejection, empty field assertions, and pre-flight health checks. |
| 2 | **`ConsumerAuthAndHeader.feature`** | Navigation Header | `ConsumerHeaderPage` | Top bar user profile flyout, change password, about modal dialog, and secure logout. |
| 3 | **`ConsumerDashboardWidgets.feature`** | Dashboard Widgets | `ConsumerDashboardWidgetsPage` | Quick Launch action shortcuts, My Actions pending tasks, Employee Distribution charts, Buzz newsfeed tiles. |
| 4 | **`ConsumerAdminUserManagement.feature`** | Admin Users | `ConsumerAdminUsersPage` | Search users by username, role select dropdown, status select, and reset table filter buttons. |
| 5 | **`ConsumerAdminJobAndOrg.feature`** | Admin Org & Job | `ConsumerAdminJobPage` | Job titles management, pay grades, employment status, work shifts, and company organization hierarchy. |
| 6 | **`ConsumerAddEmployee.feature`** | PIM Employee | `ConsumerAddEmployeePage` | Add employee form, auto-generated employee ID tracking, login details toggle, and profile image upload. |
| 7 | **`ConsumerEmployeeDirectory.feature`** | PIM Directory | `ConsumerEmployeeListPage` | Search employees by full name, supervisor name filter, sub-unit dropdown, and records table verification. |
| 8 | **`ConsumerLeaveManagement.feature`** | Leave | `ConsumerLeavePage` | Apply for leave, check leave entitlement balances, review leave calendar, and assign leave to staff. |
| 9 | **`ConsumerTimeTracking.feature`** | Time & Attendance | `ConsumerTimePage` | Employee timesheet logging, punch in / punch out timecards, attendance summary reports, and project tracking. |
| 10 | **`ConsumerRecruitmentManagement.feature`** | Recruitment | `ConsumerRecruitmentPage` | Candidate pipeline review, interview schedule status, vacancy job title filters, and candidate resumes. |
| 11 | **`ConsumerMyInfoProfile.feature`** | My Info | `ConsumerMyInfoPage` | Personal details update, contact details, emergency contacts, dependents list, and custom attachments upload. |
| 12 | **`ConsumerDirectory.feature`** | Directory | `ConsumerDirectoryPage` | Employee cards directory view, search by job title, location filter, and profile detail popups. |
| 13 | **`ConsumerClaimManagement.feature`** | Claims | `ConsumerClaimPage` | Submit expense claims (Medical, Travel), assign claims, review approval status, and inspect event records. |
| 14 | **`ConsumerBuzzNewsfeed.feature`** | Buzz Newsfeed | `ConsumerBuzzPage` | Create newsfeed updates, share links, like employee posts, write comments, and delete post updates. |
| 15 | **`ConsumerAISelfHealing.feature`** | Self-Healing Demo | `ConsumerHealingDemoPage` | Injects deliberate broken locator (`invalid_broken_consumer_user_input_99999`) auto-healed in real time. |
| 16 | **`ConsumerDataDriven.feature`** | Data-Driven TDM | `ConsumerAdminUsersPage` | Zero-model dynamic JSON test data queries (`data/admin-filters.json`) with synthetic data generation. |

---

## 5. How to Author Tests with the Core SDK

### 5.1 Creating Page Objects Extending `BasePage`
All page objects must inherit from `com.automation.pages.BasePage`. Register elements using `register()` so the AI self-healing engine can track and repair them if UI changes occur:

```java
package com.mycompany.tests.pages;

import com.automation.ai.PageElement;
import com.automation.components.ButtonComponent;
import com.automation.components.SelectComponent;
import com.automation.pages.BasePage;
import org.openqa.selenium.By;

public class ConsumerAdminUsersPage extends BasePage {

    // Registered PageElements (Eligible for AI self-healing)
    public PageElement usernameInput;
    public PageElement searchButton;
    public PageElement recordsFoundLabel;

    // Pre-built Enterprise UI Components
    public SelectComponent roleSelect;
    public SelectComponent statusSelect;
    public ButtonComponent searchBtn;

    public ConsumerAdminUsersPage() {
        super("ConsumerAdminUsersPage");
    }

    @Override
    protected void initElements() {
        // Register PageElements with logical names and descriptions
        usernameInput = register("usernameInput", "Username filter text field",
                By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input"));

        searchButton = register("searchButton", "Filter search submit button",
                By.xpath("//button[@type='submit']"));

        recordsFoundLabel = register("recordsFoundLabel", "System users records found count label",
                By.xpath("//span[contains(.,'Records Found') or contains(.,'Record Found')]"));

        // Initialize reusable UI components using the SDK's reflection factory
        roleSelect = initComponent(SelectComponent.class,
                By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));

        statusSelect = initComponent(SelectComponent.class,
                By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"));

        searchBtn = initComponent(ButtonComponent.class, By.xpath("//button[@type='submit']"));
    }

    // Business Methods
    public void filterUsers(String username, String role, String status) {
        if (username != null && !username.isEmpty()) {
            sendKeys(usernameInput, username);
        }
        if (role != null && !role.isEmpty()) {
            roleSelect.selectByText(role);
        }
        if (status != null && !status.isEmpty()) {
            statusSelect.selectByText(status);
        }
        searchBtn.click();
    }

    public String getRecordsFoundText() {
        return getText(recordsFoundLabel);
    }
}
```

---

### 5.2 Using Pre-Built Enterprise UI Components
The Core SDK provides 17 out-of-the-box UI component classes. Simply initialize them using `initComponent()`:

| Component Class | Example Usage |
| :--- | :--- |
| **`SelectComponent`** | `roleSelect.selectByText("Admin");`<br>`roleSelect.getSelectedText();` |
| **`ButtonComponent`** | `submitButton.click();` *(Waits for loading spinners to clear automatically)* |
| **`AgGridComponent`** | `usersGrid.getCellValue(0, "Username");`<br>`usersGrid.clickRowAction(0, "Edit");` |
| **`DatePickerComponent`**| `datePicker.typeDate("2026-09-15");`<br>`datePicker.selectDate(2026, 9, 15);` |
| **`ModalComponent`** | `confirmModal.waitForOpen(5);`<br>`confirmModal.clickConfirm();` |
| **`TabsComponent`** | `navigationTabs.selectTab("Personal Details");` |
| **`AccordionComponent`**| `accordion.expandSection("Employment History");` |
| **`ToastComponent`** | `toast.waitForToastMessage("Successfully Saved", 5);` |
| **`WebComponent`** | `webComponent.pierceShadow("input.internal-field").sendKeys("value");` |

---

### 5.3 Writing Gherkin Feature Files
Store feature files under `src/test/resources/features/`:

```gherkin
@Admin @Regression
Feature: Admin System Users Management

  Background:
    Given user navigates to the OrangeHRM login page
    And user logs in with standard credentials
    And user navigates to the Admin module

  @Smoke
  Scenario: Filter system users by role and status
    When user filters system users with role "Admin" and status "Enabled"
    Then the system users table should display at least 1 record
```

---

### 5.4 Writing Cucumber Step Definitions with `TestContext`
Use PicoContainer dependency injection to share state and access page objects cleanly:

```java
package com.mycompany.tests.stepdefinitions;

import com.automation.context.TestContext;
import com.mycompany.tests.pages.ConsumerAdminUsersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ConsumerAdminSteps {

    private final TestContext context;
    private final ConsumerAdminUsersPage adminUsersPage;

    public ConsumerAdminSteps(TestContext context) {
        this.context = context;
        this.adminUsersPage = new ConsumerAdminUsersPage();
    }

    @When("user filters system users with role {string} and status {string}")
    public void userFiltersSystemUsers(String role, String status) {
        adminUsersPage.filterUsers("", role, status);
    }

    @Then("the system users table should display at least 1 record")
    public void verifyRecordsDisplayed() {
        String recordsText = adminUsersPage.getRecordsFoundText();
        Assert.assertTrue(recordsText.contains("Record"), "Expected records to be displayed but got: " + recordsText);
    }
}
```

---

### 5.5 TestNG Runner Configuration
The runner extends `AbstractTestNGCucumberTests` and configures parallel thread execution:

```java
package com.mycompany.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "com.mycompany.tests.stepdefinitions",
                "com.automation.hooks"              // Core SDK lifecycle hooks
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class ConsumerTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
```

---

## 6. Test Data Management (TDM) Engine

The SDK provides a complete, zero-model test data management engine:

### 6.1 Zero-Model Dynamic JSON Dot-Path Queries
Query any JSON file in `src/test/resources/data/*.json` directly using dot-notation without creating Java DTO / POJO classes:

```java
import com.automation.data.TestData;
import com.automation.data.TestDataManager;

// Option 1: Load dataset object
TestData data = TestDataManager.getData("admin-filters.activeAdmin");
String role = data.getString("role");       // "Admin"
String status = data.getString("status");   // "Enabled"

// Option 2: Query directly using dot-notation
String role = TestDataManager.getString("admin-filters.activeAdmin.role");
```

### 6.2 Synthetic Dynamic Data Generation
Generate unique data at runtime to prevent duplicate data collisions during parallel multi-threaded test runs:

```java
import com.automation.data.DataGenerator;

String name = DataGenerator.fullName();          // e.g. "Sophia Vance"
String email = DataGenerator.uniqueEmail();       // e.g. "user_1724678@example.com"
String phone = DataGenerator.phoneNumber();       // e.g. "555-019-2834"
String street = DataGenerator.streetAddress();    // e.g. "742 Evergreen Terrace"
```

### 6.3 Thread-Safe Cross-Step Scenario Context
Pass runtime scenario data (such as an auto-generated employee ID) between step definition methods safely:

```java
import com.automation.data.ScenarioContext;

// In Step 1 (Create Employee):
ScenarioContext.set("CURRENT_EMP_ID", generatedEmpId);

// In Step 2 (Search Employee):
String empId = ScenarioContext.getString("CURRENT_EMP_ID");
```

---

## 7. Comprehensive Configuration Properties Reference

All parameters can be configured in `src/test/resources/config/config.properties` or overridden on the command line via `-Dkey=value`:

| Property Key | Default | Description |
| :--- | :---: | :--- |
| `environment` | `qa` | Environment profile (`qa.properties`, `dev.properties`, `staging.properties`). |
| `execution.mode` | `local` | Execution platform: `local`, `grid`, `docker`, or `cloud`. |
| `browser` | `chrome` | Browser engine: `chrome`, `firefox`, `edge`, `safari`. |
| `headless` | `false` | Run browser in headless mode (`true` for CI/CD pipelines). |
| `timeout.explicit` | `15` | Default explicit wait timeout in seconds. |
| `timeout.pageload` | `60` | Browser page load timeout in seconds. |
| `timeout.polling.ms` | `500` | FluentWait polling interval in milliseconds. |
| `thread.count` | `2` | Parallel thread count for scenario execution. |
| `test.retry.count` | `1` | Automatic retry count for flaky test scenarios. |
| `execution.delay.ms` | `0` | Pacing delay between browser interactions in milliseconds. |
| `element.highlight` | `false` | Visually highlights interactive elements with a dashed border. |
| `ai.healing.enabled` | `true` | Master switch for AI self-healing. |
| `ai.healing.provider` | `hybrid` | Provider: `heuristic`, `gemini`, `claude`, `openai`, `ollama`, `hybrid`, `auto`. |
| `ai.provider.fallback` | `gemini` | Standby secondary provider in failover cascade. |
| `ai.heuristic.escalation.threshold` | `0.70` | Confidence score below which requests escalate to LLM. |
| `ai.circuit.breaker.cooldown.seconds`| `30` | Duration to pause a rate-limited (HTTP 429) AI provider. |
| `ai.telemetry.enabled` | `true` | Stream healing telemetry to central dashboard server. |
| `ai.telemetry.url` | `http://localhost:8080/api/telemetry/report` | Telemetry ingestion endpoint. |
| `user.session.mode` | `shared` | User account leasing mode (`pool` for dedicated accounts, `shared`). |

---

## 8. Multi-Provider AI Self-Healing Configuration

The consumer suite supports 5 GenAI providers. Configure your API key via environment variables or properties:

```properties
# Active Provider Selection
ai.healing.enabled=true
ai.healing.provider=hybrid
ai.provider.fallback=gemini
ai.heuristic.escalation.threshold=0.70

# 1. Google Gemini (Recommended for speed & cost)
ai.gemini.api.key=YOUR_GEMINI_API_KEY
ai.gemini.model=gemini-2.5-flash

# 2. Anthropic Claude
ai.claude.api.key=YOUR_ANTHROPIC_API_KEY
ai.claude.model=claude-3-5-haiku-20241022

# 3. OpenAI
ai.openai.api.key=YOUR_OPENAI_API_KEY
ai.openai.model=gpt-4o-mini

# 4. Azure OpenAI Enterprise
ai.azure.openai.endpoint=https://your-resource.openai.azure.com/
ai.azure.openai.api.key=YOUR_AZURE_KEY
ai.azure.openai.deployment.name=gpt-4o-mini

# 5. Local Ollama (100% Offline / Zero Cloud Cost)
ai.ollama.base.url=http://localhost:11434
ai.ollama.model=deepseek-r1:8b
```

---

## 9. Running Tests Locally & Parallel Execution

### Run the Entire 16-Module Suite
```bash
mvn clean test
```

### Run in Headless Mode with 4 Parallel Threads
```bash
mvn test -Dheadless=true -Ddataproviderthreadcount=4
```

### Run by Specific Cucumber Tag
```bash
# Run only Smoke tests
mvn test -Dcucumber.filter.tags="@Smoke"

# Run Admin module tests
mvn test -Dcucumber.filter.tags="@Admin"

# Run Leave and Time tracking tests
mvn test -Dcucumber.filter.tags="@Leave or @Time"

# Run the AI self-healing verification scenario
mvn test -Dcucumber.filter.tags="@SelfHealing"
```

### Cross-Browser Testing
```bash
mvn test -Dbrowser=firefox -Dheadless=true
mvn test -Dbrowser=edge -Dheadless=true
```

---

## 10. Running on Selenium Grid, Docker & Cloud Platforms

### Running on Selenium Grid 4
```bash
mvn test -Dexecution.mode=grid -Dgrid.url=http://localhost:4444/wd/hub -Dbrowser=chrome -Dheadless=true
```

### Running on Cloud Grids (BrowserStack / SauceLabs / LambdaTest)
```bash
mvn test -Dexecution.mode=cloud \
         -Dcloud.provider=browserstack \
         -Dcloud.username="YOUR_USERNAME" \
         -Dcloud.access.key="YOUR_ACCESS_KEY" \
         -Dcloud.os="Windows" \
         -Dcloud.os.version="11" \
         -Dbrowser="chrome"
```

---

## 11. Observability, Reports & Telemetry Server

### 1. Standalone HTML Executive Report
Every test run automatically generates an interactive HTML dashboard containing ROI metrics, pass/fail ratios, and self-healing confidence charts:
```text
target/ai-dashboard/index.html
```

### 2. AI Element Healing Audit History
Detailed technical audit logs of every healed locator are stored in:
```text
target/element-healing-history.json
```

### 3. Allure Interactive Report
```bash
mvn allure:serve
```

### 4. Centralized Telemetry Dashboard Server (Web Control Center)
To stream results from this consumer node to the central web portal running on port `8080` (accessible at `http://localhost:8080`):
```properties
ai.telemetry.enabled=true
ai.telemetry.url=http://localhost:8080/api/telemetry/report
```

---

## 12. AST Git Auto-Patcher & Pull Request Generator

When locators drift or break on dynamic web pages, the SDK heals them in memory. To permanently update your Java Page Object `.java` source files in Git, run the auto-patcher:

```bash
# Dry run (inspect proposed code patches without writing)
mvn test-compile exec:java -Dexec.mainClass="com.automation.ai.patcher.GitAutoPatcher" -Dexec.args="--dry-run"

# Automatically modify Java files, create a git branch, and open a PR
mvn test-compile exec:java -Dexec.mainClass="com.automation.ai.patcher.GitAutoPatcher" -Dexec.args="--auto-pr"
```

---

## 13. Troubleshooting & Frequently Asked Questions (FAQ)

### Q1: `NoSuchElementException` occurs and healing does not trigger.
* **Resolution**: Ensure the element is wrapped with `register()` in your Page Object. The SDK only auto-heals registered `PageElement` instances. Also check that `ai.healing.enabled=true` in `config.properties`.

### Q2: LLM healing returns `API Key Not Configured` warning.
* **Resolution**: The framework gracefully fell back to offline deterministic heuristics ($< 5\text{ms}$). To enable LLM reasoning, export `GEMINI_API_KEY` (or `OPENAI_API_KEY`, `ANTHROPIC_API_KEY`) in your environment.

### Q3: `NoSuchSessionException` during parallel execution.
* **Resolution**: Ensure you are using `DriverManager.getDriver()` rather than holding a static `WebDriver` reference. Each thread must retrieve its isolated instance.

### Q4: Elements inside Shadow DOM are not clickable.
* **Resolution**: Standard Selenium `By.xpath()` cannot cross shadow boundaries. Use `WebComponent.pierceShadow("css-selector")` to access shadow DOM elements.
