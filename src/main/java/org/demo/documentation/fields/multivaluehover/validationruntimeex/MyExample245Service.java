package org.demo.documentation.fields.multivaluehover.validationruntimeex;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample245Service extends VersionAwareResponseService<MyExample245DTO, MyEntity245> {

    private final MyEntity245Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample245Meta> meta = MyExample245Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample245DTO> doCreateEntity(MyEntity245 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample245DTO> doUpdateEntity(MyEntity245 entity, MyExample245DTO data,
                                                              BusinessComponent bc) {
        if (data.isFieldChanged(MyExample245DTO_.customFieldMultiHover)) {
            entity.getCustomFieldMultiHoverList().clear();
            entity.getCustomFieldMultiHoverList().addAll(data.getCustomFieldMultiHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity246.class, e))
                    .collect(Collectors.toList()));
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample245DTO> getActions() {
        return Actions.<MyExample245DTO>builder()
               .save(sv -> sv.text("Save"))
                .build();
    }
    // --8<-- [end:getActions]

}