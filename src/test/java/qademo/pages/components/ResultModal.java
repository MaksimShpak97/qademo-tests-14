package qademo.pages.components;

import qademo.pages.TestDate;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {

    public ResultModal checkVisible() {
        $("div.modal-content").should(appear);
        $("div.modal-header").$(byText(TestDate.getTitle_thanks())).shouldHave(text(TestDate.getTitle_thanks()));

        return this;
    }

    public ResultModal checkResult(String key, String value) {
        $(".table-responsive table").$(byText(key)).parent().shouldHave(text(value));

        return this;

    }

}
