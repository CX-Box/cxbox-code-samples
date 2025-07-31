package org.demo.documentation.screen.basic;

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
public class MyExample5000Service extends VersionAwareResponseService<MyExample5000DTO, MyEntity5000> {

    private final MyEntity5000Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5000Meta> meta = MyExample5000Meta.class;

    @Override
    protected CreateResult<MyExample5000DTO> doCreateEntity(MyEntity5000 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5000DTO> doUpdateEntity(MyEntity5000 entity, MyExample5000DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample5000DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5000DTO> getActions() {
        return Actions.<MyExample5000DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}