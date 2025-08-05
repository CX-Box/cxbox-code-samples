package org.demo.documentation.widgets.filepreview.showcondition;

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
public class MyExample5006Service extends VersionAwareResponseService<MyExample5006DTO, MyEntity5006> {

    private final MyEntity5006Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5006Meta> meta = MyExample5006Meta.class;

    @Override
    protected CreateResult<MyExample5006DTO> doCreateEntity(MyEntity5006 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5006DTO> doUpdateEntity(MyEntity5006 entity, MyExample5006DTO data, BusinessComponent bc) {
      setIfChanged(data, MyExample5006DTO_.customFieldId, entity::setCustomFieldId);
      setIfChanged(data, MyExample5006DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5006DTO> getActions() {
        return Actions.<MyExample5006DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}