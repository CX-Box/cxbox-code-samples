package org.demo.documentation.widgets.picklist.base.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3067Service extends VersionAwareResponseService<MyExample3067DTO, MyEntity3067> {

    private final MyEntity3067Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3067Meta> meta = MyExample3067Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3067DTO> doCreateEntity(MyEntity3067 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3067DTO> doUpdateEntity(MyEntity3067 entity, MyExample3067DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3067DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample3067DTO_.customFieldFileUploadeId, entity::setCustomFieldFileUploadeId);
        setIfChanged(data, MyExample3067DTO_.customFieldFileUploade, entity::setCustomFieldFileUploade);
        setIfChanged(data, MyExample3067DTO_.customFieldRadio, entity::setCustomFieldRadio);
        if (data.isFieldChanged(MyExample3067DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3067Multi.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(org.demo.documentation.widgets.picklist.base.allfields.MyExample3067DTO_.customFieldInlinePickListId)) {
            entity.setCustomFieldInlinePickListEntity(data.getCustomFieldInlinePickListId() != null
                    ? entityManager.getReference(MyEntity3067Pick.class, data.getCustomFieldInlinePickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3067DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3067Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3067DTO> getActions() {
        return Actions.<MyExample3067DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
    // --8<-- [end:getActions]
}
