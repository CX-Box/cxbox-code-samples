package org.demo.documentation.widgets.form.base.allfields.forfields;

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
public class MyEntity3010MultiHoverPickService extends VersionAwareResponseService<org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHoverPickDTO, org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHover> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3010MultiHoverPickMeta> meta = MyEntity3010MultiHoverPickMeta.class;

    @Override
    protected CreateResult<org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHoverPickDTO> doCreateEntity(org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHoverPickDTO> doUpdateEntity(org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHover entity, org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHoverPickDTO data,
                                                                                                                                         BusinessComponent bc) {
        return null;
    }


}