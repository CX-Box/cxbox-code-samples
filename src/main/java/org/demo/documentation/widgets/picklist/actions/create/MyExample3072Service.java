package org.demo.documentation.widgets.picklist.actions.create;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.actions.create.inlinepicklist.MyEntity3072InlinePick;
import org.demo.documentation.widgets.picklist.actions.create.picklist.MyEntity3072Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3072Service extends VersionAwareResponseService<MyExample3072DTO, MyEntity3072> {

    private final MyEntity3072Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3072Meta> meta = MyExample3072Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3072DTO> doCreateEntity(MyEntity3072 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3072DTO> doUpdateEntity(MyEntity3072 entity, MyExample3072DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3072DTO_.customFieldInlinePicklistId)) {
            entity.setCustomFieldInlinePicklistEntity(data.getCustomFieldInlinePicklistId() != null
                    ? entityManager.getReference(MyEntity3072InlinePick.class, data.getCustomFieldInlinePicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3072DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3072Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3072DTO> getActions() {
        return Actions.<MyExample3072DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}
