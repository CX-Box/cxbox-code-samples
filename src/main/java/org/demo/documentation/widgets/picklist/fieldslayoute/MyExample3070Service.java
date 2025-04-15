package org.demo.documentation.widgets.picklist.fieldslayoute;

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
public class MyExample3070Service extends VersionAwareResponseService<MyExample3070DTO, MyEntity3070> {

    private final MyEntity3070Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3070Meta> meta = MyExample3070Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3070DTO> doCreateEntity(MyEntity3070 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3070DTO> doUpdateEntity(MyEntity3070 entity, MyExample3070DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3070DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3070Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3070DTO> getActions() {
        return Actions.<MyExample3070DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
