package org.demo.documentation.fields.multifield.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.services.CustomDynamicErrorService;
import org.springframework.stereotype.Service;


@Service
public class MyExample360Service extends VersionAwareResponseService<MyExample360DTO, MyEntity360> {

    private final MyEntity360Repository repository;


    public MyExample360Service(MyEntity360Repository repository) {
        super(MyExample360DTO.class, MyEntity360.class, null, MyExample360Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample360DTO> doCreateEntity(MyEntity360 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample360DTO> doUpdateEntity(MyEntity360 entity, MyExample360DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample360DTO_.customFieldMulti)) {
            entity.setCustomFieldMulti(data.getCustomFieldMulti());
        }
        if (data.isFieldChanged(MyExample360DTO_.customFieldAdditionalMulti)) {
            entity.setCustomFieldAdditionalMulti(data.getCustomFieldAdditionalMulti());
        }
        if (data.isFieldChanged(MyExample360DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample360DTO_.informationField)) {
            entity.setInformationField(data.getInformationField());
        }
        if (data.isFieldChanged(MyExample360DTO_.customFieldAdditional)) {
            entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample360DTO> getActions() {
        return Actions.<MyExample360DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}