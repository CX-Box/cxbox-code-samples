package org.demo.documentation.feature.customizationcolumns;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3135Service extends VersionAwareResponseService<MyExample3135DTO, MyEntity3135> {

    private final MyEntity3135Repository repository;

    public MyExample3135Service(MyEntity3135Repository repository) {
        super(MyExample3135DTO.class, MyEntity3135.class, null, MyExample3135Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3135DTO> doCreateEntity(MyEntity3135 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3135DTO> doUpdateEntity(MyEntity3135 entity, MyExample3135DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3135DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample3135DTO_.customFieldCheckBox, entity::setCustomFieldCheckBox);
        setIfChanged(data, MyExample3135DTO_.customFieldDate, entity::setCustomFieldDate);
        setIfChanged(data, MyExample3135DTO_.customFieldInput, entity::setCustomFieldInput);
        if (data.isFieldChanged(MyExample3135DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3135DTO> getActions() {
        return Actions.<MyExample3135DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .create()
                .add()
                .delete()
                .add()
                .build();
    }


}

