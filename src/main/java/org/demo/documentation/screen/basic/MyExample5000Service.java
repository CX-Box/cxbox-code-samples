package org.demo.documentation.screen.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample5000Service extends VersionAwareResponseService<MyExample5000DTO, MyEntity5000> {

    private final MyEntity5000Repository repository;

    public MyExample5000Service(MyEntity5000Repository repository) {
        super(MyExample5000DTO.class, MyEntity5000.class, null, MyExample5000Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample5000DTO> doCreateEntity(MyEntity5000 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5000DTO> doUpdateEntity(MyEntity5000 entity, MyExample5000DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample5000DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5000DTO> getActions() {
        return Actions.<MyExample5000DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }

}