package org.demo.documentation.fields.suggestion.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3115Service extends AnySourceVersionAwareResponseService<MyExample3115DTO, MyEntity3115OutServiceDTO> {


    public MyExample3115Service() {
        super(MyExample3115DTO.class, MyEntity3115OutServiceDTO.class, MyExample3115Meta.class, MyEntity3115Dao.class);
    }


    @Override
    protected CreateResult<MyExample3115DTO> doCreateEntity(MyEntity3115OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3115DTO> doUpdateEntity(MyEntity3115OutServiceDTO entity, MyExample3115DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3115DTO> getActions() {
        return Actions.<MyExample3115DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}