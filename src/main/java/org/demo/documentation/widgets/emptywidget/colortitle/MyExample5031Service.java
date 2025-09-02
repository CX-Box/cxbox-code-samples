package org.demo.documentation.widgets.emptywidget.colortitle;

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
public class MyExample5031Service extends VersionAwareResponseService<MyExample5031DTO, MyEntity5031> {

    private final MyEntity5031Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5031Meta> meta = MyExample5031Meta.class;

    @Override
    protected CreateResult<MyExample5031DTO> doCreateEntity(MyEntity5031 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5031DTO> doUpdateEntity(MyEntity5031 entity, MyExample5031DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5031DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5031DTO> getActions() {
        return Actions.<MyExample5031DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}