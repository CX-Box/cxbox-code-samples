package org.demo.documentation.widgets.assoc.actions.create;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MyExample3054Service extends VersionAwareResponseService<MyExample3054DTO, MyEntity3054> {

    private final MyEntity3054Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3054Service(MyEntity3054Repository repository) {
        super(MyExample3054DTO.class, MyEntity3054.class, null, MyExample3054Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3054DTO> doCreateEntity(MyEntity3054 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3054DTO> doUpdateEntity(MyEntity3054 entity, MyExample3054DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3054DTO_.customField)) {
            entity.getCustomFieldList().clear();
            entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3054Multi.class, e))
                    .collect(Collectors.toList()));
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3054DTO> getActions() {
        return Actions.<MyExample3054DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .create()
                .add()
                .delete()
                .add()
                .build();
    }


}
