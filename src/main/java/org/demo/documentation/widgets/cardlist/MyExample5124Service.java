package org.demo.documentation.widgets.cardlist;

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
public class MyExample5124Service extends VersionAwareResponseService<MyExample5124DTO, MyEntity5124> {

    private final MyEntity5124Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5124Meta> meta = MyExample5124Meta.class;

    @Override
    protected CreateResult<MyExample5124DTO> doCreateEntity(MyEntity5124 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5124DTO> doUpdateEntity(MyEntity5124 entity, MyExample5124DTO data, BusinessComponent bc) {
      setIfChanged(data, MyExample5124DTO_.customFieldFileId, entity::setCustomFieldFileId);
      setIfChanged(data, MyExample5124DTO_.customFieldFile, entity::setCustomFieldFile);
      setIfChanged(data, MyExample5124DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5124DTO> getActions() {
        return Actions.<MyExample5124DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}