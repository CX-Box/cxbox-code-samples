package org.demo.documentation.widgets.filepreview.base;

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
public class MyExample5003Service extends VersionAwareResponseService<MyExample5003DTO, MyEntity5003> {

    private final MyEntity5003Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5003Meta> meta = MyExample5003Meta.class;

    @Override
    protected CreateResult<MyExample5003DTO> doCreateEntity(MyEntity5003 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5003DTO> doUpdateEntity(MyEntity5003 entity, MyExample5003DTO data, BusinessComponent bc) {
       setIfChanged(data, MyExample5003DTO_.customFieldId, entity::setCustomFieldId);
      setIfChanged(data, MyExample5003DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5003DTO> getActions() {
        return Actions.<MyExample5003DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}