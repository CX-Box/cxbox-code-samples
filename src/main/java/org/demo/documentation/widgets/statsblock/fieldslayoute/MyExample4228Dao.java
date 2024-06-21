package org.demo.documentation.widgets.statsblock.fieldslayoute;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4228Dao extends AbstractAnySourceBaseDAO<MyExample4228DTO> implements
        AnySourceBaseDAO<MyExample4228DTO> {

    @Override
    public String getId(final MyExample4228DTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyExample4228DTO entity) {
        entity.setId(id);
    }

    @Override
    public MyExample4228DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyExample4228DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        return new PageImpl<>(getStats());
    }

    @Override
    public MyExample4228DTO update(BusinessComponent bc, MyExample4228DTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyExample4228DTO create(final BusinessComponent bc, final MyExample4228DTO entity) {
        throw new IllegalStateException();
    }

    @NonNull
    private List<MyExample4228DTO> getStats() {
        List<MyExample4228DTO> result = new ArrayList<>();
        MyExample4228DTO newData1 = new MyExample4228DTO()
                .setTitle("Constant Num1")
                .setValue(1L)
                .setIcon("team")
                .setDescription("Constant Num1")
                .setColor("#edaa");
        newData1.setId("1");
        result.add(newData1);
        MyExample4228DTO newData2 = new MyExample4228DTO()
                .setTitle("Constant Num2")
                .setValue(2L)
                .setIcon("team")
                .setDescription("Constant Num2");
        newData2.setId("2");
        result.add(newData2);
        MyExample4228DTO newData3 = new MyExample4228DTO()
                .setTitle("Constant Num3")
                .setValue(3L)
                .setIcon("team")
                .setDescription("Constant Num3");
        newData3.setId("3");
        result.add(newData3);
        MyExample4228DTO newData4 = new MyExample4228DTO()
                .setTitle("Constant Num4")
                .setValue(4L)
                .setIcon("team")
                .setDescription("Constant Num4");
        newData4.setId("4");
        result.add(newData4);
        MyExample4228DTO newData5 = new MyExample4228DTO()
                .setTitle("Constant Num5")
                .setValue(5L)
                .setIcon("team")
                .setDescription("Constant Num5");
        newData3.setId("5");
        result.add(newData5);
        MyExample4228DTO newData6 = new MyExample4228DTO()
                .setTitle("Constant Num6")
                .setValue(6L)
                .setIcon("team")
                .setDescription("Constant Num6");
        newData6.setId("6");
        result.add(newData6);
        return result;
    }

}