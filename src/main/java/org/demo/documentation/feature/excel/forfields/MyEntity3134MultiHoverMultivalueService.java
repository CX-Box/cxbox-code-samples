package org.demo.documentation.feature.excel.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3134MultiHoverMultivalueService extends VersionAwareResponseService<MyEntity3134MultiHoverMultivalueDTO, org.demo.documentation.feature.excel.forfields.MyEntity3134MultiHover> {

    public MyEntity3134MultiHoverMultivalueService() {
        super(MyEntity3134MultiHoverMultivalueDTO.class, org.demo.documentation.feature.excel.forfields.MyEntity3134MultiHover.class, null, MyEntity3134MultiHoverMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3134MultiHoverMultivalueDTO> doCreateEntity(org.demo.documentation.feature.excel.forfields.MyEntity3134MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3134MultiHoverMultivalueDTO> doUpdateEntity(org.demo.documentation.feature.excel.forfields.MyEntity3134MultiHover entity, MyEntity3134MultiHoverMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}