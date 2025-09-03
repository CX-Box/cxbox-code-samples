package org.demo.documentation.widgets.emptywidget.title;

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
public class MyExample5034Service extends VersionAwareResponseService<MyExample5034DTO, MyEntity5034> {

    private final MyEntity5034Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5034Meta> meta = MyExample5034Meta.class;

    @Override
    protected CreateResult<MyExample5034DTO> doCreateEntity(MyEntity5034 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5034DTO> doUpdateEntity(MyEntity5034 entity, MyExample5034DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5034DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5034DTO> getActions() {
        return Actions.<MyExample5034DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}