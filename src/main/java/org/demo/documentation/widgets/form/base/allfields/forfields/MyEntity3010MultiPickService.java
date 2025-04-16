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
public class MyEntity3010MultiPickService extends VersionAwareResponseService<org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiPickDTO, org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3010MultiPickMeta> meta = MyEntity3010MultiPickMeta.class;

    @Override
    protected CreateResult<org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiPickDTO> doCreateEntity(org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiPickDTO> doUpdateEntity(org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Multi entity, org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiPickDTO data,
                                                                                                                                    BusinessComponent bc) {
        return null;
    }


}