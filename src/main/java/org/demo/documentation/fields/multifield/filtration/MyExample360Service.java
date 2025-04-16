package org.demo.documentation.fields.multifield.filtration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample360Service extends VersionAwareResponseService<MyExample360DTO, MyEntity360> {

    private final MyEntity360Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample360Meta> meta = MyExample360Meta.class;


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

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample360DTO> getActions() {
        return Actions.<MyExample360DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}