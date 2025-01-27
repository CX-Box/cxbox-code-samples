package org.demo.documentation.widgets.assoc.actions.other.customsave;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyExample3063Service extends VersionAwareResponseService<MyExample3063DTO, MyEntity3063> {

    private final MyEntity3063Repository repository;

    private final MyEntity3063MultiRepository repositoryMulti;
    @Autowired
    private EntityManager entityManager;

    public MyExample3063Service(MyEntity3063Repository repository, MyEntity3063MultiRepository repositoryMulti) {
        super(MyExample3063DTO.class, MyEntity3063.class, null, MyExample3063Meta.class);
        this.repository = repository;
        this.repositoryMulti = repositoryMulti;
    }

    @Override
    protected CreateResult<MyExample3063DTO> doCreateEntity(MyEntity3063 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3063DTO> doUpdateEntity(MyEntity3063 entity, MyExample3063DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3063DTO_.customFieldRequired, entity::setCustomFieldRequired);
        if (data.isFieldChanged(MyExample3063DTO_.customField)) {
            entity.getCustomFieldList().clear();
            entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3063Multi.class, e))
                    .toList());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3063DTO> getActions() {
        return Actions.<MyExample3063DTO>builder()
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
    private ActionResultDTO<MyExample3063DTO> customSave(BusinessComponent bc, MyExample3063DTO dto) {
        Optional<MyEntity3063> entity = repository.findById(bc.getIdAsLong());
        if (entity.isEmpty()) {
            return null;
        }
        List<MyEntity3063Multi> listMultivalue = new ArrayList<>();
        dto.getCustomField().getValues().forEach(v -> {
            Optional<MyEntity3063Multi> entityChild = repositoryMulti.findById(Long.valueOf(v.getId()));
            entityChild.ifPresent(listMultivalue::add);
        });
        entity.get().setCustomFieldList(listMultivalue);
        return new ActionResultDTO<>(entityToDto(bc, entity.get()));
    }
    // --8<-- [end:customSave]


}

