package org.demo.documentation.widgets.statsblock.color.colorconst;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.statsblock.color.data.MyEntity4204Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4205Dao extends AbstractAnySourceBaseDAO<MyExample4205DTO> implements
        AnySourceBaseDAO<MyExample4205DTO> {


    public static final int ROWS_TOTAL = 2;

    public static final String COUNT_ROW_ID = "0";

    public static final String SUM_CUSTOM_FIELD_NUM = "1";


    private final MyEntity4204Repository repository;

    @Override
    public String getId(final MyExample4205DTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyExample4205DTO entity) {
        entity.setId(id);
    }

    @Override
    public MyExample4205DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyExample4205DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        return new PageImpl<>(getStats());
    }

    @Override
    public MyExample4205DTO update(BusinessComponent bc, MyExample4205DTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyExample4205DTO create(final BusinessComponent bc, final MyExample4205DTO entity) {
        throw new IllegalStateException();
    }

    @NonNull
    private List<MyExample4205DTO> getStats() {
        List<MyExample4205DTO> result = new ArrayList<>(ROWS_TOTAL);
        MyExample4205DTO newRow = new MyExample4205DTO()
                .setTitle("All record")
                .setValue(repository.count())
                .setIcon("team")
                .setDescription("Count rows in table");
        newRow.setId(COUNT_ROW_ID);
        result.add(newRow);


        return result;
    }

}