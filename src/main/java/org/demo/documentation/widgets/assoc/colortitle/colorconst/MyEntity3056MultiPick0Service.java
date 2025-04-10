package org.demo.documentation.widgets.assoc.colortitle.colorconst;

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
public class MyEntity3056MultiPick0Service extends VersionAwareResponseService<MyEntity3056MultiPick0DTO, MyEntity3056Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3056MultiPick0Meta> meta = MyEntity3056MultiPick0Meta.class;

    @Override
    protected CreateResult<MyEntity3056MultiPick0DTO> doCreateEntity(MyEntity3056Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3056MultiPick0DTO> doUpdateEntity(MyEntity3056Multi entity, MyEntity3056MultiPick0DTO data,
                                                                        BusinessComponent bc) {
        setIfChanged(data, MyEntity3056MultiPick0DTO_.customFieldText, entity::setCustomFieldText);
        return null;
    }


}