package gitIssueTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class IssueTestAllureReport {

    @Test
    public void testIssueLabel() {
        SelenideLogger.addListener("allureReports", new AllureSelenide());

        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("Ilya-Besedin/Homework-7").pressEnter();
        $("ul.repo-list li").$("a").click();
        //at line 20 made special mistake in cssSelector (change # to .)
        $(".issues-tab").shouldHave(text("Issues"));
    }
}

