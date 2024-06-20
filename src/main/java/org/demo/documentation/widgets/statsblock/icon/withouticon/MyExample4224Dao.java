package org.demo.documentation.widgets.statsblock.icon.withouticon;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;

import org.demo.documentation.widgets.statsblock.icon.data.MyEntity4222Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4224Dao extends AbstractAnySourceBaseDAO<MyExample4224DTO> implements
        AnySourceBaseDAO<MyExample4224DTO> {


    public static final int ROWS_TOTAL = 2;

    public static final String COUNT_ROW_ID = "0";

    private final MyEntity4222Repository repository;

    @Override
    public String getId(final MyExample4224DTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyExample4224DTO entity) {
        entity.setId(id);
    }

    @Override
    public MyExample4224DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyExample4224DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        return new PageImpl<>(getStats());
    }

    @Override
    public MyExample4224DTO update(BusinessComponent bc, MyExample4224DTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyExample4224DTO create(final BusinessComponent bc, final MyExample4224DTO entity) {
        throw new IllegalStateException();
    }

    @NonNull
    private List<MyExample4224DTO> getStats() {
        List<MyExample4224DTO> result = new ArrayList<>(ROWS_TOTAL);
        MyExample4224DTO newRow = new MyExample4224DTO()
                .setTitle("All record")
                .setValue(repository.count())
                .setDescription("Count rows in table")
                .setColor("#edaa");
        newRow.setId(COUNT_ROW_ID);
        result.add(newRow);

        return result;
    }

}