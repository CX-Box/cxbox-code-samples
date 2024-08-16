package org.demo.documentation.widgets.assoc.actions.buttonassoc;

import jakarta.persistence.EntityManager;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MyExample3062Service extends VersionAwareResponseService<MyExample3062DTO, MyEntity3062> {

    private final MyEntity3062Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3062Service(MyEntity3062Repository repository) {
        super(MyExample3062DTO.class, MyEntity3062.class, null, MyExample3062Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3062DTO> doCreateEntity(MyEntity3062 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3062DTO> doUpdateEntity(MyEntity3062 entity, MyExample3062DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3062DTO_.customField)) {
            entity.getCustomFieldList().clear();
            entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3062Multi.class, e))
                    .collect(Collectors.toList()));
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
        return new AssociateResultDTO(Collections.emptyList())
                .setAction(PostAction.refreshBc(bc));
    }

    @Override
    public Actions<MyExample3062DTO> getActions() {
        return Actions.<MyExample3062DTO>builder()
                .associate()
                .text("Popup Assoc")
                .add()
                .build();
    }


}

