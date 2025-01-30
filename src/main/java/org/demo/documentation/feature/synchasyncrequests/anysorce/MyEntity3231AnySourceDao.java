package org.demo.documentation.feature.synchasyncrequests.anysorce;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO; ;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.demo.documentation.widgets.statsblock.color.color.MyExample4206DTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyEntity3231AnySourceDao extends AbstractAnySourceBaseDAO<MyEntity3231AnySourceOutServiceDTO> implements AnySourceBaseDAO<MyEntity3231AnySourceOutServiceDTO> {

    @Override
    public String getId(final MyEntity3231AnySourceOutServiceDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyEntity3231AnySourceOutServiceDTO entity) {
        entity.setId(id);
    }

    @Override
    public MyEntity3231AnySourceOutServiceDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return  null;
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyEntity3231AnySourceOutServiceDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        List<MyEntity3231AnySourceOutServiceDTO> result = new ArrayList<>();
        return new PageImpl<>((result));
    }

    @Override
    public MyEntity3231AnySourceOutServiceDTO update(BusinessComponent bc, MyEntity3231AnySourceOutServiceDTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyEntity3231AnySourceOutServiceDTO create(final BusinessComponent bc, final MyEntity3231AnySourceOutServiceDTO entity) {
        throw new IllegalStateException();
    }

}