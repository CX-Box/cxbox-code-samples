package org.demo.documentation.fields.fileupload.types;

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
public class MyExample107Service extends VersionAwareResponseService<MyExample107DTO, MyEntity107> {

    private final MyEntity107Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample107Meta> meta = MyExample107Meta.class;

    @Override
    protected CreateResult<MyExample107DTO> doCreateEntity(MyEntity107 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample107DTO> doUpdateEntity(MyEntity107 entity, MyExample107DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample107DTO_.customFieldId, entity::setCustomFieldId);
        setIfChanged(data, MyExample107DTO_.customField, entity::setCustomField);

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample107DTO> getActions() {
        return Actions.<MyExample107DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}