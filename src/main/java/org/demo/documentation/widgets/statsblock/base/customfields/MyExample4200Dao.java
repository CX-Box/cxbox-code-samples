package org.demo.documentation.widgets.statsblock.base.customfields;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.statsblock.base.data.MyEntity4201Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4200Dao extends AbstractAnySourceBaseDAO<MyExample4200DTO> implements
        AnySourceBaseDAO<MyExample4200DTO> {


    public static final int ROWS_TOTAL = 2;

    public static final String COUNT_ROW_ID = "0";

    public static final String SUM_CUSTOM_FIELD_NUM = "1";


    private final MyEntity4201Repository repository;

    @Override
    public String getId(final MyExample4200DTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyExample4200DTO entity) {
        entity.setId(id);
    }

    @Override
    public MyExample4200DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyExample4200DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        return new PageImpl<>(getStats());
    }

    @Override
    public MyExample4200DTO update(BusinessComponent bc, MyExample4200DTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyExample4200DTO create(final BusinessComponent bc, final MyExample4200DTO entity) {
        throw new IllegalStateException();
    }

    @NonNull
    private List<MyExample4200DTO> getStats() {
        List<MyExample4200DTO> result = new ArrayList<>(ROWS_TOTAL);
        MyExample4200DTO newRow = new MyExample4200DTO()
                .setCustomFieldTitle("All record")
                .setCustomFieldValue(String.valueOf(repository.count()))
                .setCustomFieldIcon("team")
                .setCustomFieldDescription("Count row in table");
        newRow.setId(COUNT_ROW_ID);
        result.add(newRow);
        MyExample4200DTO newSum = new MyExample4200DTO()
                .setCustomFieldTitle("Custom Field Num Total")
                .setCustomFieldValue(String.valueOf(repository.customTotal()))
                .setCustomFieldIcon("team")
                .setCustomFieldDescription("Sum customFieldNum");
        newSum.setId(SUM_CUSTOM_FIELD_NUM);
        result.add(newSum);

        return result;
    }

}