package org.demo.documentation.other.drilldown.option3.any;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3435Service extends AnySourceVersionAwareResponseService<MyExample3435DTO, MyEntity3435OutServiceDTO> {


    public MyExample3435Service() {
        super(MyExample3435DTO.class, MyEntity3435OutServiceDTO.class, MyExample3435Meta.class, MyEntity3435Dao.class);
    }


    @Override
    protected CreateResult<MyExample3435DTO> doCreateEntity(MyEntity3435OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3435DTO> doUpdateEntity(MyEntity3435OutServiceDTO entity, MyExample3435DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3435DTO> getActions() {
        return Actions.<MyExample3435DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}