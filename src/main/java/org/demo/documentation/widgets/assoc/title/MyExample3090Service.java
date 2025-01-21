package org.demo.documentation.widgets.assoc.title;

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
public class MyExample3090Service extends VersionAwareResponseService<MyExample3090DTO, MyEntity3090> {

    private final MyEntity3090Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3090Service(MyEntity3090Repository repository) {
        super(MyExample3090DTO.class, MyEntity3090.class, null, MyExample3090Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3090DTO> doCreateEntity(MyEntity3090 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3090DTO> doUpdateEntity(MyEntity3090 entity, MyExample3090DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3090DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3090Multi.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3090DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3090DTO> getActions() {
        return Actions.<MyExample3090DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

