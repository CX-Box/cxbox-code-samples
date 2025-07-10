package org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3865MultiPickService extends VersionAwareResponseService<MyEntity3865MultiPickDTO, org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3865MultiPickMeta> meta = MyEntity3865MultiPickMeta.class;

    @Override
    protected CreateResult<MyEntity3865MultiPickDTO> doCreateEntity(org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3865MultiPickDTO> doUpdateEntity(org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi entity, MyEntity3865MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}