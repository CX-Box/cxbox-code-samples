package org.demo.documentation.widgets.statsblock.drilldown.drilldown;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.MyEntity4208Repository;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.enums.CustomFieldEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4210Dao extends AbstractAnySourceBaseDAO<MyExample4210DTO> implements
        AnySourceBaseDAO<MyExample4210DTO> {

    public static final String ROW_ID_0 = "0";

    public static final String ROW_ID_1 = "1";

    public static final String ROW_ID_2 = "2";

    private final MyEntity4208Repository repository;

    @Override
    public String getId(final MyExample4210DTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyExample4210DTO entity) {
        entity.setId(id);
    }

    @Override
    public MyExample4210DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyExample4210DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        return new PageImpl<>(getStats());
    }

    @Override
    public MyExample4210DTO update(BusinessComponent bc, MyExample4210DTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyExample4210DTO create(final BusinessComponent bc, final MyExample4210DTO entity) {
        throw new IllegalStateException();
    }

    @NonNull
    private List<MyExample4210DTO> getStats() {
        List<MyExample4210DTO> result = new ArrayList<>();
        MyExample4210DTO newRow = new MyExample4210DTO()
                .setTitle("New record")
                .setValue(repository.count(repository.statusIn(List.of(CustomFieldEnum.NEW))))
                .setIcon("calendar")
                .setDescription("Count rows status = new in table")
                .setColor("#5F90EA");
        newRow.setId(ROW_ID_0);
        result.add(newRow);
        MyExample4210DTO newRow2 = new MyExample4210DTO()
                .setTitle("In progress")
                .setValue(repository.count(repository.statusIn(List.of(CustomFieldEnum.IN_PROGRESS))))
                .setIcon("team")
                .setDescription("Count rows status = in_progress in table")
                .setColor("#5F90EA");
        newRow2.setId(ROW_ID_1);
        result.add(newRow);
        MyExample4210DTO newRow3 = new MyExample4210DTO()
                .setTitle("Close")
                .setValue(repository.count(repository.statusIn(List.of(CustomFieldEnum.CLOSE))))
                .setIcon("pie-chart")
                .setDescription("Count rows status = close in table")
                .setColor("#5F90EA");
        newRow3.setId(ROW_ID_2);
        result.add(newRow);
        return result;
    }

}