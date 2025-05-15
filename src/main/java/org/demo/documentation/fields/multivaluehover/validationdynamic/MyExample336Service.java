package org.demo.documentation.fields.multivaluehover.validationdynamic;

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
public class MyExample336Service extends VersionAwareResponseService<MyExample336DTO, MyEntity336> {

    private final MyEntity336Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample336Meta> meta = MyExample336Meta.class;
    @Autowired
    private EntityManager entityManager;


    @Override
    protected CreateResult<MyExample336DTO> doCreateEntity(MyEntity336 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample336DTO> doUpdateEntity(MyEntity336 entity, MyExample336DTO data,
                                                              BusinessComponent bc) {
        if (data.isFieldChanged(MyExample336DTO_.customFieldMultiHolder)) {
            entity.getCustomFieldMultiHolderList().clear();
            entity.getCustomFieldMultiHolderList().addAll(data.getCustomFieldMultiHolder().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity339.class, e))
                    .collect(Collectors.toList()));
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample336DTO> getActions() {
        return Actions.<MyExample336DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]

}