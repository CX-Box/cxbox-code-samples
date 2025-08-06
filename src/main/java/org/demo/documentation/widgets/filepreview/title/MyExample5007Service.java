package org.demo.documentation.widgets.filepreview.title;

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
public class MyExample5007Service extends VersionAwareResponseService<MyExample5007DTO, MyEntity5007> {

    private final MyEntity5007Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5007Meta> meta = MyExample5007Meta.class;

    @Override
    protected CreateResult<MyExample5007DTO> doCreateEntity(MyEntity5007 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5007DTO> doUpdateEntity(MyEntity5007 entity, MyExample5007DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5007DTO_.customFieldId, entity::setCustomFieldId);
        setIfChanged(data, MyExample5007DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5007DTO> getActions() {
        return Actions.<MyExample5007DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}