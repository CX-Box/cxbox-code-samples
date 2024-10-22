package org.demo.documentation.widgets.form.base.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3010MultiPickService extends VersionAwareResponseService<org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiPickDTO, org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Multi> {

    public MyEntity3010MultiPickService() {
        super(org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiPickDTO.class, org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Multi.class, null, MyEntity3010MultiPickMeta.class);
    }

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