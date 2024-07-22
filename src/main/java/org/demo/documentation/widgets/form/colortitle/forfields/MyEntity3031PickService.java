package org.demo.documentation.widgets.form.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3031PickService extends VersionAwareResponseService<MyEntity3031PickDTO, MyEntity3031> {

    public MyEntity3031PickService() {
        super(MyEntity3031PickDTO.class, MyEntity3031.class, null, MyEntity3031PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3031PickDTO> doCreateEntity(MyEntity3031 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3031PickDTO> doUpdateEntity(MyEntity3031 entity, MyEntity3031PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}