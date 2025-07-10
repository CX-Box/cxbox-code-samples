package org.demo.documentation.widgets.property.pagination.availablelimitselist.multivalue;

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
public class MyEntity3867MultiPickService extends VersionAwareResponseService<MyEntity3867MultiPickDTO, MyEntity3867Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3867MultiPickMeta> meta = MyEntity3867MultiPickMeta.class;

    @Override
    protected CreateResult<MyEntity3867MultiPickDTO> doCreateEntity(MyEntity3867Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3867MultiPickDTO> doUpdateEntity(MyEntity3867Multi entity, MyEntity3867MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}