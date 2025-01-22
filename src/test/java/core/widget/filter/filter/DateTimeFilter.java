package core.widget.filter.filter;

import core.widget.ListHelper;
import core.widget.modal.Calendar;

import java.time.LocalDateTime;

public class DateTimeFilter extends AbstractFilter<LocalDateTime> {
    public DateTimeFilter(String columnType, String columnName, ListHelper helper) {
        super(columnType, columnName, helper);
    }

    @Override
    public void setFilter(LocalDateTime value) {
        Calendar.setDateTime(value);
        setApply();
    }

    @Override
    public String getTypeFilter() {
        return "dateTime";
    }
}
