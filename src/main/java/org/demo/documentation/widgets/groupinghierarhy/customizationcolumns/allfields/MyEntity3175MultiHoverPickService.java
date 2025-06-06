package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

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
public class MyEntity3175MultiHoverPickService extends VersionAwareResponseService<MyEntity3175MultiHoverPickDTO, org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175MultiHover> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3175MultiHoverPickMeta> meta = MyEntity3175MultiHoverPickMeta.class;

    @Override
    protected CreateResult<MyEntity3175MultiHoverPickDTO> doCreateEntity(org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3175MultiHoverPickDTO> doUpdateEntity(org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175MultiHover entity, MyEntity3175MultiHoverPickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}