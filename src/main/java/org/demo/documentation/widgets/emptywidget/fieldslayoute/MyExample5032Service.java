package org.demo.documentation.widgets.emptywidget.fieldslayoute;

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
public class MyExample5032Service extends VersionAwareResponseService<MyExample5032DTO, MyEntity5032> {

    private final MyEntity5032Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5032Meta> meta = MyExample5032Meta.class;

    @Override
    protected CreateResult<MyExample5032DTO> doCreateEntity(MyEntity5032 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5032DTO> doUpdateEntity(MyEntity5032 entity, MyExample5032DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5032DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5032DTO> getActions() {
        return Actions.<MyExample5032DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}