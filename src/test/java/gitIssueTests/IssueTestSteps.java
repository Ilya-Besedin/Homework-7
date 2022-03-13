package gitIssueTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueTestSteps {

    public static final String repository = "Ilya-Besedin/Homework-6";

    @Test
    //@Disabled
    public void testIssueLambdaSteps() {
        SelenideLogger.addListener("allureReports", new AllureSelenide());

        step("Open Github page", () -> {
            open("https://github.com/");
        });

        step("Search repository" + repository, () -> {
            $("[data-test-selector=nav-search-input]").setValue(repository).pressEnter();
        });

        step("Open repository page", () -> {
            $("ul.repo-list li").$("a").click();
        });

        step("Checking tab name", () -> {
            //at line 20 made special mistake in cssSelector (change # to .)
            $("#issues-tab").shouldHave(text("Issues"));
        });
    }

    @Test
    public void testIssueAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        IssueTestStepsAnnotation steps = new IssueTestStepsAnnotation();
        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.openRepository();
        steps.checkTabName();
        steps.takeScreenshot();
    }
}