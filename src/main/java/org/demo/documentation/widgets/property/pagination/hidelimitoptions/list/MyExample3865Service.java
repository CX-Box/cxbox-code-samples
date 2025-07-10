package org.demo.documentation.widgets.property.pagination.hidelimitoptions.list;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi;
import org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup.MyEntity3865Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3865Service extends VersionAwareResponseService<MyExample3865DTO, MyEntity3865> {

    private final MyEntity3865Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3865Meta> meta = MyExample3865Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3865DTO> doCreateEntity(MyEntity3865 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3865DTO> doUpdateEntity(MyEntity3865 entity, MyExample3865DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3865DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3865Multi.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3865DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3865Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3865DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3865DTO> getActions() {
        return Actions.<MyExample3865DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

