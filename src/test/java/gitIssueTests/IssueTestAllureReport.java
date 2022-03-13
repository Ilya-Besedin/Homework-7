package gitIssueTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class IssueTestAllureReport {

    @Test
    public void testIssueLabel() {
        // Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
        open("https://github.com/");
        //for nav-search-input no needs quotes, but for 'nav-search.input' it needs, use ''
        $("[data-test-selector=nav-search-input]").setValue("Ilya-Besedin/Homework-7").pressEnter();
        $("ul.repo-list li").$("a").click();
    }
}

