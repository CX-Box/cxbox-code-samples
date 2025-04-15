package org.demo.documentation.widgets.assoc.colortitle.color;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.widgets.assoc.colortitle.MyEntity3056Multi;

import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3056MultiPickService extends VersionAwareResponseService<MyEntity3056MultiPickDTO, MyEntity3056Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3056MultiPickMeta> meta = MyEntity3056MultiPickMeta.class;

    @Override
    protected CreateResult<MyEntity3056MultiPickDTO> doCreateEntity(MyEntity3056Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3056MultiPickDTO> doUpdateEntity(MyEntity3056Multi entity, MyEntity3056MultiPickDTO data,
                                                                       BusinessComponent bc) {
        setIfChanged(data, MyEntity3056MultiPickDTO_.customFieldText, entity::setCustomFieldText);
        return null;
    }


}