package org.demo.documentation.widgets.emptywidget.base;

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
public class MyExample5022Service extends VersionAwareResponseService<MyExample5022DTO, MyEntity5022> {

    private final MyEntity5022Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5022Meta> meta = MyExample5022Meta.class;

    @Override
    protected CreateResult<MyExample5022DTO> doCreateEntity(MyEntity5022 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5022DTO> doUpdateEntity(MyEntity5022 entity, MyExample5022DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5022DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5022DTO> getActions() {
        return Actions.<MyExample5022DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}