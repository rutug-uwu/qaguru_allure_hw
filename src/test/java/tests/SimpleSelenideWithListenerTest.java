package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SimpleSelenideWithListenerTest {

    @BeforeAll
    static void setUp() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shouldFindIssueWithCorrectNumberTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $(".search-input-container").click();
        $("#query-builder-test").setValue("rutug-uwu/qaguru_allure_hw ").pressEnter();
        $(linkText("rutug-uwu/qaguru_allure_hw")).click();
        $("#issues-tab").click();

        $(withText("#1")).should(exist);
    }
}
