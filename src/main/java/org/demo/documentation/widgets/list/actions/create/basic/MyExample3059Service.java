package org.demo.documentation.widgets.list.actions.create.basic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3059Service extends VersionAwareResponseService<MyExample3059DTO, MyEntity3059> {

    private final MyEntity3059Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3059Meta> meta = MyExample3059Meta.class;

    @Override
    protected CreateResult<MyExample3059DTO> doCreateEntity(MyEntity3059 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3059DTO> doUpdateEntity(MyEntity3059 entity, MyExample3059DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3059DTO_.customFieldText, entity::setCustomFieldText);
        if (data.isFieldChanged(MyExample3059DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}