package org.demo.documentation.screen.withouticon;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample5001Service extends VersionAwareResponseService<MyExample5001DTO, MyEntity5001> {

    private final MyEntity5001Repository repository;

    public MyExample5001Service(MyEntity5001Repository repository) {
        super(MyExample5001DTO.class, MyEntity5001.class, null, MyExample5001Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample5001DTO> doCreateEntity(MyEntity5001 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5001DTO> doUpdateEntity(MyEntity5001 entity, MyExample5001DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample5001DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5001DTO> getActions() {
        return Actions.<MyExample5001DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }

}