package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.input.filtration.InputFiltration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3094Service extends VersionAwareResponseService<MyExample3094DTO, MyEntity3094> {

    private final MyEntity3094Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3094Meta> meta = MyExample3094Meta.class;

    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3094DTO> doCreateEntity(MyEntity3094 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3094DTO> doUpdateEntity(MyEntity3094 entity, MyExample3094DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3094DTO_.inn2Id)) {
            entity.setInn2Entity(data.getInn2Id() != null
                    ? entityManager.getReference(InputFiltration.class, data.getInn2Id())
                    : null);
        }
        setIfChanged(data, MyExample3094DTO_.inn, entity::setInn);
        setIfChanged(data, MyExample3094DTO_.rusFullName, entity::setRusFullName);
        if (data.isFieldChanged(MyExample3094DTO_.rusShortNameId)) {
            entity.setRusShortNameEntity(data.getRusShortNameId() != null
                    ? entityManager.getReference(InputFiltration.class, data.getRusShortNameId())
                    : null);
        }
        setIfChanged(data, MyExample3094DTO_.residentType, entity::setResidentType);
        if (data.isFieldChanged(MyExample3094DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3094DTO> getActions() {
        return Actions.<MyExample3094DTO>builder()
                .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]
}
