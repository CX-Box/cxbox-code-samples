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
public class MyExample4206Dao extends AbstractAnySourceBaseDAO<MyExample4206DTO> implements
        AnySourceBaseDAO<MyExample4206DTO> {


    public static final int ROWS_TOTAL = 2;

    public static final String COUNT_ROW_ID = "0";

    public static final String SUM_CUSTOM_FIELD_NUM = "1";


    private final MyEntity4204Repository repository;

    @Override
    public String getId(final MyExample4206DTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyExample4206DTO entity) {
        entity.setId(id);
    }

    @Override
    public MyExample4206DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyExample4206DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        return new PageImpl<>(getStats());
    }

    @Override
    public MyExample4206DTO update(BusinessComponent bc, MyExample4206DTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyExample4206DTO create(final BusinessComponent bc, final MyExample4206DTO entity) {
        throw new IllegalStateException();
    }

    @NonNull
    private List<MyExample4206DTO> getStats() {
        List<MyExample4206DTO> result = new ArrayList<>(ROWS_TOTAL);
        MyExample4206DTO newRow = new MyExample4206DTO()
                .setTitle("New Clients")
                .setValue(repository.count())
                .setColor("#779FE9")
                .setIcon("team") //same as in screen.json icon
                .setDescription("New Clients. Press to filter List below");
        newRow.setId(COUNT_ROW_ID);
        result.add(newRow);
        MyExample4206DTO newSum = new MyExample4206DTO()
                .setTitle("New Clients")
                .setValue(repository.count())
                .setColor("#779FE9")
                .setIcon("team") //same as in screen.json icon
                .setDescription("New Clients. Press to filter List below");
        newRow.setId(COUNT_ROW_ID);
        newSum.setId(SUM_CUSTOM_FIELD_NUM);
        result.add(newSum);

        return result;
    }

}