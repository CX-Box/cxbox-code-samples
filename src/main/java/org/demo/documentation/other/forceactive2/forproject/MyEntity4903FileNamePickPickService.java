package org.demo.documentation.other.forceactive2.forproject;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4903FileNamePickPickService extends VersionAwareResponseService<MyEntity4903FileNamePickPickDTO, MyEntity4903FileNamePick> {

    public MyEntity4903FileNamePickPickService() {
        super(MyEntity4903FileNamePickPickDTO.class, MyEntity4903FileNamePick.class, null, MyEntity4903FileNamePickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity4903FileNamePickPickDTO> doCreateEntity(MyEntity4903FileNamePick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4903FileNamePickPickDTO> doUpdateEntity(MyEntity4903FileNamePick entity, MyEntity4903FileNamePickPickDTO data,
                                                                              BusinessComponent bc) {
        return null;
    }


}