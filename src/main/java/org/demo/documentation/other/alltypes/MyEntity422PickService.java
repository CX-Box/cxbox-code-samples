package org.demo.documentation.other.alltypes;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity422PickService extends VersionAwareResponseService<MyEntity422PickDTO, MyEntity422> {

    public MyEntity422PickService() {
        super(MyEntity422PickDTO.class, MyEntity422.class, null, MyEntity422PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity422PickDTO> doCreateEntity(MyEntity422 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity422PickDTO> doUpdateEntity(MyEntity422 entity, MyEntity422PickDTO data,
                                                                 BusinessComponent bc) {
        return null;
    }


}