package org.demo.documentation.other.forceactive2.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4902MultiPickService extends VersionAwareResponseService<MyEntity4902MultiPickDTO, MyEntity4902Multi> {

    public MyEntity4902MultiPickService() {
        super(MyEntity4902MultiPickDTO.class, MyEntity4902Multi.class, null, MyEntity4902MultiPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity4902MultiPickDTO> doCreateEntity(MyEntity4902Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4902MultiPickDTO> doUpdateEntity(MyEntity4902Multi entity, MyEntity4902MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}