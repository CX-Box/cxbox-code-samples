package org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3147Service extends VersionAwareResponseService<MyExample3147DTO, MyEntity3147> {

    private final MyEntity3147Repository repository;

    public MyExample3147Service(MyEntity3147Repository repository) {
        super(MyExample3147DTO.class, MyEntity3147.class, null, MyExample3147Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3147DTO> doCreateEntity(MyEntity3147 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3147DTO> doUpdateEntity(MyEntity3147 entity, MyExample3147DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3147DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3147DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3147DTO> getActions() {
        return Actions.<MyExample3147DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }


}

