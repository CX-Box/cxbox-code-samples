package org.demo.documentation.feature.meta.buildrowdependentmeta;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3153Service extends VersionAwareResponseService<MyExample3153DTO, MyEntity3153> {

    private final MyEntity3153Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3153Meta> meta = MyExample3153Meta.class;

    @Override
    protected CreateResult<MyExample3153DTO> doCreateEntity(MyEntity3153 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3153DTO> doUpdateEntity(MyEntity3153 entity, MyExample3153DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3153DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3153DTO> getActions() {
        return Actions.<MyExample3153DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

