package gitIssueTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueTestSteps {

    private static final String repository = "Ilya-Besedin/Homework-7";

    @Test
    public void testIssueSteps() {
        SelenideLogger.addListener("allureReports", new AllureSelenide());

        step("Open Github page", () -> {
            open("https://github.com/");
        });

        step("Search repository", () -> {
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
}

