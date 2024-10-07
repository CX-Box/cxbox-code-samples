package org.demo.documentation.widgets.assoc.basic;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.assoc.basic.forfield.MyEntity3053Multi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MyExample3053Service extends VersionAwareResponseService<MyExample3053DTO, MyEntity3053> {

    private final MyEntity3053Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3053Service(MyEntity3053Repository repository) {
        super(MyExample3053DTO.class, MyEntity3053.class, null, MyExample3053Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3053DTO> doCreateEntity(MyEntity3053 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3053DTO> doUpdateEntity(MyEntity3053 entity, MyExample3053DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3053DTO_.customField)) {
            entity.getCustomFieldList().clear();
            entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3053Multi.class, e))
                    .collect(Collectors.toList()));
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3053DTO> getActions() {
        return Actions.<MyExample3053DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
