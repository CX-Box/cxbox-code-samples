package org.demo.documentation.widgets.picklist.colortitle;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3060Service extends VersionAwareResponseService<MyExample3060DTO, MyEntity3060> {

    private final MyEntity3060Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3060Meta> meta = MyExample3060Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3060DTO> doCreateEntity(MyEntity3060 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3060DTO> doUpdateEntity(MyEntity3060 entity, MyExample3060DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3060DTO_.customFieldPicklistColorConstId)) {
            entity.setCustomFieldPicklistColorConstEntity(data.getCustomFieldPicklistColorConstId() != null
                    ? entityManager.getReference(MyEntity3061Pick.class, data.getCustomFieldPicklistColorConstId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3060DTO_.customFieldPicklistId)) {
            entity.setCustomFieldPicklistEntity(data.getCustomFieldPicklistId() != null
                    ? entityManager.getReference(MyEntity3061.class, data.getCustomFieldPicklistId())
                    : null);
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3060DTO> getActions() {
        return Actions.<MyExample3060DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
     // --8<-- [end:getActions]  
}
