package org.demo.documentation.widgets.picklist.actions.other.createcustomsave;

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

import java.util.Optional;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3073Service extends VersionAwareResponseService<MyExample3073DTO, MyEntity3073> {

    private final MyEntity3073Repository repository;

    private final MyEntity3073PickRepository repositoryPick;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3073Meta> meta = MyExample3073Meta.class;

    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3073DTO> doCreateEntity(MyEntity3073 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3073DTO> doUpdateEntity(MyEntity3073 entity, MyExample3073DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3073DTO_.customFieldRequred, entity::setCustomFieldRequred);
        if (data.isFieldChanged(MyExample3073DTO_.customFieldId)) {
            entity.setCustomFieldEntity(data.getCustomFieldId() != null
                    ? entityManager.getReference(MyEntity3073Pick.class, data.getCustomFieldId())
                    : null);
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3073DTO> getActions() {
        return Actions.<MyExample3073DTO>builder()
                .create(crt -> crt.text("Add"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("custom save", "Custom Save")
                        .invoker(this::customSave)
                )
                .build();
    }
    // --8<-- [end:getActions]

    // --8<-- [start:customSave]
    private ActionResultDTO<MyExample3073DTO> customSave(BusinessComponent bc, MyExample3073DTO dto) {
        Optional<MyEntity3073> entity = repository.findById(bc.getIdAsLong());
        if (entity.isEmpty()) {
            return null;
        }

        Optional<MyEntity3073Pick> entityPick = repositoryPick.findById(dto.getCustomFieldId());
        entityPick.ifPresent(myEntity3073Pick -> entity.get().setCustomFieldEntity(myEntity3073Pick));
        return new ActionResultDTO<>(entityToDto(bc, entity.get()));
    }
    // --8<-- [end:customSave]

}

