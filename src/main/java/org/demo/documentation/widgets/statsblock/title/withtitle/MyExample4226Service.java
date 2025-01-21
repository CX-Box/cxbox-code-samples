package org.demo.documentation.widgets.statsblock.title.withtitle;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4226Service extends AnySourceVersionAwareResponseService<MyExample4226DTO, MyExample4226DTO> {


    public MyExample4226Service() {
        super(MyExample4226DTO.class, MyExample4226DTO.class, MyExample4226Meta.class, MyExample4226Dao.class);
    }

    @Override
    protected CreateResult<MyExample4226DTO> doCreateEntity(MyExample4226DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyExample4226DTO> doUpdateEntity(MyExample4226DTO entity, MyExample4226DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
