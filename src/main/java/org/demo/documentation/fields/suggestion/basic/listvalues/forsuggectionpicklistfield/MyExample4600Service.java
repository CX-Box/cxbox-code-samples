package org.demo.documentation.fields.suggestion.basic.listvalues.forsuggectionpicklistfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4600Service extends AnySourceVersionAwareResponseService<MyExample4600DTO, MyEntity4600OutServiceDTO> {


    public MyExample4600Service() {
        super(MyExample4600DTO.class, MyEntity4600OutServiceDTO.class, MyExample4600Meta.class, MyEntity4600Dao.class);
    }


    @Override
    protected CreateResult<MyExample4600DTO> doCreateEntity(MyEntity4600OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4600DTO> doUpdateEntity(MyEntity4600OutServiceDTO entity, MyExample4600DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4600DTO> getActions() {
        return Actions.<MyExample4600DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}