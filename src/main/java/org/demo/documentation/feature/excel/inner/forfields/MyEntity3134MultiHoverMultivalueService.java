package org.demo.documentation.feature.excel.inner.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3134MultiHoverMultivalueService extends VersionAwareResponseService<MyEntity3134MultiHoverMultivalueDTO, MyEntity3134MultiHover> {

    public MyEntity3134MultiHoverMultivalueService() {
        super(MyEntity3134MultiHoverMultivalueDTO.class, MyEntity3134MultiHover.class, null, MyEntity3134MultiHoverMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3134MultiHoverMultivalueDTO> doCreateEntity(MyEntity3134MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3134MultiHoverMultivalueDTO> doUpdateEntity(MyEntity3134MultiHover entity, MyEntity3134MultiHoverMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}