package org.demo.documentation.feature.synchasyncrequests.anysorce;

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


@Service
@RequiredArgsConstructor
public class MyEntity3231AnySourceFindDao extends AbstractAnySourceBaseDAO<MyEntity3231AnySourceOutServiceFindDTO> implements AnySourceBaseDAO<MyEntity3231AnySourceOutServiceFindDTO> {
    public static final String COUNT_ROW_ID = "0";
    @Override
    public String getId(final MyEntity3231AnySourceOutServiceFindDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyEntity3231AnySourceOutServiceFindDTO entity) {
        entity.setId(id);
    }

    @Override
    public MyEntity3231AnySourceOutServiceFindDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return new MyEntity3231AnySourceOutServiceFindDTO().setId(COUNT_ROW_ID);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyEntity3231AnySourceOutServiceFindDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        List<MyEntity3231AnySourceOutServiceFindDTO> result = new ArrayList<>();
        MyEntity3231AnySourceOutServiceFindDTO newRow = new MyEntity3231AnySourceOutServiceFindDTO()
                .setId(COUNT_ROW_ID);
        result.add(newRow);
        return new PageImpl<>(result);
    }

    @Override
    public MyEntity3231AnySourceOutServiceFindDTO update(BusinessComponent bc, MyEntity3231AnySourceOutServiceFindDTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyEntity3231AnySourceOutServiceFindDTO create(final BusinessComponent bc, final MyEntity3231AnySourceOutServiceFindDTO entity) {
        throw new IllegalStateException();
    }

}