package org.demo.documentation.widgets.property.filtration.filtergroup;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623;
import org.demo.documentation.widgets.property.filtration.filtergroup.forpicklist.MyEntity3630;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3616Service extends VersionAwareResponseService<MyExample3616DTO, MyEntity3616> {

    private final MyEntity3616Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3616Meta> meta = MyExample3616Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3616DTO> doCreateEntity(MyEntity3616 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3616DTO> doUpdateEntity(MyEntity3616 entity, MyExample3616DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3616DTO_.customFieldPicklistId)) {
            entity.setCustomFieldPicklistEntity(data.getCustomFieldPicklistId() != null
                    ? entityManager.getReference(MyEntity3630.class, data.getCustomFieldPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3616DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3623.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3616DTO_.customFieldNew)) {
            entity.setCustomFieldNew(data.getCustomFieldNew());
        }
        if (data.isFieldChanged(MyExample3616DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3616DTO> getActions() {
        return Actions.<MyExample3616DTO>builder()
               .save(sv -> sv.text("Save"))
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
    // --8<-- [end:getActions]
}
