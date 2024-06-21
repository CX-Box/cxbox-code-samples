package org.demo.documentation.widgets.additionalinfo.base.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3600PickMultivalueService extends VersionAwareResponseService<MyEntity3600PickMultivalueDTO, MyEntity3600Multi2> {

    public MyEntity3600PickMultivalueService() {
        super(MyEntity3600PickMultivalueDTO.class, MyEntity3600Multi2.class, null, MyEntity3600PickMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3600PickMultivalueDTO> doCreateEntity(MyEntity3600Multi2 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3600PickMultivalueDTO> doUpdateEntity(MyEntity3600Multi2 entity, MyEntity3600PickMultivalueDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}