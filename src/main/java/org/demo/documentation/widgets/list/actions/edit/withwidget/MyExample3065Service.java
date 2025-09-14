package org.demo.documentation.widgets.list.actions.edit.withwidget;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.date.basic.DateBasic;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3065Service extends VersionAwareResponseService<MyExample3065DTO, MyEntity3065> {

    private final MyEntity3065Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3065Meta> meta = MyExample3065Meta.class;

    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3065DTO> doCreateEntity(MyEntity3065 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3065DTO> doUpdateEntity(MyEntity3065 entity, MyExample3065DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3065DTO_.hkjhkj)) {
            entity.getHkjhkjList().clear();
            entity.getHkjhkjList().addAll(data.getHkjhkj().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(ApplicationEntity.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3065DTO_.fjhjklId)) {
            entity.setFjhjklEntity(data.getFjhjklId() != null
                    ? entityManager.getReference(ApplicationEntity.class, data.getFjhjklId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3065DTO_.dfgjhklId)) {
            entity.setDfgjhklEntity(data.getDfgjhklId() != null
                    ? entityManager.getReference(DateBasic.class, data.getDfgjhklId())
                    : null);
        }
        setIfChanged(data, MyExample3065DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3065DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3065DTO> getActions() {
        return Actions.<MyExample3065DTO>builder()
                .save(sv -> sv.text("Save"))
                .action(act -> act
                        .action("edit", "Edit"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .build();
    }


}

