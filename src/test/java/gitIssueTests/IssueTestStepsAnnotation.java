package gitIssueTests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueTestStepsAnnotation {

    @Step("Open Github page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search repository {repo}")
    public void searchForRepository(String repository) {
        $("[data-test-selector=nav-search-input]").setValue(repository).pressEnter();
    }

    @Step("Open repository {repo}")
    public void openRepository() {
        $("ul.repo-list li").$("a").click();
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Checking tab name")
    public void checkTabName() {
        $("#issues-tab").shouldHave(text("Issues"));
    }
}

