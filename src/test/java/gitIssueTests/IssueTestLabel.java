package gitIssueTests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static gitIssueTests.IssueTestSteps.repository;
import static io.qameta.allure.Allure.*;
import static io.qameta.allure.Allure.getLifecycle;

public class IssueTestLabel {

    @Test
    @Owner("ibesedin")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Repository task")
    @Story("Creating new task")
    @DisplayName("Checking Issue tab in user's repository")
    @Description("The test checks availability of the Issue tab in the user's repository")
    @Link(value = "IssueTesting", url = "https://github.com")
    public void testAnnotatedLabels() {

    }

    @Test
    public void testDynamicLabels() {
        label("owner", "ibesedin");
        label("severity", SeverityLevel.CRITICAL.value());
        feature("Repository task");
        story("Creating new task");
        getLifecycle().updateTestCase(testCase -> {
            testCase.setName("Checking Issue tab in user's repository");
        });
        description("The test checks availability of the Issue tab in the user's repository");
        link("IssueTesting", "https://github.com");
    }

    @Test
    public void testParameters() {
        parameter("Repository", repository);
    }
}