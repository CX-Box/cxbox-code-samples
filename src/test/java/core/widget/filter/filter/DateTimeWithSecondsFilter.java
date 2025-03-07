package core.widget.filter.filter;


import core.widget.ListHelper;
import core.widget.modal.Calendar;

import java.time.LocalDateTime;

public class DateTimeWithSecondsFilter extends AbstractFilter<LocalDateTime> {
    public DateTimeWithSecondsFilter(String columnType, String columnName, ListHelper helper) {
        super(columnType, columnName, helper);
    }

    @Override
    public void setFilter(LocalDateTime value) {
        Calendar.setDateTimeWithSecond(value);
        setApply();
    }

    @Override
    public String getTypeFilter() {
        return "dateTimeWithSeconds";
    }
}
