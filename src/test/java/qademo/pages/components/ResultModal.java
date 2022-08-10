package qademo.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {
    private static final String TITLE_TEXT = "Thanks for submitting the form";

    public ResultModal checkVisible() {
        $("div.modal-content").should(appear);
        $("div.modal-header").$(byText(TITLE_TEXT)).shouldHave(text(TITLE_TEXT));

        return this;
    }

    public ResultModal checkResult(String key, String value) {
        $(".table-responsive table").$(byText(key)).parent().shouldHave(text(value));

        return this;

    }

}
