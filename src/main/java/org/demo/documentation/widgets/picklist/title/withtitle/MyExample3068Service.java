package org.demo.documentation.widgets.picklist.title.withtitle;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3068Service extends VersionAwareResponseService<MyExample3068DTO, MyEntity3068> {

    private final MyEntity3068Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3068Meta> meta = MyExample3068Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3068DTO> doCreateEntity(MyEntity3068 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3068DTO> doUpdateEntity(MyEntity3068 entity, MyExample3068DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3068DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3068Pick.class, data.getCustomFieldId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3068DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3068Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3068DTO> getActions() {
        return Actions.<MyExample3068DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
