package org.demo.documentation.widgets.additionallist.base.allfields.forfields;

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
public class MyEntity3191MultiPickService extends VersionAwareResponseService<MyEntity3191MultiPickDTO, MyEntity3191Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3191MultiPickMeta> meta = MyEntity3191MultiPickMeta.class;

    @Override
    protected CreateResult<MyEntity3191MultiPickDTO> doCreateEntity(MyEntity3191Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3191MultiPickDTO> doUpdateEntity(MyEntity3191Multi entity, MyEntity3191MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}