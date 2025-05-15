package org.demo.documentation.fields.multivaluehover.validationconfirm;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity244PickService extends VersionAwareResponseService<MyEntity244PickDTO, MyEntity244> {

    public MyEntity244PickService() {
        super(MyEntity244PickDTO.class, MyEntity244.class, null, MyEntity244PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity244PickDTO> doCreateEntity(MyEntity244 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity244PickDTO> doUpdateEntity(MyEntity244 entity, MyEntity244PickDTO data,
                                                                 BusinessComponent bc) {
        return null;
    }


}