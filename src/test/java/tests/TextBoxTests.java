package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");

        $("#userName").setValue("Sergei").pressEnter();
        $("#userEmail").setValue("kubus84@mail.ru").pressEnter();
        $("#currentAddress").setValue("Russia,Nsk").pressEnter();
        $("#permanentAddress").setValue("Russia,Nsk").pressEnter();
        $("#submit").click();

        $("#output #name").shouldHave(text("Sergei"));
        $("#output #email").shouldHave(text("kubus84@mail.ru"));
        $("#output #currentAddress").shouldHave(text("Russia,Nsk"));
        $("#output #permanentAddress").shouldHave(text("Russia,Nsk"));
    }
}
