package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }
    @AfterAll
    static void tearDown() {
        CloseWebDriver();
    }

    private static void CloseWebDriver() {
    }


    @Test
    void fillAutoFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // field NAME
        $("#firstName").setValue("Sergei");
        $("#lastName").setValue("Dorogavtsev");

        // field EMAIL
        $("#userEmail").setValue("kubus84@mail.ru");

        //GENDER selection
        $("#genderWrapper").$(byText("Male")).click();

        // field MOBILE
        $("#userNumber").setValue("89131234567");

        // field DateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__day--029").click();

        // field SUBJECTS
        $("#subjectsInput").setValue("English").pressEnter();

        // HOBBIES selection
        $("#hobbiesWrapper").$(byText("Music")).click();

        // field PICTURE
        $("#uploadPicture").uploadFromClasspath(".jpg");




        $("#currentAddress").setValue("Russia,Nsk").pressEnter();
        $("#permanentAddress").setValue("Russia,Nsk").pressEnter();
        $("#submit").click();

        $("#output #name").shouldHave(text("Sergei"));
        $("#output #email").shouldHave(text("kubus84@mail.ru"));
        $("#output #currentAddress").shouldHave(text("Russia,Nsk"));
        $("#output #permanentAddress").shouldHave(text("Russia,Nsk"));
    }
}
