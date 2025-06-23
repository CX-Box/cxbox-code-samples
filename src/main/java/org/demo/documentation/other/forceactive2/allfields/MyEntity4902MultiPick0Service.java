package org.demo.documentation.other.forceactive2.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4902MultiPick0Service extends VersionAwareResponseService<MyEntity4902MultiPick0DTO, MyEntity4902Multi> {

    public MyEntity4902MultiPick0Service() {
        super(MyEntity4902MultiPick0DTO.class, MyEntity4902Multi.class, null, MyEntity4902MultiPick0Meta.class);
    }

    @Override
    protected CreateResult<MyEntity4902MultiPick0DTO> doCreateEntity(MyEntity4902Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4902MultiPick0DTO> doUpdateEntity(MyEntity4902Multi entity, MyEntity4902MultiPick0DTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}