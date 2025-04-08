package org.demo.documentation.widgets.statsblock.icon.withouticon;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4224Service extends AnySourceVersionAwareResponseService<MyExample4224DTO, MyExample4224DTO> {

    public MyExample4224Service( ) {
        super(MyExample4224DTO.class, MyExample4224DTO.class,  MyExample4224Meta.class, MyExample4224Dao.class);
    }

    @Override
    protected CreateResult<MyExample4224DTO> doCreateEntity(MyExample4224DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyExample4224DTO> doUpdateEntity(MyExample4224DTO entity, MyExample4224DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
