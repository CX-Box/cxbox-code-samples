package org.demo.documentation.widgets.emptywidget.showcondition.byparententity.parent;

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
public class MyExample5036Service extends VersionAwareResponseService<MyExample5036DTO, MyEntity5036> {

    private final MyEntity5036Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5036Meta> meta = MyExample5036Meta.class;

    @Override
    protected CreateResult<MyExample5036DTO> doCreateEntity(MyEntity5036 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5036DTO> doUpdateEntity(MyEntity5036 entity, MyExample5036DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5036DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5036DTO> getActions() {
        return Actions.<MyExample5036DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}