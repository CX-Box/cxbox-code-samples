package org.demo.documentation.widgets.headerwidget.title;

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
public class MyExample5027Service extends VersionAwareResponseService<MyExample5027DTO, MyEntity5027> {

    private final MyEntity5027Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5027Meta> meta = MyExample5027Meta.class;

    @Override
    protected CreateResult<MyExample5027DTO> doCreateEntity(MyEntity5027 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5027DTO> doUpdateEntity(MyEntity5027 entity, MyExample5027DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5027DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5027DTO> getActions() {
        return Actions.<MyExample5027DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}