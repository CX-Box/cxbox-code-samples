package org.demo.documentation.widgets.property.sethidden.graph.inner;

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
public class MyExample5020Service extends VersionAwareResponseService<MyExample5020DTO, MyEntity5020> {

    private final MyEntity5020Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5020Meta> meta = MyExample5020Meta.class;

    @Override
    protected CreateResult<MyExample5020DTO> doCreateEntity(MyEntity5020 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5020DTO> doUpdateEntity(MyEntity5020 entity, MyExample5020DTO data, BusinessComponent bc) {
      setIfChanged(data, MyExample5020DTO_.sum, entity::setSum);
      setIfChanged(data, MyExample5020DTO_.productName, entity::setProductName);
      setIfChanged(data, MyExample5020DTO_.clientName, entity::setClientName);
      setIfChanged(data, MyExample5020DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5020DTO> getActions() {
        return Actions.<MyExample5020DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}