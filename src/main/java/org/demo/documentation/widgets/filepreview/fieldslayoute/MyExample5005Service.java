package org.demo.documentation.widgets.filepreview.fieldslayoute;

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
public class MyExample5005Service extends VersionAwareResponseService<MyExample5005DTO, MyEntity5005> {

    private final MyEntity5005Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5005Meta> meta = MyExample5005Meta.class;

    @Override
    protected CreateResult<MyExample5005DTO> doCreateEntity(MyEntity5005 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5005DTO> doUpdateEntity(MyEntity5005 entity, MyExample5005DTO data, BusinessComponent bc) {
      setIfChanged(data, MyExample5005DTO_.customFieldId, entity::setCustomFieldId);
      setIfChanged(data, MyExample5005DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5005DTO> getActions() {
        return Actions.<MyExample5005DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}