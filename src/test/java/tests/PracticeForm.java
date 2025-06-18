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



    @Test
    void fillAutoFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        // field NAME
        $("#firstName").setValue("Sergei");
        $("#lastName").setValue("Dorogavtsev");


        // field EMAIL
        $("#userEmail").setValue("kubus84@mail.ru");


        //GENDER selection
        $("#genterWrapper").$(byText("Male")).click();


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
        $("#uploadPicture").uploadFromClasspath("sibir.jpg");


        // field CurrentAddress
        $("#currentAddress").setValue("Russia,Nsk").pressEnter();


        // field State and City
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();


        // press to submit
        $("#submit").pressEnter();

        // check
        $(".table-responsive").shouldHave(text("Sergei Dorogavtsev"));
        $(".table-responsive").shouldHave(text("kubus84@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("89131234567"));
        $(".table-responsive").shouldHave(text("29 September,1984"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("sibir.jpg"));
        $(".table-responsive").shouldHave(text("Russia,Nsk"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }
}
