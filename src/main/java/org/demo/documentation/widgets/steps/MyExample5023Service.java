package org.demo.documentation.widgets.steps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5023Service extends VersionAwareResponseService<MyExample5023DTO, MyEntity5023> {

    private final MyEntity5023Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5023Meta> meta = MyExample5023Meta.class;

    @Override
    protected CreateResult<MyExample5023DTO> doCreateEntity(MyEntity5023 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5023DTO> doUpdateEntity(MyEntity5023 entity, MyExample5023DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5023DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5023DTO> getActions() {
        return Actions.<MyExample5023DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}