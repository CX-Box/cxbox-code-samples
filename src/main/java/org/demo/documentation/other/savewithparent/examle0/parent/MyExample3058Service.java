package org.demo.documentation.other.savewithparent.examle0.parent;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;

@Service
public class MyExample3058Service extends VersionAwareResponseService<MyExample3058DTO, MyEntity3058> {

    private final MyEntity3058Repository repository;

    public MyExample3058Service(MyEntity3058Repository repository) {
        super(MyExample3058DTO.class, MyEntity3058.class, null, MyExample3058Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3058DTO> doCreateEntity(MyEntity3058 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3058DTO> doUpdateEntity(MyEntity3058 entity, MyExample3058DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3058DTO_.customFieldRequired, entity::setCustomFieldRequired);
        if (data.isFieldChanged(MyExample3058DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3058DTO> getActions() {
        return Actions.<MyExample3058DTO>builder()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .build();
    }


}

