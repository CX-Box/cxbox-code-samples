package org.demo.documentation.other.forceactive2.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4902PickPickService extends VersionAwareResponseService<MyEntity4902PickPickDTO, MyEntity4902Pick> {

    public MyEntity4902PickPickService() {
        super(MyEntity4902PickPickDTO.class, MyEntity4902Pick.class, null, MyEntity4902PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity4902PickPickDTO> doCreateEntity(MyEntity4902Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4902PickPickDTO> doUpdateEntity(MyEntity4902Pick entity, MyEntity4902PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}