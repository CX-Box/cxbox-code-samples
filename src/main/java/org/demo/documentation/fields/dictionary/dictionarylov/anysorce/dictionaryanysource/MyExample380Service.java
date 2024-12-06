package org.demo.documentation.fields.dictionary.dictionarylov.anysorce.dictionaryanysource;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample380Service extends AnySourceVersionAwareResponseService<MyExample380DTO, MyEntity380OutServiceDTO> {


    public MyExample380Service() {
        super(MyExample380DTO.class, MyEntity380OutServiceDTO.class, MyExample380Meta.class, MyEntity380Dao.class);
    }


    @Override
    protected CreateResult<MyExample380DTO> doCreateEntity(MyEntity380OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample380DTO> doUpdateEntity(MyEntity380OutServiceDTO entity, MyExample380DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample380DTO> getActions() {
        return Actions.<MyExample380DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}