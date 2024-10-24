package org.demo.documentation.widgets.form.base.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3010MultiHoverPickService extends VersionAwareResponseService<org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHoverPickDTO, org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHover> {

    public MyEntity3010MultiHoverPickService() {
        super(org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHoverPickDTO.class, org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHover.class, null, MyEntity3010MultiHoverPickMeta.class);
    }

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