package core.widget.filter.filter;

import core.widget.ListHelper;
import core.widget.modal.Calendar;

import java.time.LocalDate;

public class DateFilter extends AbstractFilter<LocalDate> {
    public DateFilter(String columnType, String columnName, ListHelper helper) {
        super(columnType, columnName, helper);
    }

    @Override
    public void setFilter(LocalDate value) {
        Calendar.setDate(value);
        setApply();
    }

    @Override
    public String getTypeFilter() {
        return "date";
    }
}
