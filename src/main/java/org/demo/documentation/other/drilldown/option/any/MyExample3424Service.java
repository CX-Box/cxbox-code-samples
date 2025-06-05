package org.demo.documentation.other.drilldown.option.any;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3424Service extends AnySourceVersionAwareResponseService<MyExample3424DTO, MyEntity3424OutServiceDTO> {


    public MyExample3424Service() {
        super(MyExample3424DTO.class, MyEntity3424OutServiceDTO.class, MyExample3424Meta.class, MyEntity3424Dao.class);
    }


    @Override
    protected CreateResult<MyExample3424DTO> doCreateEntity(MyEntity3424OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3424DTO> doUpdateEntity(MyEntity3424OutServiceDTO entity, MyExample3424DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3424DTO> getActions() {
        return Actions.<MyExample3424DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}