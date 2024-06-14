package org.demo.documentation.widgets.statsblock.base.defaultfields;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.statsblock.base.customfields.MyExample4200DTO;
import org.demo.documentation.widgets.statsblock.base.data.MyEntity4201Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4203Dao extends AbstractAnySourceBaseDAO<MyExample4203DTO> implements
        AnySourceBaseDAO<MyExample4203DTO> {


    public static final int ROWS_TOTAL = 2;

    public static final String COUNT_ROW_ID = "0";

    public static final String SUM_CUSTOM_FIELD_NUM = "1";


    private final MyEntity4201Repository repository;

    @Override
    public String getId(final MyExample4203DTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyExample4203DTO entity) {
        entity.setId(id);
    }

    @Override
    public MyExample4203DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyExample4203DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        return new PageImpl<>(getStats());
    }

    @Override
    public MyExample4203DTO update(BusinessComponent bc, MyExample4203DTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyExample4203DTO create(final BusinessComponent bc, final MyExample4203DTO entity) {
        throw new IllegalStateException();
    }

    @NonNull
    private List<MyExample4203DTO> getStats() {
        List<MyExample4203DTO> result = new ArrayList<>(ROWS_TOTAL);
        MyExample4203DTO newRow = new MyExample4203DTO()
                .setTitle("New Clients")
                .setValue(repository.count())
                .setColor("#779FE9")
                .setIcon("team") //same as in screen.json icon
                .setDescription("New Clients. Press to filter List below");
        newRow.setId(COUNT_ROW_ID);
        result.add(newRow);
        MyExample4203DTO newSum = new MyExample4203DTO()
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