package org.demo.documentation.widgets.assoc.colortitle.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3052Service extends VersionAwareResponseService<MyExample3052DTO, MyEntity3052> {

    private final MyEntity3052Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3052Meta> meta = MyExample3052Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3052DTO> doCreateEntity(MyEntity3052 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3052DTO> doUpdateEntity(MyEntity3052 entity, MyExample3052DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3052DTO_.customFieldMulti)) {
            entity.getCustomFieldMultiList().clear();
            entity.getCustomFieldMultiList().addAll(data.getCustomFieldMulti().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3052Multi.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3052DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3052DTO> getActions() {
        return Actions.<MyExample3052DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
