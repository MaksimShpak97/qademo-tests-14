package qademo.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public CalendarComponent setYear(String year) {
        $(".react-datepicker__year-select").selectOptionByValue(year);

        return this;
    }

    public CalendarComponent setMonth(String month) {
        $(".react-datepicker__month-select").selectOptionByValue(month);


        return this;
    }

    public CalendarComponent setDay(String day) {
        $(".react-datepicker__day--0" + day).click();

        return this;
    }


}
