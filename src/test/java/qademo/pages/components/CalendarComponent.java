package qademo.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setYear(String year) {
        $(".react-datepicker__year-select").selectOptionByValue(year);

    }

    public void setMonth(String month) {
        $(".react-datepicker__month-select").selectOptionByValue(month);

    }

    public void setDay(String day) {
        $(".react-datepicker__day--0" + day).click();

    }


}
